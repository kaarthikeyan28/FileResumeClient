package com.company.filetask.Internet;

import com.company.filetask.Client.FileRead;

 class CheckInternet {
    public boolean netStatus=true;

    public void helloworld() throws Exception{

        while(true) {
            Process process = java.lang.Runtime.getRuntime().exec("ping www.google.com");
            int x = process.waitFor();
            if (x == 0) {
                netStatus = true;
                System.out.println("Connection Successful, "
                        + "Output was " + x);
            }
            else {
                netStatus = false;
                System.out.println("Internet Not Connected, "
                        + "Output was " + x);
            }
        }
    }
    public static void main(String[] args) throws Exception {

    }
}
