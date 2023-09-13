package tests;

import data.LoadProperties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class userRegistrationRegressionTestWithDDTAndProperties extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    MyAccountPage myAccountObject;
    UserChangePasswordPage changePassObject;

    String fn = LoadProperties.userData.getProperty("firstName");
    String ln = LoadProperties.userData.getProperty("lastName");
    String email = LoadProperties.userData.getProperty("email");
    String password = LoadProperties.userData.getProperty("password");
    String phone = LoadProperties.userData.getProperty("phone");

//    @DataProvider(name = "testData")
//    public static Object[][] userData() {
//        return new Object[][]{
//                {
//                        "Mostafa",
//                        "Mahmoud",
//                        "mostafa0mmm@mail.com",
//                        "55100552",
//                        "AB123456"
//                },
//                {
//                        "Ahmed",
//                        "Mahmoud",
//                        "ahmedm0m0@mail.com",
//                        "55100553",
//                        "AB123456"
//                }
//        };
//    }

//    @Test(priority = 1, alwaysRun = true, dataProvider = "testData")
//    public void UserCanRegisterSuccessfully(String name, String lastName, String email,String phone, String password) {
//        homeObject = new HomePage(driver);
//        homeObject.openRegistrationPage();
//        registerObject = new UserRegistrationPage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
//        registerObject.userRegistration(name, lastName, email, phone, password, password);
//        System.out.println(homeObject.userFound.getText() + " Hello" + "Mostafa");
//        Assert.assertTrue(homeObject.userFound.getText().contains(name));
//    }
//
//    @Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
//    public void userLogOut() {
//        homeObject.openMyAccountMenu();
//        homeObject.userLogOut();
//    }

    @Test
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        registerObject.userRegistration(fn, ln, email, phone, password, password);
        System.out.println(homeObject.userFound.getText() + " Hello" + "Mostafa");
    }
    public void RegisteredUserCanLogin(String name, String lastName, String email)
    {
        homeObject = new HomePage(driver);
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, "AB123456");
    }

//    @Test(dependsOnMethods = {"RegisteredUserCanLogin"})
//    public void UserGotoMyAccount() {
//        homeObject.openMyAccountMenu();
//        homeObject.openMyAccount();
//    }

//    @Test(dependsOnMethods = {"UserGotoMyAccount"})
//    public void OpenChangePassword() {
//        myAccountObject = new MyAccountPage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
//        myAccountObject.OpenChangePassword();
//    }


//    @Test(dependsOnMethods = {"OpenChangePassword"})
//    public void UserChangePassword() {
//        changePassObject = new UserChangePasswordPage(driver);
//        changePassObject.UserCanChangePassword("AB123456", "AB1234567", "AB1234567");
//    }

}