package com.company.filetask.Internet;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class NewCode{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        CheckInternetConnection check = new CheckInternetConnection();

        String path = "D:\\Upload\\03Jan.odt" ;
        File filepath = new File(path);
        DataInputStream in = new DataInputStream(new FileInputStream(path));
        int formDataLength = (int) filepath.length();

        System.out.println(formDataLength);

        byte dataBytes[] = new byte[formDataLength];
        int byteRead = 0;
        int totalBytesRead = 0;

        String file = new String(dataBytes);

        String saveFile = "D:\\destination\\check.odt";
        FileOutputStream fileOut = new FileOutputStream(saveFile);

//        while (totalBytesRead < formDataLength) {
//            byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
//            totalBytesRead = totalBytesRead + byteRead;
//
//            //fileOut.write(totalBytesRead);
//
//            System.out.println("ByteRead - INT:"+byteRead);
//            System.out.println("TotalBytesRead:"+totalBytesRead);
//            System.out.println("DataBytes :"+ Arrays.toString(dataBytes));
//            fileOut.write(dataBytes[0]);
//            fileOut.flush();
//        }

        String user="";

        for(int i=totalBytesRead ; i<formDataLength ; i++){

//            if(check.checkConnection()){
//                fileOut.write(dataBytes[i]);
//            }
//            else{
//                System.out.println("Internet is Down !");
//                System.out.println("Resume File Transfer ?");
//                user = "yes";
//            }
         //   if(user.equals("yes") && check.checkConnection())

                //call a method here to check interent and resume code

            byteRead = in.read(dataBytes,totalBytesRead,formDataLength);

            int transferred = i;

            fileOut.write(i);



            //System.out.println("Now Tranferred:"+transferred);


            fileOut.flush();
        }

        fileOut.close();


    }
}
