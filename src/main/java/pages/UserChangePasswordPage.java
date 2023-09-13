package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserChangePasswordPage extends PageBase {
    public UserChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "old-password-field")
    WebElement oldPasswordTextField;

    @FindBy(id = "password-field")
    WebElement newPasswordTextField;

    @FindBy(id = "password-field-2")
    WebElement confirmNewPasswordTextField;

    public void UserCanChangePassword(String oldPass, String newPass, String confirmNewPass) {
        setTextElementText(oldPasswordTextField, oldPass);
        setTextElementText(newPasswordTextField, newPass);
        setTextElementText(confirmNewPasswordTextField, confirmNewPass);
    }

}
