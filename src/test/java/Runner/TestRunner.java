package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber-default-report",
                "json:target/cucumber-json/cucumber.json", "rerun:target/rerun.txt" },
        features = {"src/test/resources/Features" },
        glue = "StepDef",
        tags = "@rediffTC1" ,
        dryRun = false,
        monochrome = true)

public class TestRunner {
}
