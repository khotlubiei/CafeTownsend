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

    public CRUDPage createUser () {
        clickOn(createButton);
        return PageFactory.initElements(driver, CRUDPage.class);
    }

    private static By employeeCardLocator(String fName, String lName) {
        return By.xpath("//li[contains(text(), '"+fName+" "+lName+"')]");
    }

    public Boolean isEmployeePresented (String fName,String lName) {
        return isElementPresented(employeeCardLocator (fName, lName));
    }

    public CRUDPage editUser (String fName,String lName) {
        By employeeCard = employeeCardLocator(fName, lName);
        waitForElement(By.xpath("//*[@id='employee-list']/li"));
        clickOn(employeeCard);
        clickOn(editButton);
        return PageFactory.initElements(driver, CRUDPage.class);
    }

    public static CRUDPage openUser(String fName, String lName) {
        By employeeCard = employeeCardLocator(fName, lName);
        waitForElement(By.xpath("//*[@id='employee-list']/li"));
        doubleClick(employeeCard);
        return PageFactory.initElements(driver, CRUDPage.class);
    }

}
