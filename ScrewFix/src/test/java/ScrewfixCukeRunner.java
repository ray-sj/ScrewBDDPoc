import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.TestCase;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
				features = "src/test/resources/features/",
				glue = "stepdefs",
				tags = {"@breadbox, @wip"})


public class ScrewfixCukeRunner extends TestCase{
}
