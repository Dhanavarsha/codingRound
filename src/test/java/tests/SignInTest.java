package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObjects.HomePage;
import utils.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Consumer;

public class SignInTest extends BaseTest {

    @Test(enabled = false)
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        DriverManager.withDriver(new Consumer<WebDriver>() {
            @Override
            public void accept(WebDriver driver) {
                HomePage homePage = new HomePage(driver);
                homePage.openWebsite();
                homePage.openUserAccountMenu();
                homePage.openSignInForm();
                homePage.clickSignIn();
                Assert.assertTrue(homePage.getSignInErrorText().contains("There were errors in your submission"));
            }
        });
    }

    @Test(enabled = false)
    public void shouldThrowAnErrorIfSignInDetailsAreMissing1() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("www.google.com");
        Assert.fail();
        DriverManager.returnDriver(driver);
    }

    @Test
    public void test1() {
        HomePage homePage = new HomePage(new ChromeDriver());
        homePage.openWebsite();
        homePage.openUserAccountMenu();
        homePage.openSignInForm();
        homePage.clickSignIn();
        Assert.assertTrue(homePage.getSignInErrorText().contains("There were errors in your submission"));
    }

    @Test
    public void test2() {
        HomePage homePage = new HomePage(new ChromeDriver());
        homePage.openWebsite();
        homePage.openUserAccountMenu();
        homePage.openSignInForm();
        homePage.clickSignIn();
        Assert.assertTrue(homePage.getSignInErrorText().contains("There were errors in your submission"));
    }

    @Test(enabled = false)
    public void testWithTwoDrivers() {
        DriverManager.withDrivers(new DriverManager.Drivers() {
            @Override
            public void accept(WebDriver driver1, WebDriver driver2) {
                driver1.get(PropertyUtils.getProperty("website_url"));
                driver2.get(PropertyUtils.getProperty("website_url"));
                Assert.assertTrue(true);
            }
        });
    }

    @Test(enabled = true)
    public void testWithRemoteWebDriverForChrome() throws MalformedURLException {
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(true);
        driver.quit();
    }

    @Test(enabled = true)
    public void testWithRemoteWebDriverForFirefox() throws MalformedURLException {
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        driver.get("https://www.google.co.in/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(true);
        driver.quit();
    }

    @Test(enabled = true)
    public void sampleGridTestWithDockerOne() throws MalformedURLException {
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.get("https://www.google.co.in/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(true);
        driver.quit();
    }

    @Test(enabled = true)
    public void sampleGridTestWithDockerTwo() throws MalformedURLException {
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(true);
        driver.quit();
    }
}
