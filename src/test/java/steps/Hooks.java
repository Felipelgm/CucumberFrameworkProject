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

        // take screenshot only if the driver is still alive
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

        // safely close browser without throwing invalid session errors
        try {
            if (driver != null) {
                driver.quit();
                driver = null; // prevent stale/invalid session
            }
        } catch (Exception e) {
            System.out.println("Could not quit driver: " + e.getMessage());
        }
    }
}
