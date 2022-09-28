package co.com.choucair.automation.startshap.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "co/com/choucair/automation/startshap/steps",
        features = "src/test/resources/features/add_order.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)
public class Order {

}
