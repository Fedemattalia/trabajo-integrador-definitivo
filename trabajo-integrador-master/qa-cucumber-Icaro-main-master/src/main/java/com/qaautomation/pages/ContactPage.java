package com.qaautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage {

    private By fullNameField = By.id("name");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By messageField = By.id("message");
    private By submitButton = By.xpath("//button[text()='Submit']");
    private By confirmationMessage = By.id("submitSuccessMessage");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void inputFullName(String name) {
        driver.findElement(fullNameField).sendKeys(name);
    }

    public void inputEmailAddress(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void inputPhoneNumber(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void inputMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public String validarMsj() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return confirmation.getText();
    }

    public String getConfirmationMessage() {
        return validarMsj();
    }
}
