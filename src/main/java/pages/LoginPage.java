package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public By loginButton = By.id("login-form");
    public By loginInput = By.xpath("//*[@id=\"login-form\"]/fieldset/label[1]/input");
    public By passwordInput = By.xpath("//*[@id=\"login-form\"]/fieldset/label[2]/input");
    public By loginErrorMsg = By.className("error-message ng-binding");



    public HomePage login (String login, String password) {

        typeText(this.loginInput, login);
        typeText(this.passwordInput, password);
        submitForm(loginButton);
        return PageFactory.initElements(driver, HomePage.class);
    }
    public Boolean loginInputIsPresented () {
        return driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset")).isDisplayed();
    }

    }
