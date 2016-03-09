package resourceServer;

import resources.TestResource;

/**
 * Created by User on 04.03.2016.
 */
public class ResourceServer implements ResourceServerI {
    private TestResource resource;

    public ResourceServer(){
        this.resource = new TestResource();
    }

    @Override
    public TestResource getTestResource() {
        return resource;
    }

    @Override
    public void setTestResource(TestResource resource) {
        this.resource = resource;
    }

}
