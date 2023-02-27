package com.smartlk.steps;

import com.smartlk.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegSteps {
    @Given("Launch SmartLK to register {string}")
    public void launchSmartLKToRegister(String arg0) {
        WebDriverManager.getDriver().navigate().to("https://www.google.com");
    }

    @When("Input user data {string} and {string}")
    public void inputUserDataUsernameAndPwd(String username,String pwd) {
        System.out.println(username);
    }

    @And("Press Regster")
    public void pressRegster() {
    }

    @Then("{string} verify user is registerd")
    public void userVerifyUserIsRegisterd(String user) {
        System.out.println(user);
    }
}
