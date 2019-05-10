package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class CRUDPage extends BasePage {

    public CRUDPage(WebDriver driver) {
        super(driver);
    }

    public By logoutButton = By.cssSelector(".header-container > .main-button"); //className("main-button");
    public static By fNameInput = By.xpath("/html/body/div/div/div/form/fieldset/label[1]/input");
    public static By lNameInput = By.xpath("/html/body/div/div/div/form/fieldset/label[2]/input");
    public static By startDateInput = By.xpath("/html/body/div/div/div/form/fieldset/label[3]/input");
    public static By emailInput = By.xpath("/html/body/div/div/div/form/fieldset/label[4]/input");
    public By backButton = By.className("subButton bBack");
    public By cancelButton = By.className("subButton bCancel");
    public static By submitButton = By.xpath("//button[@type='submit']");
    public static By deleteButton = By.xpath("//p[contains(.,'Delete')]");





}
