######################################
# getMessageRetainStatus.py
# @auther piyush_g
# This script will fetch the retention status of the message_id
# usage: sudo /opt/ems/bin/emsjython getMessageRetainStatus.py <fileName> 
# e.g: sudo /opt/ems/bin/emsjython getMessageRetainStatus.py testMsgId.txt
#######################################

import os
import sys
import time
import pdb
import traceback
from com.m1.ems.mgmt import ManagementContainer
from com.m1.util.db import DbUtils


if __name__ == '__main__':

    if len(sys.argv) != 2:
        print 'Usage:', sys.argv[2], 'Please provide Message Id file'
        sys.exit(1)

    else:
        file_name = sys.argv[1]
        f = open(file_name)
        out = f.readlines()

        mc = ManagementContainer.getInstance()
        conn = mc.getDBConnection(ManagementContainer.AM_POOL_NAME)
        pm = mc.getPartitionManager()
        s = None
        rs = None
        #partIdList = []
        data = dict()
        try:
            s = conn.createStatement()
            done = False
            id = -1
            for msg_id in out:
                sql = 'select partition_id from dat_repl_message_key_map where m1_message_id=' + msg_id
                rs = s.executeQuery(sql)
                if rs.next():
                    id = rs.getInt(1)
                    if id > 0:
                        print "Message id ", msg_id.strip(), "PartitionId = ", id
                        data.update({msg_id: id})
                        #partIdList.append(id)
                        conn.commit()
                    else:
                        done = True

        finally:
            conn.rollback()
            DbUtils.safeClose(rs)
            DbUtils.safeClose(s)
            mc.safeReturnDBConnection(conn, ManagementContainer.AM_POOL_NAME)

            for key in data:
                print "executing command for msgId ", key.strip(), "partId ", data[key]
                optCmd = "/opt/ems/bin/amp purge-v2 -P -i " + str(
                    data[key]) + " -w 'md.m1_message_id=" + key.strip() + "\' " + "2>/dev/null"
                print optCmd
                os.system(optCmd)

        sys.exit(0)
