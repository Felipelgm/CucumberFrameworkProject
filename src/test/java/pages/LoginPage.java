package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//*[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;


    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    public WebElement requiredError;


    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    public WebElement invalidCredentialsMsg;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
}
