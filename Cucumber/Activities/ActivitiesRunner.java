package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/FeatureFile",
        glue = {"StepDefinition"},
        //tags = "@SimpleAlert or @ConfirmAlert"
        //tags = "@PromptAlert"
        tags = "@SmokeTest",
        plugin = {"html: test-reports/report.html"},
        monochrome = true
)

public class ActivitiesRunner {
}
