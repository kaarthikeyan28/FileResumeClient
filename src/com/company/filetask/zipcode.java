package com.company.filetask;

import com.sun.rowset.internal.Row;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class zipcode {

    public void processEachZip(String zipFileName){
        try{
            Long startTime = Long.MAX_VALUE;
            Long endTime = Long.MIN_VALUE;
            Long fileModificationTime;
            Long fileCreationTime;

            FileInputStream fileInputStream = new FileInputStream(zipFileName);
            ZipInputStream zipInputStream;
            zipInputStream = new ZipInputStream(new GZIPInputStream(fileInputStream));
            ZipEntry entry = null;


            while((entry = zipInputStream.getNextEntry()) != null){
                if (!entry.isDirectory() && !entry.getName().contains("archivedesc")){
                   // log(logout, out,"File Name : " + entry.getName()); //No I18N
                    System.out.println("Entry name:"+entry.getName());
                    fileModificationTime = entry.getLastModifiedTime().toMillis();
                    if(entry.getCreationTime() != null){
                        fileCreationTime = entry.getCreationTime().toMillis();
                    }
                    else{
                        fileCreationTime = fileModificationTime;
                    }
                  //  log(logout, out,"Last Modified Time : " + fileModificationTime); //No I18N
                    System.out.println("FileMOdify:"+fileModificationTime);
                    if(fileCreationTime < startTime){
                        startTime = fileCreationTime;
                    }
                    if(fileModificationTime > endTime){
                        endTime = fileModificationTime;
                    }
                }
            }
//            log(logout, out,"Start Time : " + startTime); //No I18N
//            log(logout, out,"End Time : " + endTime); //No I18N
//            archiveRow.set("START_TIME", startTime); //No I18N
//            archiveRow.set("END_TIME", endTime); //No I18N
        }
        catch(Exception e){
            e.printStackTrace();
          //  log(logout, out,"exp in processEachZip"); //No I18N
        }

    }

    public static void main(String[] args) {
        zipcode zip =  new zipcode();
        zip.processEachZip("D:\\kunana\\zipfile.zip");
    }
}
