package com.example.clientdemo;

import java.net.InetAddress;

import java.net.UnknownHostException;

//待删除
public class GetIPAddress {
    public static void main(String[] args) {
        try {
            InetAddress ipAddress = InetAddress.getLocalHost();
            String currentIP = ipAddress.getHostAddress();
            System.out.println("当前IP地址: " + currentIP);

            InetAddress localHost = InetAddress.getLocalHost();
            String hostname = localHost.getHostName();
            System.out.println("当前主机名: " + hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
