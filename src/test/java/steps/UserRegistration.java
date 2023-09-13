package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;

    @Given("The user in the home page")
    public void the_user_in_the_home_page() {
        homePage = new HomePage(driver);
    }

    @When("I click on register link")
    public void i_click_on_register_link() {
        homePage.openRegistrationPage();
    }

    //    @When("I entered the user data")
//    public void i_entered_the_user_data() {
//        userRegistrationPage = new UserRegistrationPage(driver);
//        userRegistrationPage.userRegistration("mostafa", "mahmoud", "masad23123@mail.com", "50552177", "AB123456", "AB123456");
//    }
    @When("I entered {string}, {string}, {string}, {string}, {string}")
    public void i_entered(String firstName, String lastName, String email, String phone, String password) {
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(firstName, lastName, email, phone, password, password);
    }

    @Then("The registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
        homePage.openMyAccountMenu();
        homePage.userLogOut();
        homePage.openLoginPage();


    }

}
