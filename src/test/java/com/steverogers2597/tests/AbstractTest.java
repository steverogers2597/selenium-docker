package com.steverogers2597.tests;

import com.steverogers2597.pages.vendorportal.DashboardPage;
import com.steverogers2597.pages.vendorportal.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractTest {

    protected WebDriver driver;

    @BeforeTest
    public void setDriver() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Configure ChromeOptions to suppress password manager alerts
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-password-manager");
//        options.addArguments("--disable-save-password-bubble");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--user-data-dir=/tmp/chrome-profile");

        // Launch Chrome with options
        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeDriver() {
        this.driver.quit();
    }
}
