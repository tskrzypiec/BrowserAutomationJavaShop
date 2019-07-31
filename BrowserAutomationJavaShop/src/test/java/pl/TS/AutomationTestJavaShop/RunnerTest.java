package pl.TS.AutomationTestJavaShop;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(
		features = {"src/test/resource/features/"}, format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"} 
		,glue={"stepDefinition"}
		)

public class RunnerTest {	
	
}
