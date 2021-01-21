package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FormPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FillUpTest {
    private final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private final String CHROME_DRIVER_PATH = "src/main/resources/drivers/chromedriver";
    private final String URL = "https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html";
    private final String firstName = "Piotr";
    private final String lastName = "Buja";
    private final int genderNumber = 1;
    private final String dateOfBirth ="03/23/1993";
    private final String address ="random address";
    private final String email ="email@address.com";
    private final String password ="password";
    private final String company ="company";
    private final String comment ="very nice comment";
    private final String role = "QA";
    private final String expectedSuccessValueMessage = "Successfully submitted!";

    FormPage formPage;
    WebDriver driver;

    @Before
    public void prepareEnvironment(){
        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        formPage = new FormPage(driver);
    }
    @Test
    public void fillUpForm(){
        formPage.fillUpFirstName(firstName);
        formPage.fillUpLastName(lastName);
        formPage.chooseGender(genderNumber);
        formPage.fillUpDateOfBirth(dateOfBirth);
        formPage.fillUpAddress(address);
        formPage.fillUpEmail(email);
        formPage.fillUpPassword(password);
        formPage.fillUpComment(comment);
        formPage.fillUpCompany(company);
        formPage.selectRole(role);
        formPage.clickSubmitButton();
        assertEquals(expectedSuccessValueMessage, formPage.getSuccessMessage());
    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}
