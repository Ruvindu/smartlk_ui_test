package com.smartlk.steps;

import com.smartlk.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class SearchSteps {

    @Given("Launch SmartLK {string}")
    public void launchSmartLK(String url) {
        WebDriver.driver.navigate().to(url);
    }

    @When("Text {string}")
    public void text(String text) {
        WebDriver.driver.findElement(By.className("search-text")).sendKeys(text);
    }

    @Then("Click search")
    public void clickSearch() {
        WebDriver.driver.findElement(By.className("search-btn")).click();
    }


}
