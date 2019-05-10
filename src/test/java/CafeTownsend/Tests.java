package CafeTownsend;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import pages.HomePage;


public class Tests extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @Test
    public void logIn()  {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.get(APP_URL);
        homePage = loginPage.login(USERNAME,PASSWORD);
        assertTrue(homePage.greetingsMsg.contains("Hello "+USERNAME));

    }

    @Test
    public void logOut()  {
        homePage.logOut();
        assertTrue(loginPage.loginInputIsPresented());
    }

    @Test
    public void addEmployee () {
        homePage = homePage.createUser(EMPLOYEE_FNAME,EMPLOYEE_LNAME,EMPLOYEE_SDATE, EMPLOYEE_EMAIL);
        assertTrue(homePage.isEmployeePresented(EMPLOYEE_FNAME,EMPLOYEE_LNAME));
    }

    @Test
    public void deleteEmployee () {
        homePage = homePage.deleteUser(EMPLOYEE_FNAME,EMPLOYEE_LNAME);
        assertFalse(homePage.isEmployeePresented(EMPLOYEE_FNAME,EMPLOYEE_LNAME));
    }


    @Test
    public void editEmployeeDetails () {
        homePage = homePage.editUser(EMPLOYEE_FNAME,EMPLOYEE_LNAME, EDITEDEMPLOYEE_FNAME,EDITEDEMPLOYEE_LNAME,EDITEDEMPLOYEE_SDATE, EDITEDEMPLOYEE_EMAIL );
        assertTrue(homePage.assertEmployeeData(EDITEDEMPLOYEE_FNAME,EDITEDEMPLOYEE_LNAME,EDITEDEMPLOYEE_SDATE, EDITEDEMPLOYEE_EMAIL));
        homePage.deleteUser();
    }


}




