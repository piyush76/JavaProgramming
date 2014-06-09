import sys
import psycopg2

if __name__ == '__main__':

    f = open("testMsgId", 'r')
    out = f.readlines()

    conn = psycopg2.connect(database="emsukam-1", user="postgres", password="postgres", host="127.0.0.1", port="5432")
    print "Opened database successfully"
    for msg_id in out:
        cur = conn.cursor()
        cur.execute("select partition_id from dat_repl_message_key_map where m1_message_id=" + msg_id)
        rows = cur.fetchall()
        for row in rows:
            print "Message id ", msg_id.strip(), "PartitionId = ", row[0]
    conn.close()















