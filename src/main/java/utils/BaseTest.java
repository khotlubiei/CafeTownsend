package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

        protected static WebDriver driver;
        private static Properties properties = new Properties();
        protected static String USERNAME;
        protected static String PASSWORD;
        protected static String APP_URL;
        protected static String EMPLOYEE_FNAME;
        protected static String EMPLOYEE_LNAME;
        protected static String EMPLOYEE_EMAIL;
        protected static String EMPLOYEE_SDATE;
        protected static String EDITEDEMPLOYEE_FNAME;
        protected static String EDITEDEMPLOYEE_LNAME;
        protected static String EDITEDEMPLOYEE_EMAIL;
        protected static String EDITEDEMPLOYEE_SDATE;

        @BeforeSuite
        protected void initDriver() {
            loadProperties();
            WebDriverManager.chromedriver().setup();
            if (driver == null) {
                driver = new ChromeDriver();
            }

            driver.manage().timeouts()
                    .setScriptTimeout(30, TimeUnit.SECONDS)
                    .pageLoadTimeout(30, TimeUnit.SECONDS)
                    .implicitlyWait(30, TimeUnit.SECONDS);
        }

        @AfterSuite
        public void tearDown() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }

        private void loadProperties() {

            try {
                properties.load(getClass().getClassLoader().getResourceAsStream("tests.properties"));
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }


            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");
            APP_URL = properties.getProperty("appUrl");
            EMPLOYEE_FNAME = properties.getProperty("employeeFirstName");
            EMPLOYEE_LNAME = properties.getProperty("employeeLastName");
            EMPLOYEE_EMAIL = properties.getProperty("employeeEmail");
            EMPLOYEE_SDATE = properties.getProperty("employeeSDate");
            EDITEDEMPLOYEE_FNAME = properties.getProperty("editedEmployeeFirstName");
            EDITEDEMPLOYEE_LNAME = properties.getProperty("editedEmployeeLastName");
            EDITEDEMPLOYEE_EMAIL = properties.getProperty("editedEmployeeEmail");
            EDITEDEMPLOYEE_SDATE = properties.getProperty("editedEmployeeSDate");
        }
    }


