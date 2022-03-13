package com.company.filetask.Internet;

import java.io.*;

public class Code {
    public static void main(String[] args) throws IOException {
       // if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
            String path = "D:\\Upload\\reactJS.pdf" ;
            File filepath = new File(path);
            DataInputStream in = new DataInputStream(new FileInputStream(path));
            int formDataLength = (int) filepath.length();

            System.out.println(formDataLength);

            byte dataBytes[] = new byte[formDataLength];
            int byteRead = 0;
            int totalBytesRead = 0;
            while (totalBytesRead < formDataLength) {
                byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
//                totalBytesRead = totalBytesRead + byteRead;

            }
            String file = new String(dataBytes);

            String saveFile = "D:\\destination\\nathan.pdf";

            FileOutputStream fileOut = new FileOutputStream(saveFile);
            fileOut.write(dataBytes, 0, formDataLength );

            fileOut.flush();
            fileOut.close();
    }
}
