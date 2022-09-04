package com.poortoys.examples;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.Files.readAllBytes;

public class AppMain {

    public static void main(String[] args) throws IOException {
        System.out.println("Adinizi daxil edin:");
        String name=new Scanner(System.in).nextLine();
        System.out.println("Soyadinizi daxil edin:");
        String surname=new Scanner(System.in).nextLine();
        System.out.println("Zəhmət olmasa göndərmək istədiyiniz faylın yerləşdiyi keçidi qeyd edin");
        String fileName=new Scanner(System.in).nextLine();
        System.out.println("bu şəkli göndərmək istədiyiniz şəxsin(serverin) ip və portunu daxil edin:");
        String ipAndPort=new Scanner(System.in).nextLine();
        String[]arr=ipAndPort.split(":");
        String ip=arr[0];
        int port=Integer.parseInt(arr[1]);

        Socket socket=new Socket(ip,port);
        OutputStream outputStream=socket.getOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(outputStream);

        byte[] bytes= readAllBytes(Paths.get(fileName));

        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        socket.close();
    }

}
