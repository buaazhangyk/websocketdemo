package com.zhangyk;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.FileInputStream;

/**
 * Created by yunkai on 7/8/17.
 */
public class JettyServer {

    public static void main(String[] args) {

        try {
            XmlConfiguration config = new XmlConfiguration(new FileInputStream("src/main/resources/jetty/jetty.xml"));
            Server server = new Server();
            config.configure(server);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }
}
