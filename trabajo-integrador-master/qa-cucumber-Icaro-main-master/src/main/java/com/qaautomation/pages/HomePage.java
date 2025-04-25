package com.qaautomation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Contacto")
    private WebElement linkContacto;

    @FindBy(css = "section#home")
    private WebElement seccionHome;

    // Acción: Ir a la sección de Contacto
    public void irAContacto() {
        linkContacto.click();
        wait.until(driver -> driver.getCurrentUrl().contains("contact.html"));
    }
}
