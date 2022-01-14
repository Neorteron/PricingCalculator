package Framework.Page;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleCloudHomePage extends AbstractPage {
    @FindBy(xpath = "/html/body/section/devsite-header/div/div[1]/div/div/div[2]/devsite-search/form/div[1]/div/input")
    WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public GoogleCloudHomePage openPage(){
        driver.get("https://cloud.google.com/");
        return this;
    }

    public GoogleCloudSearchPage InputSearchText(String text){
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchPage(driver);
    }



}
