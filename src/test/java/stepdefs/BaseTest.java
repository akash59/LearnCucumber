package stepdefs;

import io.cucumber.java.Scenario;

public class BaseTest {

    protected static ThreadLocal<Scenario> scenario = new ThreadLocal<>();


}
