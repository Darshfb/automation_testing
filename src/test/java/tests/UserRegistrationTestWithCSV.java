package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTestWithCSV extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;


    CSVReader reader;

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() throws IOException, CsvValidationException {
        /// get path of CSV file
        String csv_file = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.csv";

//        String csv_file = System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";


        reader = new CSVReader(new FileReader(csv_file));

        String[] csvCell;
        // while loop will be executed till the last value in csv file.
        while ((csvCell = reader.readNext()) != null) {
            String firstName = csvCell[0];
            String lastName = csvCell[1];
            String email = csvCell[2];
            String phone = csvCell[3];
            String password = csvCell[4];

            homeObject = new HomePage(driver);
            homeObject.openRegistrationPage();
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

}