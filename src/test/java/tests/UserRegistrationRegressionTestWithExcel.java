package tests;

import data.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;

public class UserRegistrationRegressionTestWithExcel extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    MyAccountPage myAccountObject;
    UserChangePasswordPage changePassObject;

    @DataProvider(name = "ExcelData")
    public Object[][] userRegisterData() throws IOException {
        // get data from Excel Reader class
        ExcelReader er = new ExcelReader();
        return er.getExcelData();
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
    public void UserCanRegisterSuccessfully(String name, String lastName, String email, String phone, String password) {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        registerObject.userRegistration(name, lastName, email, phone, password, password);
        System.out.println(homeObject.userFound.getText() + " Hello" + "Mostafa");
        homeObject.openMyAccountMenu();
        homeObject.userLogOut();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, password);
        homeObject.openMyAccountMenu();
        homeObject.userLogOut();
    }
}