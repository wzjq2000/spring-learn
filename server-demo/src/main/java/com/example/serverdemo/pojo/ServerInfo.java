package com.example.serverdemo.pojo;

public class ServerInfo implements ServerInfoMBean {

    @Override
    public int getExecutedSqlCmdCount() {
        return 1;
    }
}
