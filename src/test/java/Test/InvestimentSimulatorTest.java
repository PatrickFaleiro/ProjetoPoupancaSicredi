package Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\projects\\ProjetoPoupancaSicredi\\src\\test\\java\\Feature",
        glue = { "StepDefinitions" })
public class InvestimentSimulatorTest {
}
