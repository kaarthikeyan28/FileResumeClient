package com.company.filetask.Client;

import com.company.filetask.Ping.Google;

import java.io.File;

public class FileRead {
    public void mainProgram() throws InterruptedException {

       if(Google.netStatus){
            for (int i = 0; i < 2000; i++) {
                System.out.println(i);
            }
        }
       else{
           System.out.println("Sorry ! , Not able to connect ");
       }
    }

    public static void main(String[] args) throws Exception {
        FileRead fileRead = new FileRead();
        fileRead.mainProgram();

    }
}
