__author__ = 'piyush'
import os
import datetime as dt

now = dt.datetime.now()
ago = now - dt.timedelta(minutes=1400)
folder = "/home/piyush/linuxworkspace/tmp"
f = open(folder + '/file-report-' + str(now.date()) + '.txt', 'w')
for root, dirs, files in os.walk(folder):
    for fname in files:
        path = os.path.join(root, fname)
        st = os.stat(path)
        mtime = dt.datetime.fromtimestamp(st.st_mtime)
        if mtime > ago:
            print('%s modified %s' % (path, mtime))
            f.write('%s modified %s \n' % (path, str(mtime.isoformat())))
            #f.write(str(path) +" " + "modified " + str(mtime)+ "\n" )
f.close()



