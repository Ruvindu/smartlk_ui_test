package com.smartlk;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        features = {"src/test/resources/features/"},
        glue = {"com.smartlk.steps"},
        tags = "@reg"
)
public class TestRunner extends AbstractTestNGCucumberTests {

        @BeforeTest
        public void setup(){
                WebDriverManager.initializeDriver();
                System.out.println("INIT web");
        }


        @AfterTest
        public void teardown(){
                WebDriverManager.closeInstance();
                System.out.println("QUIT web");
        }
}
