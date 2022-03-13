package com.company.filetask.File;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileTransfer {

    public static int bytesToMb(File file){
        long fileSizeInBytes = file.length();
// Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
        long fileSizeInKB = fileSizeInBytes / 1024;
// Convert the KB to MegaBytes (1 MB = 1024 KBytes)
        int fileSizeInMB = (int) fileSizeInKB / 1024;
        return fileSizeInMB;
    }

    public static List<File> splitFile(File file, int sizeOfFileInMB) throws IOException {
        int counter = 1;
        List<File> files = new ArrayList<File>();
        int sizeOfChunk = 1024 * 1024 * sizeOfFileInMB;
        String eof = System.lineSeparator();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String name = file.getName();
            String line = br.readLine();
            while (line != null) {
                File newFile = new File(file.getParent(), name + "." + String.format("%03d", counter++));
                try (OutputStream out = new BufferedOutputStream(new FileOutputStream(newFile))) {
                    int fileSize = 0;
                    while (line != null) {
                        byte[] bytes = (line + eof).getBytes(Charset.defaultCharset());
                        if (fileSize + bytes.length > sizeOfChunk) break;
                        out.write(bytes);
                        fileSize += bytes.length;
                        line = br.readLine();
                    }
                }
                files.add(newFile);
            }
        }
        return files;
    }


    public static void main(String[] args) throws Exception{
        File file = new File("D:\\TransferFiles\\rdpd.pdf");

        int fileSizeInMB = bytesToMb(file);

        System.out.println("Total File Size:"+fileSizeInMB);


        List<File> fileFolder = splitFile(file,fileSizeInMB);

        for(File fi : fileFolder ){
            int length = bytesToMb(fi);
            System.out.println(fi+" "+length);
        }

        // System.out.println(splitFile(file,fileSizeInMB));
    }
}
