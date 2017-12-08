package com.incra;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        logger.error("main starting");

        Server server = new Server(8080);

        ServletContextHandler sch = new ServletContextHandler(server, "/");
        ServletHolder jerseyServletHolder = new ServletHolder(new ServletContainer());
        jerseyServletHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, MainApplication.class.getCanonicalName());
        sch.addServlet(jerseyServletHolder, "/*");

        server.start();
        server.join();
    }
}