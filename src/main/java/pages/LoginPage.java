package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-layout/app-main-content/app-login/section/div/div/div/form/div[1]/input")
    WebElement emailTextBox;

    @FindBy(id = "password-field")
    WebElement passwordTextBox;

    @FindBy(css = "button.main-btn.main.animate.w-100.border-0.bold.fs-16")
    WebElement loginButton;

    public void UserLogin(String email, String password)
    {
    setTextElementText(emailTextBox, email);
    setTextElementText(passwordTextBox, password);
    clickButton(loginButton);
    }
}
