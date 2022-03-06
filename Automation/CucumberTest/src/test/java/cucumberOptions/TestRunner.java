package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/",
		// glue="stepDefinations",stepNotifications = true,tags="@SmokeTest or @Sanity"
		// glue="stepDefinations",stepNotifications = true,tags="not @Sanity"
		// glue="stepDefinations",stepNotifications = true,tags="@SmokeTest and @Sanity"
		//glue="stepDefinations",stepNotifications = true , monochrome = true,
		glue = "stepDefinations", stepNotifications = true, tags = "@SeleniumTest", monochrome = true,

		// Below Property is to generate report in neat manner
		plugin = { "pretty", "html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cucumber.xml" }

)

public class TestRunner {

}
