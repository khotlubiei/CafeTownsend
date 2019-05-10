package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String greetingsMsg = getElementText(By.id("greetings"));
    public List<WebElement> listOfEmployees = new ArrayList<>();// = getListOfElements(By.className("ng-scope ng-binding"));
    public By createButton = By.id("bAdd");
    public By editButton = By.id("bEdit");
    public By deleteButton = By.id("bDelete");
    public By logoutButton = By.cssSelector(".header-container > .main-button");
    private String homePageURL = "http://cafetownsend-angular-rails.herokuapp.com/employees";


    public LoginPage logOut (){
        waitForElement(logoutButton);
        clickOn(logoutButton);
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public HomePage deleteUser (String fName,String lName) {
        By employeeCard = employeeCardLocator(fName, lName);
        waitForElement(By.xpath("//*[@id='employee-list']/li"));
        clickOn(employeeCard);
        clickOn(deleteButton);
        confirmAlert();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public HomePage deleteUser () {
        clickOn(CRUDPage.deleteButton);
        confirmAlert();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public HomePage createUser (String fName,String lName, String sDate, String email) {
        clickOn(createButton);
        typeText(CRUDPage.fNameInput, fName);
        typeText(CRUDPage.lNameInput, lName);
        typeText(CRUDPage.startDateInput, sDate);
        typeText(CRUDPage.emailInput, email);
        submitForm(CRUDPage.submitButton);
        return PageFactory.initElements(driver, HomePage.class);
    }

    private By employeeCardLocator (String fName,String lName) {
        return By.xpath("//li[contains(text(), '"+fName+" "+lName+"')]");
    }

    public Boolean isEmployeePresented (String fName,String lName) {
        return myElement(employeeCardLocator (fName, lName)).isDisplayed();
    }

    public HomePage editUser (String fName,String lName, String fNameToUpdate,String lNameToUpdate, String sDateToUpdate, String emailToUpdate) {
        By employeeCard = employeeCardLocator(fName, lName);
        waitForElement(By.xpath("//*[@id='employee-list']/li"));
        clickOn(employeeCard);
        clickOn(editButton);
        typeText(CRUDPage.fNameInput, fNameToUpdate);
        typeText(CRUDPage.lNameInput, lNameToUpdate);
        typeText(CRUDPage.startDateInput, sDateToUpdate);
        typeText(CRUDPage.emailInput, emailToUpdate);
        submitForm(CRUDPage.submitButton);
        return PageFactory.initElements(driver, HomePage.class);

    }

    public Boolean assertEmployeeData (String fName,String lName, String sDate, String email){
        By employeeCard = employeeCardLocator(fName, lName);
        waitForElement(By.xpath("//*[@id='employee-list']/li"));
        doubleClick(employeeCard);
        if (
                myElement(CRUDPage.fNameInput).getText().equals(fName)
                        && myElement(CRUDPage.lNameInput).getText().equals(lName)
                        && myElement(CRUDPage.startDateInput).getText().equals(sDate)
                        && myElement(CRUDPage.emailInput).getText().equals(email)
            )
        {return true;}
        else
        {return false;}

    }


}
