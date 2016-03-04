package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import recources.DBParametersResource;
import resourceServer.ResourceServer;
import resourceServer.ResourceServerController;
import resourceServer.ResourceServerControllerMBean;
import resourceServer.ResourceServerI;
import sax.ReadXMLFileSAX;
import servlets.ResourceServerServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.management.ManagementFactory;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.util.Properties;

/**
 * Created by User on 03.03.2016.
 */
public class Main {
    static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception{
        /*
        Testing properties - closed

         */
        /*Properties properties = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);

            System.out.println(properties.getProperty("database"));
            System.out.println(properties.getProperty("dbuser"));
            System.out.println(properties.getProperty("dbpassword"));

        } catch(IOException ex){
            ex.printStackTrace();
        } */

        /*
        Testing work with SAX - closed
         */

        /*
        DBParametersResource resource = (DBParametersResource) ReadXMLFileSAX.readXML("./data/MySqlResource.xdb");
        System.out.println(resource);
        */

        /*
        testing NIO - closed
         */

        /*
        RandomAccessFile aFile = new RandomAccessFile("data/data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(64);

        int bytesRead = inChannel.read(buf);
        while (bytesRead!=-1){
            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()){
                System.out.println((char) buf.get());
            }

            System.out.println("\n");
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
        */

        int port = 8080;

        ResourceServerI resourceServer = new ResourceServer();

        ResourceServerControllerMBean controller = new ResourceServerController(resourceServer);

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(controller, name);



        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new ResourceServerServlet(resourceServer)), ResourceServerServlet.PAGE_URL);

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("static");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});
        server.setHandler(handlers);

        server.start();
        logger.info("Server started");

        server.join();


    }
}
