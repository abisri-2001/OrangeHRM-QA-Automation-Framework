package com.abisri.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

    	ChromeOptions options = new ChromeOptions();

    	options.addArguments("--headless=new");
    	options.addArguments("--window-size=1920,1080");
    	options.addArguments("--no-sandbox");
    	options.addArguments("--disable-dev-shm-usage");

    	driver = new ChromeDriver(options);

        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }

    public void captureScreenshot(String testName) throws IOException {

        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        File source =
                screenshot.getScreenshotAs(OutputType.FILE);

        File screenshotFolder =
                new File("screenshots");

        if (!screenshotFolder.exists()) {

            screenshotFolder.mkdirs();
        }

        File destination =
                new File(screenshotFolder, testName + ".png");

        FileHandler.copy(source, destination);
    }
}