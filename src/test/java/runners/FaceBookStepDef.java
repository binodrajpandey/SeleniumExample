package runners;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class FaceBookStepDef {
    private WebDriver driver;

    WebElementPage page;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        driver = new ChromeDriver();
        page = PageFactory.initElements(driver, WebElementPage.class);
    }

    @Given("^User navigates to facebook$")
    public void User_navigates_to_facebook() {
        // System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        // driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @When("^I enter username as \"([^\"]*)\"$")
    public void I_enter_username_as(String arg1) {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }

    @When("^I enter password as \"([^\"]*)\"$")
    public void I_enter_password_as(String arg1) {
        // driver.findElement(By.id("pass")).sendKeys(arg1);
        // driver.findElement(By.id("u_0_q")).click();
        page.login(arg1);

    }

    @Then("^login should fail$")
    public void login_should_fail() {
        if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
            System.out.println("Test1 Pass");
        } else {
            System.out.println("Test1 Failed");
        }
    }

    @Then("^relogin should be available$")
    public void relogin_should_be_available() {
        if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
            System.out.println("Test2 Pass");
        } else {
            System.out.println("Test2 Failed");
        }
        driver.close();
    }

    @Then("^login should be successful$")
    public void login_should_be_successful() {
        boolean success = driver.getCurrentUrl().toLowerCase().contains("https://www.facebook.com/");
        assertTrue(success);
    }

}
