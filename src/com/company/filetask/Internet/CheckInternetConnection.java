package com.company.filetask.Internet;


import com.company.filetask.Client.FileRead;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.Principal;
import java.util.*;
import java.net.URL;
import java.net.URLConnection;

public class CheckInternetConnection{

    Scanner sc = new Scanner(System.in);
    public String checkConnection="";
    public boolean isNetDown = false;
    public boolean isStop=false;





//    public boolean checkConnection() throws IOException {
//        try {
//            URL u = new URL("http://2a59-49-206-119-34.ngrok.io "); //ngrok url
//
//            URLConnection conn = u.openConnection();
//            conn.connect();
//            System.out.println("Check - Connected !");
//            return true;
//        }
//        catch (Exception e){
//            System.out.println("Check - Not connected ! ");
//
//            //stop main program instance and ask for file resume !
//            return false;
//
//        }
//    }

//    public void run() {
//        try {
//            boolean check = checkConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }



//    public void run() {
//        try
//        {
//            URL u = new URL("http://2a59-49-206-119-34.ngrok.io"); //ngrok url
//
//            URLConnection conn = u.openConnection();
//            conn.connect();
//
//            //set boolean from server
//
//            isNetDown = false;
//
//            System.out.println("Connection Established !");
//
//        }
//
//        //handle execptions - connection , internet connection
//        catch (Exception e){
//            isNetDown = true;
//
//            while(true) {
//                System.out.println("Internet is down !");
//                System.out.println("Do you want to resume ?(Type yes)");
//                checkConnection = sc.nextLine();
//
//                if (checkConnection.equals("yes")) {
//                    try {
//                        if (checkConnection()) {
//                            fileRead.notify();
//                            break;
//                        }
//                        else {
//                            fileRead.wait();
//                        }
//                    }
//                    catch (IOException | InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//                else{
//                    isStop=true;
//                    break;
//                }
//                //update in uploadServlet java file (checking everytime in while loop )
//                // file.setInternetCheck(false);
//
//            }
//
//
//        }
//    }

    public synchronized void callMethod() throws InterruptedException {
        while(true){
            if(isNetDown) {
                wait();
            }
        }
    }

//    public static void main(String[] args) throws InterruptedException, IOException {
//
//        CheckInternetConnection check = new CheckInternetConnection();
//        //System.out.println(check.checkConnection());
//
//        System.out.println(check.getConnection());
//    }
}