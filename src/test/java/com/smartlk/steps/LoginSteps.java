package com.smartlk.steps;

import com.smartlk.ENV;
import com.smartlk.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.testng.AssertJUnit.assertEquals;

public class LoginSteps {

    @Before
    public void setup(){
        System.out.println("init step");
    }


    @Given("Launch SmartLK Login {string}")
    public void launch_smart_lk_login(String url) {
        WebDriverManager.getDriver().navigate().to(url);
    }

    @When("Input {string} and {string}")
    public void inputEmailAndPassword(String email, String password) {
//        WebDriver.driver.findElement(By.id("email")).sendKeys(email);
//        WebDriver.driver.findElement(By.id("password")).sendKeys(password);

        WebDriverManager.getDriver().findElement(By.id("email")).sendKeys(email);
        WebDriverManager.getDriver().findElement(By.id("password")).sendKeys(password);
    }

    @When("Press Login")
    public void press_login() {
//        WebDriver.driver.findElement(By.tagName("button")).click();
        WebDriverManager.getDriver().findElement(By.tagName("button")).click();
    }


    @Then("{string} is logged in")
    public void usernameIsLoggedIn(String username) {
        ENV.manualwait(1);
//        assertEquals(WebDriver.driver.findElement(By.id("navbarDropdownMenuLink")).getText(),username);


        assertEquals(WebDriverManager.getDriver().findElement(By.id("navbarDropdownMenuLink")).getText(), username);
    }

    @After
    public void end(){
        System.out.println("end step");
    }

}
