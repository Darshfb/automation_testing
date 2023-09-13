package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "search")
    WebElement searchTextField;

    @FindBy(css = "button.btn-search")
    WebElement searchBtn;

    @FindBy(xpath = "/html/body/app-root/app-layout/app-main-content/app-search/section/div/div/div/app-product-item/div/a")
    WebElement itemSearchFor;

    public void UserSearch(String searchText)
    {
        setTextElementText(searchTextField, searchText);
        searchBtn.click();
        itemSearchFor.click();
    }
}
