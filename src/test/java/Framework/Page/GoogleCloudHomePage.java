package Framework.Page;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleCloudHomePage extends AbstractPage {
    @FindBy(xpath = "//input[@name='q']")
    WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }


    public GoogleCloudHomePage openPage(){
        driver.get("https://cloud.google.com/");
        return this;
    }

    public GoogleCloudSearchPage inputSearchText(String text){
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchPage(driver);
    }



}
