package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormPage {
    private static WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(name = "gender")
    List<WebElement> gendersRadioButtonsInput;

    @FindBy(id = "dob")
    WebElement dateOfBirthPickerInput;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "company")
    WebElement companyInput;

    @FindBy(id = "comment")
    WebElement commentInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "submit-msg")
    WebElement submitMessage;

    Select role;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        role = new Select(driver.findElement(By.id("role")));
        PageFactory.initElements(driver, this);
    }

    public void fillUpElement(WebElement webElement, String fillUIpPhase) {
        webElement.sendKeys(fillUIpPhase);
    }

    public void fillUpFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void fillUpLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void chooseGender(int gendersNumber) {
        gendersRadioButtonsInput.get(gendersNumber).click();
    }

    public void fillUpDateOfBirth(String dateOfBirth) {
        dateOfBirthPickerInput.sendKeys(dateOfBirth);
    }

    public void fillUpAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void fillUpEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void fillUpPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void fillUpCompany(String company) {
        companyInput.clear();
        companyInput.sendKeys(company);
    }

    public void fillUpComment(String comment) {
        commentInput.clear();
        commentInput.sendKeys(comment);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void selectRole(String roleName) {
        role.selectByVisibleText(roleName);
    }

    public String getSuccessMessage(){
        return submitMessage.getText();
    }

}
