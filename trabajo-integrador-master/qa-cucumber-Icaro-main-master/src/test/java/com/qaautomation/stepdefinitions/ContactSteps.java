package com.qaautomation.stepdefinitions;

import com.qaautomation.pages.ContactPage;
import com.qaautomation.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ContactSteps {
    private WebDriver driver;
    private ContactPage contactPage;
    public HomePage homePage;

    @Given("el usuario se encuentra en la home de la pagina")
    public void elUsuarioSeEncuentraEnLaHomeDeLaPagina() {
        ChromeOptions options = new ChromeOptions();
        String pathChromeDriver = System.getProperty("user.dir") + "\\src\\main\\drivers\\chromedriver.exe";
        System.out.println("[Info]Ruta driver " + pathChromeDriver);
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));

        driver = new ChromeDriver(options);
        driver.get("https://fgzelaya.com.ar/contact.html");

        this.homePage = new HomePage(driver);
        this.contactPage = new ContactPage(driver);
    }

    @When("el usuario hace clic en el enlace de contacto")
    public void elUsuarioHaceClicEnElEnlaceDeContacto() {
        // Aseguramos que homePage no sea nulo antes de usarlo
        homePage.irAContacto();

        // Después de ir a la página de contacto, inicializamos contactPage si es necesario
        this.contactPage = new ContactPage(driver);
    }

    @And("el usuario ingres Full Name {string}")
    public void ElusuarioingresfullName(String name) {
        this.contactPage.inputFullName(name);
    }

    @And("el usuario ingres Email {string}")
    public void elUsuarioIngresEmail(String email) {
        this.contactPage.inputEmailAddress(email);
    }

    @And("el usuario ingres phone number {string}")
    public void elUsuarioIngresPhoneNumber(String phone) {
        this.contactPage.inputPhoneNumber(phone);
    }

    @And("el usuario ingres un message {string}")
    public void elusuarioingresunmessage(String message) {
        this.contactPage.inputMessage(message);
    }

    @And("el usuario apreta el boton de submit")
    public void elusuarioapretaelbotondesubmit() {
        this.contactPage.clickSubmitButton();
    }

    @Then("elusuariovisualizamensajeElenvíodelformulariofueexitoso!")
    public void elusuariovisualizamensajeelenvíodelformulariofueexitoso() {
        String confirmationMessage = this.contactPage.getConfirmationMessage();
        String mensajeEsperado = "¡El envío del formulario fue exitoso!";
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}