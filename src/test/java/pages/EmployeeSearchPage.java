package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {


    @FindBy(xpath = "(//*[@class='oxd-input oxd-input--active'])[2]")
    public WebElement empIdSearchField;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement searchButton;

    @FindBy(xpath = "(//*[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[1]")
    public WebElement empNameSearchField;


    public By empListEmployeeIdField =
            By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");


    public By empListSearchButton =
            By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");


    public EmployeeSearchPage(){
        PageFactory.initElements(driver, this);
    }



}
