package com.piyush.learning.hackerrank;

///Complete this code or write your own from scratch
import java.util.*;

class TelephoneBook {

    public static void main(String [] args ){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map phoneBook = new HashMap();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            if(!phoneBook.containsKey(name)){
                phoneBook.put(name , phone);
            }

        }
        while(in.hasNext()){
            String contactName = in.next();
            // Write code here
            if(phoneBook.containsKey(contactName)){
                Integer phone = (Integer) phoneBook.get(contactName);
                System.out.println(contactName +"="+ phone.intValue());
            }else{
                System.out.println("Not found");
            }

        }
        in.close();
    }
}
