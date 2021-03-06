package ru.ryabtsev.spring.launcher;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.EnumSet;

public class Launcher {

    private static final int DEFAULT_SERVER_PORT = 8189;

    public static void main(String[] args) {
        Server server = new Server(DEFAULT_SERVER_PORT);

        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/*");
        webapp.setWar(location.toExternalForm());
        webapp.addFilter(new FilterHolder(new DelegatingFilterProxy("springSecurityFilterChain")), "/*", EnumSet.allOf(DispatcherType.class));

        server.setHandler(webapp);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
