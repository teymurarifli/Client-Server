package com.poortoys.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) throws IOException {
        ServerSocket socket=new ServerSocket(6789);
        while (true){
            System.out.println("gozleyir");
            Socket connection=socket.accept();
            System.out.println("gonderildi");
        }
    }

}
