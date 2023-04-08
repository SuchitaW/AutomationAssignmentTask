package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/Feature/Feature.feature"},          //Path of Feature folder which hold feature file
        glue={"StepDefination","Stepdef" }, // Path of StepDefinition file
        tags= " @automationCheck", 
       plugin = {"pretty",                      
            "html:target/html/htmlReport.html",
            "json:target/json/jsonReport.json",
       
            },
        monochrome=true,
        publish= true,
        dryRun=false
        )



public class Runner {

	

	}


