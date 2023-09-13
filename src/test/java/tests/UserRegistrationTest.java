package tests;

import org.testng.annotations.Test;
import pages.*;
import org.testng.Assert;

import java.time.Duration;

public class UserRegistrationTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    MyAccountPage myAccountObject;
    UserChangePasswordPage changePassObject;
    String email = "msasa45@mail.com";
    String phone = "55100545";
    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        registerObject.userRegistration("Mostafa", "Mahmoud", email, phone, "AB123456", "AB123456");
        System.out.println(homeObject.userFound.getText() + " Hello" + "Mostafa");
        Assert.assertTrue(homeObject.userFound.getText().contains("Mostafa"));
    }

    @Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void userLogOut() {
        homeObject.openMyAccountMenu();
        homeObject.userLogOut();
    }

    @Test(dependsOnMethods = {"userLogOut"})
    public void RegisteredUserCanLogin() {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, "AB123456");
    }

    @Test(dependsOnMethods = {"RegisteredUserCanLogin"})
    public void UserGotoMyAccount() {
        homeObject.openMyAccountMenu();
        homeObject.openMyAccount();
    }

    @Test(dependsOnMethods = {"UserGotoMyAccount"})
    public void OpenChangePassword() {
        myAccountObject = new MyAccountPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        myAccountObject.OpenChangePassword();
    }



    @Test(dependsOnMethods = {"OpenChangePassword"})
    public void UserChangePassword(){
        changePassObject = new UserChangePasswordPage(driver);
        changePassObject.UserCanChangePassword("AB123456","AB1234567", "AB1234567");
    }

}