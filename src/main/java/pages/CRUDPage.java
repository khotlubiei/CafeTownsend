package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

 public CRUDPage editFName (String newFirstName) {

     typeText(fNameInput, newFirstName);
     return PageFactory.initElements(driver, CRUDPage.class);

 }

    public CRUDPage editLName (String newLastName) {

        typeText(lNameInput, newLastName);
        return PageFactory.initElements(driver, CRUDPage.class);

    }

    public CRUDPage editStartDate (String newStartDate) {

        typeText(startDateInput, newStartDate);
       return PageFactory.initElements(driver, CRUDPage.class);

    }

    public CRUDPage editEmail (String newEmail) {
         typeText(emailInput, newEmail);
        return PageFactory.initElements(driver, CRUDPage.class);

    }

    public HomePage submitForm () {

        submitForm(submitButton);
        return PageFactory.initElements(driver, HomePage.class);

    }

    public static Boolean assertFName(String firstName) {
        return getInputText (fNameInput).equals(firstName);
    }

    public static Boolean assertLName(String lastName) {
        return getInputText(lNameInput).equals(lastName);
    }

    public static Boolean assertStartDate (String startDate) {
        return getInputText(startDateInput).equals(startDate);
 }

    public static Boolean assertEmail (String email) {
        return getInputText(emailInput).equals(email);
    }


}
