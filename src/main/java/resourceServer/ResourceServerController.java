package resourceServer;

/**
 * Created by User on 04.03.2016.
 */
public class ResourceServerController implements ResourceServerControllerMBean {
    private final ResourceServerI resourceServer;

    public ResourceServerController(ResourceServerI resourceServer){
        this.resourceServer = resourceServer;
    }

    @Override
    public int getAge() {
        return resourceServer.getTestResource().getAge();
    }

    @Override
    public String getName() {
        return resourceServer.getTestResource().getName();
    }
}
