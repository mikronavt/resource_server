package main;

import recources.DBParametersResource;
import sax.ReadXMLFileSAX;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by User on 03.03.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);

            System.out.println(properties.getProperty("database"));
            System.out.println(properties.getProperty("dbuser"));
            System.out.println(properties.getProperty("dbpassword"));

        } catch(IOException ex){
            ex.printStackTrace();
        }


        DBParametersResource resource = (DBParametersResource) ReadXMLFileSAX.readXML(".//data//MySqlResource.xdb");
        System.out.println(resource);
    }
}
