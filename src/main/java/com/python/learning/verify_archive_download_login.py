__author__ = 'piyush'

from com.m1.ems.mgmt import ManagementContainer,IAuthenticationManager,UserLoginResult
from com.m1.ems.ws.registration import EMSRegistrationService
from java.lang import *
import sys, os, os.path, traceback, getopt


def show_usage_and_exit():
    print "\nUsage:"
    print "/opt/ems/bin/emsjython ./verify_archive_download_login.py -u user_id -p password [-o] originator -r role \n"
    print "This script takes the following arguments:  user_id password [originator] role "
    print "where:"
    print " -u user_id      : User Id of the user who is downloading the archive ."
    print " -p password     : Password of the user  "
    print " -r role         : Optional Login Roles of a user for e.g <admin> <superadmin> <emsroot> ."
    print " -o              : Optional Originator of the request usually GetUserArchiveAction ."
    print "Example:"
    print "/opt/ems/bin/emsjython ./verify_archive_download_login.py -u testingpiyush -p !mailst0rm -r superadmin "
    sys.exit(-1)


if __name__ == "__main__":
    user_id = None
    password = None
    originator = "GetUserArchiveAction"
    role = None

    try:
        options, remainder = getopt.getopt(sys.argv[1:], "u:p:ro?", [])
    except getopt.GetoptError, err:
        print str(err)
        show_usage_and_exit()

    for opt, arg in options:
        if opt == '-u':
            user_id = arg
        elif opt == '-p':
            password = arg
        elif opt == '-r':
            role = arg
        elif opt == '-o':
            originator = 'GetUserArchiveAction'
        elif opt == '-?':
            show_usage_and_exit()

    if (len(remainder) != 0):
        print "\nInvalid arguments passed."
        show_usage_and_exit()

    if (user_id==None or password==None):
        print "\n User_id, Password is must to validate the Login."
        show_usage_and_exit()

    try:
        print "Getting Login Authentication for the User ", user_id
        loginRoles = EMSRegistrationService.ROLES_CAN_GET_PRIVATE_KEY;
        resp = ManagementContainer.getInstance().getAuthenticationManager().loginUserOverrideRolesIfReviewer(user_id, password, "GetUserArchiveAction", loginRoles);
        print "Authentication status of User for Downloading the Archive " , resp.getStatus();
    except:
        print 'Exception', sys.exc_info(), traceback.print_exc(file=sys.stderr)







