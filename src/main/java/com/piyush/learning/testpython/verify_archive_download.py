import zipfile
import sys
import os
import traceback
import getopt

from com.m1.ems.mgmt import ManagementContainer, IRecoveryManager
from java.io import FileOutputStream
from java.lang import Integer
from java.lang import Throwable


# This script should be run from "/ems/archive/<cust-id>" directory as archives are downloaded in current directory and
# archive could be larger which may fill the filesystem.

# This script extracts (and removes (default action) after processing) all the chunk[s]. If Export Manager/Recovery Manager
# is failing to download e-discovery archive chunk[s], we can use this to validate archive availibility and integrity
# at the datacenter

# This script takes the following arguments:  cust_id archive_name [resume_chunk] [keep_archive] [output_ids] [user_id]
# where:
# -c cust_id	  : numerical id of the customer
# -a archive_name : the discovery archive filename.  Example : activerecovery.26392.ems
# -r resume_chunk : Optional. If provided, script will download next chunk based on this.
#						  (Only one chunk will be downloaded - for a mailbox-type archive with multiple
#						  users, the first user's chunk will be gotten if -u is not set.)
# -k			  : Optional. By default downloaded archive is removed from file-system after download.
#						  If this flag is opted, downloaded archive won't be removed
# -o			  : Optional. If provided, script will output list of encountered message IDs.
# -u user_id	  : Optional. By default, if the archive is a mailbox-type archive, the archive will be
#						  gotten for all users.  If this is provided, the archive will be gotten for one
#						  particular user.  If the -u flag is given with a user_id of 0, only the first
#						  user archive will be gotten.

# example:  /opt/ems/bin/emsjython ./verify_exportmanager_archive_download.py -c 5659 -a activerecovery.7673.ems

# Export/Recovery Manager use below-mentioned url to download archives.
# https://orangeemsas-2.qa.messageone.com/wfe/getUserArchive.do?archiveName=activerecovery.7673.ems&userName=emsroot@l3-lab501.m1dev.com&password=password&userId=1900123
# In the above example, activerecovery.7673.ems is archive_name
# or
# https://emrs.messageone.com/wfe/getUserArchive.do?archiveName=activerecovery.23384.ems&userName=rcordero@draadvisors.com&password=******&chunkHint=155155184
# In the above example, activerecovery.23384.ems is archive_name and resume_chunk is 155155184

CHUNKHINT = "chunk.hint"
DISCOVERYTYPE = "Discovery Type"
TOTAL = 0

# find chunk hint
def get_chunk_hint(file_name, output_ids):
    global TOTAL

    zipin = zipfile.ZipFile(file_name, 'r')
    if ( not zipfile.is_zipfile(file_name) ):
        print "\nget_chunk_hint:: Either file was not retrieved or not a valid zipfile..returning.."
        return None

    names = zipin.namelist()
    count = 0
    hint = None
    for fpath in names:
        root, fname = os.path.split(fpath)
        if (".key" in fname):
            count = count + 1
            if (output_ids != None):
                print "	Message ID:", fname.rstrip(".key")
        if (fname == CHUNKHINT):
            hint = zipin.read(CHUNKHINT)
            print "get_chunk_hint:: Found chunk hint:", hint

    zipin.close()
    TOTAL = TOTAL + count
    print count, "messages found,", TOTAL, "so far"
    if (hint is None):
        print "get_chunk_hint:: No chunk hint found, ending chunk retrieval"
    return hint


def retrieve_an_archive(cust_id, archive_name, user_id, chunk_hint, file_name, output_ids):
    print "\nretrieve_a_chunk routine:: output file_name is :", file_name

    try:
        outfile_stream = FileOutputStream(file_name)
    except:
        print "retrieve_a_chunk routine:: Failed to open output stream on file : ", file_name, "..returning"
        return None

    # retrieve data
    mc = ManagementContainer.getInstance()
    rm = mc.getRecoveryManager()

    l_cust_id = Integer.parseInt(cust_id);
    l_user_id = Integer.parseInt(user_id);
    sosw = IRecoveryManager.SimpleOutputStreamWrapper(outfile_stream)

    try:
        rm.createPerUserActiveRecoveryArchiveFile(l_cust_id, archive_name, l_user_id, sosw, chunk_hint)
    except:
        print "retrieve_a_chunk routine:: `Exception while creating active recovery archive..returning"
        sys.exc_info()[1].printStackTrace()

        print("*** print_exc:")
        traceback.print_exc(file=sys.stdout)
        outfile_stream.close()
        raise

    outfile_stream.close()
    return get_chunk_hint(file_name, output_ids)


