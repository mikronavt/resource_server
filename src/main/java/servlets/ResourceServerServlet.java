package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resources.TestResource;
import resourceServer.ResourceServerI;
import sax.ReadXMLFileSAX;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by User on 04.03.2016.
 */
public class ResourceServerServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(ResourceServerServlet.class.getName());
    public static final String PAGE_URL = "/resources";
    private final ResourceServerI resourceServer;

    public ResourceServerServlet(ResourceServerI resourceServer){
        this.resourceServer = resourceServer;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");

        String path = request.getParameter("path");

        if(path != null){
            //добавить функционал
            //System.out.println(path);
            TestResource resource = (TestResource) ReadXMLFileSAX.readXML(path);
            //System.out.println(resource);
            resourceServer.setTestResource(resource);
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }



    }

}
