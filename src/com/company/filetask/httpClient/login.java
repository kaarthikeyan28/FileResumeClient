package com.company.filetask.httpClient;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import sun.net.www.http.HttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.net.URI;

//    Kaarthikeyan
//    Kaarthi@28
//    D:\Upload\reactJS.pdf

public class login {
    private static String userName;
    private static String password;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        login.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        login.password = password;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------******************---------");
        System.out.println("Enter your name:");
        userName = "kaarthi";

        System.out.println("Enter your password:");
        password = "keyan";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080//Login");

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", userName));
        params.add(new BasicNameValuePair("password", password));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
//        HttpResponse response = client.send(httpPost, HttpResponse.BodyHandlers.ofString());
//
        CloseableHttpResponse response = client.execute(httpPost);
        InputStream is = response.getEntity().getContent();
//        InputStream inputStream = new FileInputStream("D:/sample.txt");
//        //creating an InputStreamReader object
        InputStreamReader isReader = new InputStreamReader(is);
        //Creating a BufferedReader object
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine())!= null){
            sb.append(str);
        }
        String sessionID = sb.toString();

        System.out.println("Session ID from IntelliJ - "+ sessionID);
        final int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode==200) System.out.println("Connection Successfull !");
        else System.out.println("Unsuccessfull - "+statusCode);

        //fileupload class is called !
        FileUpload fileUpload  = new FileUpload();
        fileUpload.uploadFile(sessionID);

    }
}