def retrieve_complete_archive(cust_id, archive_name, user_ids, chunk_hint, keep_archive, output_ids):
    # This is single archive download based on chunk_hint
    if (chunk_hint is not None):
        user_id = user_ids[0]
        file_name = cust_id + "_" + user_id + "_" + chunk_hint + ".zip";

        l_chunk_hint = retrieve_an_archive(cust_id, archive_name, user_id, chunk_hint, file_name, output_ids)
        print "\nretrieve_complete_archive routine with hint:: next chunk_hint: ", l_chunk_hint

        #print archive size before deletion
        print "archive file_size = %0.1f MB" % ((os.path.getsize(file_name)) / (1024 * 1024.0))
        if (keep_archive == None):
            os.remove(file_name)

        return

    #download all archives for user
    l_chunk_hint = None
    for user_id in user_ids:
        while ( True ):
            #archive file that will be created on  filesystem now.
            file_name = cust_id + "_" + user_id + "_" + ((l_chunk_hint == None) and "0" or l_chunk_hint) + ".zip";
            try:
                l_chunk_hint = retrieve_an_archive(cust_id, archive_name, user_id, l_chunk_hint, file_name, output_ids)
            except:
                Throwable, t:
                t.printStackTrace()
                l_chunk_hint =
                continue

        #print archive size before deletion
        print "archive file_size = %0.1f MB" % ((os.path.getsize(file_name)) / (1024 * 1024.0))
        if (keep_archive == None):
            os.remove(file_name)

        if (l_chunk_hint == None):
            break


    def find_user_ids_in_archive(cust_id, archive_name):
        archive_path = "/ems/archive/" + cust_id + "/" + archive_name
        fexists = os.path.exists(archive_path)
        if fexists:
            archive_file = open(archive_path, 'r')
            #skip 1st line, this is archive recovery type. e.g: EMS Active Recovery Archive 6.0
            line = archive_file.readline()
            if (line == None):
                print "\nfind_user_ids_in_archive routine:: archive file is not valid..1"
                return None
                #validate it's a discovery archive "Discovery Type"
            line = archive_file.readline()
            if (line == None):
                print "\nfind_user_id_in_archive routine:: archive file is not valid..2"
                return None
            user_ids = []
            while True:
                line = archive_file.readline()
                if not line:
                    break
                else:
                    user_ids.append(line.split('\t')[0])
            if (user_ids == []):
                return None
            else:
                return user_ids
        else:
            print "\nfind_user_ids_in_archive routine:: archive file doesn't exist.."
            return None


    def show_usage_and_exit():
        print "\nUsage:"
        print "/opt/ems/bin/emsjython ./verify_exportmanager_archive_download.py -c cust_id -a archive_name [-r resume_chunk] [-k] [-o] [-u [user_id]]\n"
        print "This script takes the following arguments:  cust_id archive_name [resume_chunk] [keep_archive]"
        print "where:"
        print "	-c cust_id      : numerical id of the customer."
        print "	-a archive_name : the discovery archive filename. Example : activerecovery.26392.ems "
        print "	-r resume_chunk : Optional. If provided, script will download the next single chunk based on this."
        print "                       (Only one chunk will be downloaded - for a mailbox-type archive with multiple"
        print "                       users, the first user's chunk will be gotten if -u is not set.)"
        print "	-k              : Optional. By default downloaded archive is removed from file-system after download."
        print "	                      If this flag is opted, downloaded archive will stay in filesystem."
        print "	-o              : Optional. If provided, script will output message IDs that it encounters."
        print "	-u user_id      : Optional. By default, if the archive is a mailbox-type archive, the archive will be"
        print "                       gotten for all users.  If this is provided, the archive will be gotten for one"
        print "                       particular user.  If the -u flag is given with a user_id of 0, only the first "
        print "                       user archive will be gotten."
        print "Example:"
        print "/opt/ems/bin/emsjython ./verify_exportmanager_archive_download.py -c 5659 -a activerecovery.7673.ems [-r 345678988] [-k] [-o]\n"
        sys.exit(-1)


    if __name__ == "__main__":

        cust_id = None
        archive_name = None
        resume_chunk = None
        keep_archive = None
        output_ids = None
        use_user_id = None

        try:
            options, remainder = getopt.getopt(sys.argv[1:], "c:a:r:u:ko?", [])
        except getopt.GetoptError, err:
            print str(err)
            show_usage_and_exit()

        for opt, arg in options:
            if opt == '-c':
                cust_id = arg
            elif opt == '-a':
                archive_name = arg
            elif opt == '-r':
                resume_chunk = arg
            elif opt == '-k':
                keep_archive = 'keep'
            elif opt == '-o':
                output_ids = 'output'
            elif opt == '-u':
                use_user_id = arg
            elif opt == '-?':
                show_usage_and_exit()

        if (len(remainder) != 0):
            print "\nInvalid arguments passed."
            show_usage_and_exit()

        if (cust_id == None or archive_name == None):
            print "\ncust_id or archive_name is missing. These are required arguments."
            show_usage_and_exit()

        user_ids = find_user_ids_in_archive(cust_id, archive_name)
        if (user_ids == None):
            print "\narchive file doesn't have any user. will exit.."
            sys.exit(-1)
        elif (use_user_id != None):
            if (use_user_id == 0):
                user_ids = [user_ids[0]]
            elif (use_user_id in user_ids):
                user_ids = [use_user_id]
            else:
                print "given user_id ", use_user_id, " not contained in archive"
                sys.exit(-1)

        print "\ncust_id:", cust_id, " archive_name:", archive_name, "user_ids:", user_ids, "resume_chunk:", resume_chunk, "keep_archive:", keep_archive, "output_ids:", output_ids

        retrieve_complete_archive(cust_id, archive_name, user_ids, resume_chunk, keep_archive, output_ids)
        print "\nFinished validating the archive for cust_id:", cust_id, "archive_name:", archive_name
        print TOTAL, "emails found in archive"



