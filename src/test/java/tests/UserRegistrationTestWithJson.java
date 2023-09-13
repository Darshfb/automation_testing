package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTestWithJson extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;




    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() throws IOException, ParseException {
        JsonDataReader jsonDataReader = new JsonDataReader();
        jsonDataReader.JsonReader();
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        registerObject.userRegistration(jsonDataReader.firstName, jsonDataReader.lastName, jsonDataReader.email, jsonDataReader.phone, jsonDataReader.password, jsonDataReader.password);
        homeObject.openMyAccountMenu();
        homeObject.userLogOut();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(jsonDataReader.email, jsonDataReader.password);
        homeObject.openMyAccountMenu();
        homeObject.userLogOut();


    }

}