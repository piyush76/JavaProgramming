package com.piyush.learning.datastructure.datastructure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by piyush on 8/15/14.
 * write a simple compression algorithm to change aaabbbcccaabbbbc into: a3b3c3a2b4c1
 * Run-length encoding
 *
 */
public class StringCompressionAlgorithm {

    public static void main(String[] args) {

        String str = "aaabbbcccaabbbbc";

        System.out.println("Original String "+ str + " Compressed " +  compressString(str));

        System.out.println(decode(encode(str)));
        System.out.println(encode(str));

    }

    public static String compressString(String str) {

        String compressed="";

        char ch=0;
        int count=1;
        for (int x = 0; x < str.length(); x++) {
            if (ch == str.charAt(x)){
                count = count + 1;
            } else {
                compressed = compressed + ch;
                if(count != 1){
                    compressed = compressed + count;
                }
                ch = str.charAt(x);
                count = 1;
            }
        }
        compressed = compressed + ch;
        if(count != 1){
            compressed = compressed + count;
        }

        System.out.println("Compressed: " + compressed);
        return compressed;
    }

    public static String decode(String source) {
        StringBuffer dest = new StringBuffer();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            matcher.find();
            while (number-- != 0) {
                dest.append(matcher.group());
            }
        }
        return dest.toString();
    }

    public static String encode(String source) {
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while (i + 1 < source.length()
                    && source.charAt(i) == source.charAt(i + 1)) {
                runLength++;
                i++;
            }
            dest.append(runLength);
            dest.append(source.charAt(i));
        }
        return dest.toString();
    }

}
