package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class UserRegistrationPage extends PageBase {


    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-layout/app-main-content/app-register/section/div/div/div/form/div[1]/div[1]/div/input")
    WebElement firstNameTextField;

    @FindBy(xpath = "/html/body/app-root/app-layout/app-main-content/app-register/section/div/div/div/form/div[1]/div[2]/div/input")
    WebElement lastNameTextField;

    @FindBy(xpath = "/html/body/app-root/app-layout/app-main-content/app-register/section/div/div/div/form/div[1]/div[3]/div/input")
    WebElement emailTextField;
    @FindBy(xpath = "//input[@id='phone']")
    WebElement phoneTextField;

    @FindBy(id = "password-field")
    WebElement passwordTextField;

    @FindBy(id = "password-field-2")
    WebElement confirmPasswordTextField;
    @FindBy(id = "agree")
    WebElement agreeCheckBox;

    @FindBy(xpath = "/html/body/app-root/app-layout/app-main-content/app-register/section/div/div/div/form/div[1]/div[9]/div/button[1]")
    WebElement registerButton;

    @FindBy(xpath = "div[@id='mat-snack-bar-container-live-0']/div/simple-snack-bar/div[2]/button/span[2]")
    WebElement successMessage;

    public void userRegistration(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
        clickButton(agreeCheckBox);
        setTextElementText(firstNameTextField, firstName);
        setTextElementText(lastNameTextField, lastName);
        setTextElementText(emailTextField, email);
        setTextElementText(phoneTextField, phone);
        setTextElementText(passwordTextField, password);
        setTextElementText(confirmPasswordTextField, confirmPassword);
        clickButton(registerButton);
    }
}
