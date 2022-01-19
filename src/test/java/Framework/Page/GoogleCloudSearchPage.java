package Framework.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchPage extends AbstractPage {
    private WebDriver driver;
    @FindBy(xpath = "(//a[contains(., 'Google Cloud Pricing Calculator')])[1]")
    WebElement searchResult;
    By frame = By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe");

    public GoogleCloudSearchPage(WebDriver driver) {
        super(driver);
    }


    public GoogleCloudPricingPage clickCalculatorLink(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchResult));
        searchResult.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(frame));
        return new GoogleCloudPricingPage(driver);
    }





}
