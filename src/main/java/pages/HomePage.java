package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-layout/app-header/app-toolbar/nav/div/div/div[3]/div/div/a[2]")
    WebElement registerLink;

    public void openRegistrationPage() {
        clickButton(registerLink);
    }

    @FindBy(xpath = "/html/body/app-root/app-layout/app-header/app-toolbar/nav/div/div/div[3]/div/div/span")
    public WebElement userFound;

    @FindBy(xpath = "/html/body/app-root/app-layout/app-header/app-toolbar/nav/div/div/div[3]/div/div/ul/li[3]/a/span")
    WebElement logOut;

    public void openMyAccountMenu(){
        clickButton(userFound);
    }
    public void userLogOut() {
        clickButton(logOut);
    }

    @FindBy(css = "a.login.d-none.d-md-block")
    WebElement loginPage;

    public void openLoginPage()
    {
        clickButton(loginPage);
    }

    @FindBy(xpath = "/html/body/app-root/app-layout/app-header/app-toolbar/nav/div/div/div[3]/div/div/ul/li[1]/a/span")
    WebElement myAccount;

    public void openMyAccount(){
        clickButton(userFound);
        clickButton(myAccount);
    }



}
