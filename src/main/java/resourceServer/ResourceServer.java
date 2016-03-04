package resourceServer;

import recources.TestResource;

/**
 * Created by User on 04.03.2016.
 */
public class ResourceServer implements ResourceServerI {
    private TestResource resource;

    @Override
    public TestResource getTestResource() {
        return resource;
    }

    @Override
    public void setTestResource(TestResource resource) {
        this.resource = resource;
    }

}
