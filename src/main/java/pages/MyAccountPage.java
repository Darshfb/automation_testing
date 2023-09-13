package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-layout/app-main-content/app-account/section/div/div/div[1]/ul/li[2]/span")
    WebElement changePasswordTextButton;

    public void OpenChangePassword()
    {
        clickButton(changePasswordTextButton);
    }
}
