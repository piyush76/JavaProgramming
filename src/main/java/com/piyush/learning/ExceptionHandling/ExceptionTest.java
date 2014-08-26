package com.piyush.learning.ExceptionHandling;

/**
 * Created with IntelliJ IDEA.
 * User: poonamgupta78
 * Date: 7/30/14
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */


import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try{
            testException(-5);
            testException(-10);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            System.out.println("Releasing resources");
        }
        testException(15);
    }

    public static void testException(int i) throws FileNotFoundException, IOException{
        if(i < 0){
            FileNotFoundException myException = new FileNotFoundException("Negative Integer "+i);
            throw myException;
        }else if(i > 10){
            throw new IOException("Only supported for index 0 to 10");
        }

    }

}
