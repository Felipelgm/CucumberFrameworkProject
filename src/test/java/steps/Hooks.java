package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void startScenario() {
        openBrowserAndLaunchApplication();
    }

    @After
    public void endScenario(Scenario scenario) {

        byte[] pic = null;


        try {
            if (scenario.isFailed()) {
                pic = takeScreenshot("failed/" + scenario.getName());
            } else {
                pic = takeScreenshot("passed/" + scenario.getName());
            }

            scenario.attach(pic, "image/png", scenario.getName());

        } catch (Exception e) {
            System.out.println("Could not take screenshot: " + e.getMessage());
        }


        try {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.out.println("Could not quit driver: " + e.getMessage());
        }
    }
}
