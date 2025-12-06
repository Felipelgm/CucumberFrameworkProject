package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstNameLoc;

    @FindBy(xpath = "//*[@name='middleName']")
    public WebElement middleNameLoc;

    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement lastNameLoc;

    // Stable Employee ID locator
    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div//input")
    public WebElement employeeId;

    // Required field error under First Name
    @FindBy(xpath = "//input[@name='firstName']/ancestor::div[contains(@class,'oxd-input-group')]//span")
    public WebElement firstNameError;

    @FindBy(xpath = "//button[contains(@class,'oxd-button--secondary')]")
    public WebElement saveButton;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}
