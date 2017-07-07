package com.piyush.learning.hackerrank;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Piyush_G on 7/7/2017.
 */
public class ReadHostFile {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();
        System.out.println(filename);
        //Path currentRelativePath = Paths.get("");
        //String s = currentRelativePath.toAbsolutePath().toString();

        FileInputStream fstream = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        File out = new File("record_host_access.txt");
        FileOutputStream fos = new FileOutputStream(out);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        Map<String,Integer> map= new HashMap<String,Integer>();
        String line;

        while ((line = br.readLine()) != null) {
            String[] arr = line.split("- - ");
            String hostname = arr[0];
            if (map.containsKey(hostname)){
                map.put(hostname, map.get(hostname)+1);
            }else{
                map.put(hostname, 1);
            }
        }
        int count = 0 ;
        System.out.println(map.toString());

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println("HostName = " + next.getKey() + "Count  = "  + next.getValue());
            bw.write(next.getKey());
            bw.write("=");
            bw.write(next.getValue().toString());
            bw.newLine();
        }
        bw.close();
        br.close();
    }

}


