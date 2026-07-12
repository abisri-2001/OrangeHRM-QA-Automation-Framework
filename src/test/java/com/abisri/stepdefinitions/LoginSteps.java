package com.abisri.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.abisri.pages.DashboardPage;
import com.abisri.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSteps {

    WebDriver driver;

    LoginPage loginPage;

    DashboardPage dashboardPage;

    @Before
    public void setUp() {

    	ChromeOptions options = new ChromeOptions();

    	options.addArguments("--headless=new");
    	options.addArguments("--window-size=1920,1080");
    	options.addArguments("--no-sandbox");
    	options.addArguments("--disable-dev-shm-usage");

    	driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);

        dashboardPage = new DashboardPage(driver);
    }

    @Given("the user is on the OrangeHRM login page")
    public void theUserIsOnTheOrangeHRMLoginPage() {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.navigate().refresh();
    }

    @When("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(
            String username,
            String password) {

        loginPage.enterUsername(username);

        loginPage.enterPassword(password);
    }
    @When("the user clicks the Login button")
    public void theUserClicksTheLoginButton() {

        loginPage.clickLogin();
    }

    @Then("the login result should be {string}")
    public void theLoginResultShouldBe(
            String expectedResult) {

        if (expectedResult.equalsIgnoreCase("Valid")) {

            Assert.assertTrue(
                    dashboardPage.isDashboardDisplayed(),
                    "Expected successful login, but login failed"
            );

        } else {

            Assert.assertTrue(
                    loginPage.isInvalidCredentialsMessageDisplayed(),
                    "Expected invalid credentials message, but it was not displayed"
            );
        }
    }

    @After
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}