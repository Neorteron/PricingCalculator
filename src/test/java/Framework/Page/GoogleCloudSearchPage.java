package Framework.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchPage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a")
    WebElement SearchResult;

    public GoogleCloudSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public GoogleCloudPricingPage ClickCalculatorLink(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(SearchResult));
        SearchResult.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe")));
        return new GoogleCloudPricingPage(driver);
    }





}
