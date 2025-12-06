package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {

    @FindBy(xpath = "(//*[text()='PIM'])[1]")
    public WebElement pimOption;

    @FindBy(xpath = "//*[text()='Employee List']")
    public WebElement empListOption;

    @FindBy(xpath = "(//*[text()='Add Employee'])[1]")
    public WebElement addEmpOption;


    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }

}
