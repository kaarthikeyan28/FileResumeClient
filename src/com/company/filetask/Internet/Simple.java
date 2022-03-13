package com.company.filetask.Internet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;


public class Simple {
    public static void main(String[] args) throws IOException {

        String pathfile="D:\\Upload\\fileoutput.txt";
        Path path = Paths.get(pathfile);
        long bytes = Files.size(path);
        System.out.println("TOTAL BYTES : ");
        System.out.println(String.format("%,d bytes", bytes));

        File fileDirect = new File(pathfile);

        ServletOutputStream out =null;

        DataInputStream in= null;
        in = new DataInputStream(new FileInputStream(fileDirect));

        DataOutputStream dataOutputStream  = new DataOutputStream(new FileOutputStream("D:\\destination\\nat.txt"));

        FileOutputStream fileOut;
        fileOut = new FileOutputStream(fileDirect);

       // int len = (int) fileDirect.length();
        int len = (int) bytes;
        System.out.println("length of file : "+len); //172673
        byte databytes[]= new byte[len+10];
        int readBytes =0;
        int readBytestotal =0;
        int n=0;


        for(byte transfer : databytes){

            dataOutputStream.write(transfer);

            fileOut.write(transfer);
            int size = dataOutputStream.size();
            System.out.print("printing size:"+size);
        }

//        while (fileSize > 0 && (n = dis.read(buf, 0, (int)Math.min(buf.length, fileSize))) != -1)
//        {
//            fos.write(buf,0,n);
//            fileSize -= n;
//        }
//
////        while(readBytestotal < len)
////        {
//            readBytes= in.read(databytes, readBytestotal, len);
//            readBytestotal = readBytestotal +  readBytes;
//
//            System.out.println("Currently:"+ databytes);
//
//            //dataOutputStream.write(readBytes);
//           // int size = dataOutputStream.size();
//
//            //System.out.println("Transferred size : "+size);
//
//            System.out.println("Sending file ... " + (readBytestotal * 100) / len + "% complete!");
//       // }
//
//        String fileStatus="";
//        if(readBytestotal == len) {
//            fileStatus = "Success";
//        }
//        else {
//            fileStatus="Failure";
//        }


//        String file= new String(databytes);
//
//        String directory= "";
//        if (file.indexOf("name=\"Directory\"") >0)
//        {
//            directory= file.substring(file.indexOf("name=\"Directory\""));
//            directory = directory.substring(directory.indexOf("\n")+1);
//            directory = directory.substring(directory.indexOf("\n")+1);
//            directory = directory.substring(0, directory.indexOf("\n")-1);
//        }
//        else {
//            out.println("Invalid Directory !");
//        }
//
////filename
//        String saveFile= file.substring(file.indexOf("filename=\"")+10);
//        saveFile= saveFile.substring(0,saveFile.indexOf("\n"));
//        saveFile= saveFile.substring(saveFile.lastIndexOf("\\")+1, saveFile.indexOf("\""));
//
//        int pos;
//
//        pos=file.indexOf("filename=\"");
//
//        pos=file.indexOf("\n", pos)+1;
//
//        pos=file.indexOf("\n", pos)+1;
//
//
//
//        String filename= new String(directory + saveFile);
//
//
//        System.out.println("New File NAme : "+filename);
//        File chkFile = new File(filename);
//
//        File fileDir = new File(directory);
//
//        double kbfile = (double) file.length()/1024;
//
//        System.out.println("File in KiloBytes:"+kbfile);


//                    fileOut.write(file.getBytes(), 0, file.length());


    }
}

