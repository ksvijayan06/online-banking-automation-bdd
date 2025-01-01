package XYZ_Bank.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "./src/main/resource/featureFile/customer_E2E_flow.feature",
glue = {"XYZ_Bank.stepDefinitions.customerOperations", "XYZ_Bank.hooks"}
,plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
//,dryRun = true
)
public class RunnerClass {

}
