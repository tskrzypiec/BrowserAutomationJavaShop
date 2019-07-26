package pl.TS.AutomationTestJavaShop;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(
		features = {"src/test/resource/features/"}
		,glue={"stepDefinition"}
		)

public class RunnerTest {	
	
}
