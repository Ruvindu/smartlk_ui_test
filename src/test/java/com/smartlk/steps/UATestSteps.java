package com.smartlk.steps;

import com.smartlk.ENV;
import com.smartlk.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.WebSocketFrameReceived;
import org.openqa.selenium.devtools.v107.network.model.WebSocketFrameSent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Optional;

public class UATestSteps {


    @Given("User is on welcome page")
    public void userIsOnWelcomePage() {
        WebDriverManager.getDriver().navigate().to("http://sfc-cx-dev-trade.universal.directfn.net/");
        WebDriverManager.getDriver().findElement(By.id("priLangRadio")).click();
    }

    @When("User enters {string} in ID text box")
    public void userEntersIdnumberInIDTextBox(String id) {
        WebDriverManager.getDriver().findElement(By.id("userId")).sendKeys(id);
    }

    @And("Click user Continue")
    public void clickUserContinue() {
//        WebDriverManager.getDriver().findElement(By.id("continueBtnId")).click();

        new WebDriverWait(WebDriverManager.getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(WebDriverManager.getDriver().findElement(By.id("userId"))));
        WebDriverManager.getDriver().findElement(By.id("continueBtnId")).click();
    }

    @And("User enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        WebDriverManager.getDriver().findElement(By.id("txtUsername")).sendKeys(username);
        WebDriverManager.getDriver().findElement(By.id("txtPassword")).sendKeys(password);
    }

    @And("Click user login")
    public void clickUserLogin() {
        ENV.manualwait(1);
        WebDriverManager.getDriver().findElement(By.id("btnLogin")).click();
    }

    @Then("User is on dashboard")
    public void userIsOnDashboard() {
        Assert.assertTrue(this.verifyauthtest());
    }

    @Then("User is not on dashboard")
    public void userIsNotOnDashboard() {
        Assert.assertFalse(this.verifyauthtest());
    }

    private boolean verifyauthtest() {

        // verify user login

        DevTools devTools = ((ChromeDriver) WebDriverManager.getDriver()).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

//        devTools.addListener(Network.webSocketFrameSent(), webSocketFrameSent -> printDataSent(webSocketFrameSent));
        devTools.addListener(Network.webSocketFrameReceived(), webSocketFrameReceived -> printDataReceived(webSocketFrameReceived));
        return true;
    }

    public void printDataSent(WebSocketFrameSent webSocketFrameSent){
        System.out.println(webSocketFrameSent.getResponse().getPayloadData());
    }

    public void printDataReceived(WebSocketFrameReceived webSocketFrameReceived){
        System.out.println(webSocketFrameReceived.getResponse().getPayloadData());
//        System.out.println(webSocketFrameReceived.getResponse().getPayloadData().strip().split( ""));
    }
}
