package com.company.filetask.Ping;

public class NewOne {
    public static void mainProgram() throws InterruptedException {

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
       mainProgram();
    }
}
