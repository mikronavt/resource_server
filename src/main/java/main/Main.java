package main;

import recources.DBParametersResource;
import sax.ReadXMLFileSAX;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.util.Properties;

/**
 * Created by User on 03.03.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        /*
        Testing properties

         */
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);

            System.out.println(properties.getProperty("database"));
            System.out.println(properties.getProperty("dbuser"));
            System.out.println(properties.getProperty("dbpassword"));

        } catch(IOException ex){
            ex.printStackTrace();
        }

        /*
        Testing work with SAX
         */

        DBParametersResource resource = (DBParametersResource) ReadXMLFileSAX.readXML("./data/MySqlResource.xdb");
        System.out.println(resource);

        /*
        testing NIO
         */

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
    }
}
