package com.company.filetask.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUpload {
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void uploadFile(String SessionId) throws IOException {

        System.out.println("printing sessionID :"+SessionId);

        Scanner sc = new Scanner(System.in);
        System.out.println("UPLOAD FILE CLASS !");

        System.out.println("Enter you filePath:");
        filePath = "D:\\Upload\\crop.pdf";
        System.out.println("FilePath: "+filePath);

        CloseableHttpClient fileClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:8080//FileUpload");
        List<NameValuePair> fileparam = new ArrayList<NameValuePair>();
        fileparam.add(new BasicNameValuePair("filePath",filePath));
        fileparam.add(new BasicNameValuePair("sessionID",SessionId));
        httpPost.setEntity(new UrlEncodedFormEntity(fileparam));
        fileClient.execute(httpPost);

        CloseableHttpResponse response = fileClient.execute(httpPost);
        final int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode==200) System.out.println("File Connection Successfull !");
        else System.out.println("Unsuccessfull - "+statusCode);

        System.out.println("Upload Successful !");
    }
    //baeldung java code for file upload -multipart
//    public void whenGetUploadFileProgressUsingHttpClient_thenCorrect()
//            throws ClientProtocolException, IOException {
//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost("http://www.example.com");
//
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addBinaryBody(
//                "file", new File("test.txt"), ContentType.APPLICATION_OCTET_STREAM, "file.ext");
//        HttpEntity multipart = builder.build();
//
//        ProgressEntityWrapper.ProgressListener pListener =
//                percentage -> assertFalse(Float.compare(percentage, 100) > 0);
//        httpPost.setEntity(new ProgressEntityWrapper(multipart, pListener));
//
//        CloseableHttpResponse response = client.execute(httpPost);
//        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
//        client.close();
//    }
}
