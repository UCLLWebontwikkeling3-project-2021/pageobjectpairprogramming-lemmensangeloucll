import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    //TODO change the path below if necessary
    private String path = "http://localhost:8081/Controller";

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/Users/.../web3pers/chromedriver");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 ...
        System.setProperty("webdriver.chrome.driver", "/Applications/Servers/chromedriver_87");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.javascript", 2);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.get(path+"?command=Index");
    }

    @After
    public void clean() {
        //driver.quit();
    }

    @Test
    public void test_login_with_valid_info(){
        //TODO change the user id below to the correct user name of an administrator
        String userid = "admin";
        //TODO change the password below to the correct password that matches with the user id above
        String password = "password";
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserIdField(userid);
        loginPage.setPasswordField(password);

        IndexPage indexPage = loginPage.submitValid();

        //TODO change below the correct title when the admin user will be logged in.
        assertEquals("Welcome, Admini!", indexPage.getH1());
        //TODO change below the number of menu items that the admin can see when he is logged in
        assertEquals(7, indexPage.getNumberOfMenuItems());
    }

    @Test
    public void test_login_with_invalid_info(){
        String userid = "administrator";
        String password = "wrongPassword";
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserIdField(userid);
        loginPage.setPasswordField(password);
        loginPage.submitInvalid();

        assertTrue(loginPage.errorExists("No valid userid/password"));
    }

    @Test
    public void test_login_with_invalid_password(){
        String userid = "admin";
        String password = "wrongPassword";
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserIdField(userid);
        loginPage.setPasswordField(password);
        loginPage.submitInvalid();

        assertTrue(loginPage.errorExists("No valid userid/password"));
    }

    @Test
    public void test_login_with_empty_password(){
        String userid = "admin";
        String password = "";
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserIdField(userid);
        loginPage.setPasswordField(password);
        loginPage.submitInvalid();

        assertTrue(loginPage.errorExists("No valid userid/password"));
    }

    @Test
    public void test_login_with_empty_userId(){
        String userid = "";
        String password = "password";
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserIdField(userid);
        loginPage.setPasswordField(password);
        loginPage.submitInvalid();

        assertTrue(loginPage.errorExists("No valid userid/password"));
    }
}
