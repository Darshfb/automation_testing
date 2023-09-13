package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchProductTest extends TestBase
{

    HomePage homeObject;
    SearchPage searchPage;
    String searchText = "HEALTHY BOX";

    @Test
    public void UserSearch(){
        homeObject = new HomePage(driver);
        searchPage = new SearchPage(driver);
        searchPage.UserSearch(searchText);
    }

}
