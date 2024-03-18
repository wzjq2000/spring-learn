package com.example.serverdemo;

import com.example.serverdemo.pojo.ServerInfo;
import com.example.serverdemo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

@SpringBootApplication
@Slf4j
public class ServerDemoApplication {

//    private static final Logger log = LoggerFactory.getLogger(ServerDemoApplication.class);


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServerDemoApplication.class, args);
        log.info("This is for test");

//        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
//        ObjectName userName = new ObjectName("FengZheng:type=customer,name=customerUserBean");
//        server.registerMBean(new User(),userName);

//        LocateRegistry.createRegistry(8999);
//        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:8999/jmxrmi");
//
//        JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
//        System.out.println("begin rmi start");
//        jcs.start();
//        System.out.println("rmi start");

//        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
//        ObjectName name = new ObjectName("serverInfoMBean:name=serverInfo");
//        server.registerMBean(new ServerInfo(), name);
//
//
//
//        Thread.sleep(60*60*1000);

    }
}
