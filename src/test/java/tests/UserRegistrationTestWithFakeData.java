package tests;

import com.github.javafaker.Faker;
import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTestWithFakeData extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

//    Locale locale = new Locale("ru");
    Faker faker = new Faker();

    String firstName = faker.name().firstName(); // Miss Samanta Schmidt
    String lastName = faker.name().lastName(); // Emory
    String email = faker.internet().emailAddress(); // Barton

    String phone = "5"+faker.number().numberBetween(0,0) + faker.number().digits(6);
    String password = "AB" + faker.number().digits(6);


    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() {



        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        System.out.println(password);
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        registerObject.userRegistration(firstName, lastName, email, phone, password, password);
        homeObject.openMyAccountMenu();
        homeObject.userLogOut();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, password);
        homeObject.openMyAccountMenu();
        homeObject.userLogOut();


    }

}