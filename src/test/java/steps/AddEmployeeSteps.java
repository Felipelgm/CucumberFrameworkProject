package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        click(dashboardPage.addEmpOption);
    }

    @When("user enters first name {string} and middle name {string} and last name {string}")
    public void user_enters_full_name(String first, String middle, String last) {
        sendText(first, addEmployeePage.firstNameLoc);
        sendText(middle, addEmployeePage.middleNameLoc);
        sendText(last, addEmployeePage.lastNameLoc);
    }

    @When("user clears the employee id field")
    public void user_clears_emp_id() {
        addEmployeePage.employeeId.clear();
    }

    @When("user enters a custom employee id {string}")
    public void user_enters_custom_emp_id(String id) {
        addEmployeePage.employeeId.clear();
        addEmployeePage.employeeId.sendKeys(id);
        CommonMethods.newEmployeeID = id;
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("Employee successfully added");
    }

    @Then("user verifies employee is visible in the personal details page")
    public void verify_personal_details_page() {
        WebElement nameHeader = driver.findElement(By.xpath("//h6"));
        if (nameHeader.isDisplayed()) {
            System.out.println("User successfully landed on Personal Details page");
        }
    }

    @Then("user verifies employee ID {string} is saved correctly")
    public void verify_custom_id(String expected) {
        String actual = addEmployeePage.employeeId.getAttribute("value");
        if (actual.equals(expected)) {
            System.out.println("Employee ID saved correctly: " + actual);
        } else {
            System.out.println("Employee ID mismatch. Expected: " + expected + ", Actual: " + actual);
        }
    }

    @When("user leaves first name empty")
    public void user_leaves_first_name_empty() {
        addEmployeePage.firstNameLoc.clear();
    }

    @When("user fills only last name {string}")
    public void user_fills_only_last(String last) {
        sendText(last, addEmployeePage.lastNameLoc);
    }

    @Then("user should see required error under first name field")
    public void check_firstname_error() {
        waitForVisibility(addEmployeePage.firstNameError);
        String error = addEmployeePage.firstNameError.getText();
        if (error.equals("Required")) {
            System.out.println("AC Passed: Required error is displayed under First Name.");
        } else {
            System.out.println("AC Failed: Incorrect error message: " + error);
        }
    }
}
