package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import utils.CommonMethods;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/",

        glue = {"steps"},

        dryRun = false,

        //tags =,

        plugin = {"pretty","html:target/cucumber.html"}
)

public class RunnerClass {

}
