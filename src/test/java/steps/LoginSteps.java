package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("User is on the login page");
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimOption);
    }

    @Then("user is able to login successfully")
    public void user_is_able_to_login_successfully() {
        System.out.println("User logged in successfully");
    }

    @When("user attempts to log in with an empty username field")
    public void user_attempts_to_log_in_with_an_empty_username_field() {

        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }


    @Then("user see the system error message {string}")
    public void user_see_the_system_error_message(String expectedMessage) {

        waitForVisibility(loginPage.requiredError);

        String actual = loginPage.requiredError.getText().trim();

        if (!actual.equals(expectedMessage)) {
            System.out.println("Do not meet criteria. ");
            throw new AssertionError("Expected: " + expectedMessage + " but found: " + actual);
        } else {
            System.out.println("The criteria were archived.");
        }



        WebElement container = loginPage.usernameField.findElement(By.xpath("./ancestor::div[1]"));
        if (container.getText().contains(actual)) {
            System.out.println("The criteria were archived: Error is close to field.");
        }
    }

    @When("user attempts to log in with an empty password field")
    public void user_attempts_to_log_in_with_an_empty_password_field() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        click(loginPage.loginButton);
        waitForVisibility(loginPage.requiredError);
    }

    @When("user attempts to log in with incorrect credentials")
    public void user_attempts_to_log_in_with_incorrect_credentials() {
        sendText("wrongUser123", loginPage.usernameField);
        sendText("wrongPass123", loginPage.passwordField);
        click(loginPage.loginButton);
    }


    @Then("user see the system error {string}")
    public void user_see_the_system_error(String expectedMsg) {

        waitForVisibility(loginPage.invalidCredentialsMsg);

        String actualMsg = loginPage.invalidCredentialsMsg.getText().trim();

        System.out.println("Expected: " + expectedMsg);
        System.out.println("Actual: " + actualMsg);

        if (actualMsg.equals(expectedMsg)) {
            System.out.println("The criteria were archived.");
        } else {
            System.out.println("Do not meet criteria.");
        }
    }

    @When("user corrects credentials and logs in again")
    public void user_corrects_credentials_and_logs_in_again() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
        click(loginPage.loginButton);
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {

        waitForVisibility(dashboardPage.pimOption);

        if (dashboardPage.pimOption.isDisplayed()) {
            System.out.println("User logged in successfully. AC5 Passed.");
        } else {
            throw new AssertionError("User failed to log in again.");
        }
    }
}
