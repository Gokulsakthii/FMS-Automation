package com.selenium.fms.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.fms.pages.LoginPage;

public class LoginTest {

    @Test
    public void loginTest() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open FMS Login page
        driver.get("https://fms-web.rtsiot.com/login");

        // Create Login Page object
        LoginPage loginPage = new LoginPage(driver);

        // Enter username
        loginPage.enterUsername("rtgtest");

        // Enter password
        loginPage.enterPassword("Rtgtest@123");

        // Click Login
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(d ->
            d.getCurrentUrl().contains("dashboard")
        );
        
        Assert.assertTrue(
        	    driver.getCurrentUrl().contains("dashboard")
        	  
        	    );
        
     // Close browser
        driver.quit();
        
        
     
    }
}
