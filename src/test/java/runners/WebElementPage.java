package runners;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WebElementPage {
    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "pass")
    private WebElement password;

    @FindBy(how = How.ID, using = "u_0_q")
    private WebElement login;

    public void login(String arg0) {
        password.sendKeys(arg0);
        login.click();
    }

}
