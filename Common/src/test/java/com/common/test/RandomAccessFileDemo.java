package com.common.test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
* Java Program to read and write UTF String on RandomAccessFile in Java.
*
* @author Javin Paul
*/
public class RandomAccessFileDemo{

    public static void main(String args[]) {

        String data = "KitKat (4.4 - 4.4.2)";
        writeToRandomAccessFile("sample.store", 100, data);
        System.out.println("String written into RandomAccessFile from Java Program : " + data);

        String fromFile = readFromRandomAccessFile("sample.store", 100);
        System.out.println("String read from RandomAccessFile in Java : " + fromFile);

    }

    /*
     * Utility method to read from RandomAccessFile in Java
     */
    public static String readFromRandomAccessFile(String file, int position) {
        String record = null;
        try {
            RandomAccessFile fileStore = new RandomAccessFile(file, "rw");

            // moves file pointer to position specified
            fileStore.seek(position);

            // reading String from RandomAccessFile
            record = fileStore.readUTF();

            fileStore.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return record;
    }

   /*
    * Utility method for writing into RandomAccessFile in Java
    */  
    public static void writeToRandomAccessFile(String file, int position, String record) {
        try {
            RandomAccessFile fileStore = new RandomAccessFile(file, "rw");

            // moves file pointer to position specified
            fileStore.seek(position);

            // writing String to RandomAccessFile
            fileStore.writeUTF(record);

            fileStore.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//Read more: http://javarevisited.blogspot.com/2015/02/randomaccessfile-example-in-java-read-write-String.html#ixzz4CIKMuplZ

