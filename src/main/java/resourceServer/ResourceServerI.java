package resourceServer;

import recources.TestResource;

/**
 * Created by User on 04.03.2016.
 */
public interface ResourceServerI {
    TestResource getTestResource();

    void setTestResource(TestResource resource);
}
