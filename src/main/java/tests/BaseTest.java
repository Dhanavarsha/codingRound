package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.App;

public class BaseTest {
    private App app;

    public BaseTest() {
        this.app = App.getInstance();
    }

    @BeforeMethod
    public void setUp() {
        app.launch();
    }

    @AfterSuite
    public void tearDown() {
        app.close();
    }

    protected App getApp() {
        return app;
    }
}
