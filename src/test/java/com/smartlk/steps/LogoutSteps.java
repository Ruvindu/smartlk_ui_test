package com.smartlk.steps;

import com.smartlk.ENV;
import com.smartlk.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class LogoutSteps {
    @Given("On click logout")
    public void onClickLogout() {
        WebDriver.driver.findElement(By.xpath("//*[@id=\"navbarDropdownMenuLink\"]")).click();
        ENV.manualwait(1);
        System.out.println("click logout");
    }

    @Then("User is logged out")
    public void userIsLoggedOut() {
        ENV.manualwait(1);
        WebDriver.driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[5]/div/a[3]")).click();

    }
}
