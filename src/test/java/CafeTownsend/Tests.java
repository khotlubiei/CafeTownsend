package CafeTownsend;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.CRUDPage;
import pages.LoginPage;
import utils.BaseTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static pages.CRUDPage.*;
import static pages.HomePage.openUser;

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
        homePage.createUser().editFName(EMPLOYEE_FNAME).editLName(EMPLOYEE_LNAME).editEmail(EMPLOYEE_EMAIL).editStartDate(EMPLOYEE_SDATE).submitForm();
        assertTrue(homePage.isEmployeePresented(EMPLOYEE_FNAME,EMPLOYEE_LNAME));
    }

    @Test
    public void deleteEmployee () {
        homePage = homePage.deleteUser(EMPLOYEE_FNAME,EMPLOYEE_LNAME);
        logOut();
        logIn();
        assertFalse(homePage.isEmployeePresented(EMPLOYEE_FNAME,EMPLOYEE_LNAME));
    }


    @Test
    public void editEmployeeDetails () {
        homePage.editUser(EMPLOYEE_FNAME,EMPLOYEE_LNAME).editFName(EDITEDEMPLOYEE_FNAME).editLName(EDITEDEMPLOYEE_LNAME).editStartDate(EDITEDEMPLOYEE_SDATE).editEmail(EDITEDEMPLOYEE_EMAIL).submitForm();
        openUser(EDITEDEMPLOYEE_FNAME,EDITEDEMPLOYEE_LNAME);
        assertTrue(CRUDPage.assertFName(EDITEDEMPLOYEE_FNAME)&& assertLName(EDITEDEMPLOYEE_LNAME)&&assertStartDate(EDITEDEMPLOYEE_SDATE)&&assertEmail(EDITEDEMPLOYEE_EMAIL));
        homePage.deleteUser();
    }


}




