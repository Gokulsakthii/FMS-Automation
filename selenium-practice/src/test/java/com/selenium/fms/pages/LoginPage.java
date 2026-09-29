package com.selenium.fms.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By usernameInput = By.cssSelector("input[placeholder='Enter your username']");
    By passwordInput = By.cssSelector("input[placeholder='Enter your password']");
    By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterUsername(String username) {

        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameInput));

        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {

        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordInput));

        passwordField.sendKeys(password);
    }

    public void clickLogin() {

        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(loginButton));

        loginBtn.click();
    }
}

