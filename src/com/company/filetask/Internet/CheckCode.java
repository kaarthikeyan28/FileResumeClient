package com.company.filetask.Internet;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CheckCode {
    public static void main(String[] args) throws IOException {

                String path = "D:\\Upload\\reactJS.pdf" ;
                File filepath = new File(path);
                DataInputStream in = new DataInputStream(new FileInputStream(path));
                int formDataLength = (int) filepath.length();

                System.out.println(formDataLength);

                byte dataBytes[] = new byte[formDataLength];
                int byteRead = 0;
                int totalBytesRead = 0;

                String file = new String(dataBytes);

                String saveFile = "D:\\destination\\reactJS.pdf";
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


                for(int i=totalBytesRead ; i<formDataLength ; i++){

                    byteRead = in.read(dataBytes,totalBytesRead,formDataLength);

                    int transferred = i;

                    System.out.println("Now Tranferred:"+transferred);
                    fileOut.write(dataBytes[i]);

                    fileOut.flush();
                }

                fileOut.close();


            }
        }
