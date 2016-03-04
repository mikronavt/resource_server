package sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by User on 04.03.2016.
 */
public class ReadXMLFileSAX {
    public static Object readXML(String xmlFile){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            SaxHandler handler = new SaxHandler();
            parser.parse(xmlFile, handler);

            return handler.getObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
