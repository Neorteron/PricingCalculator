package Framework.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopMailMainPage extends AbstractPage {
    @FindBy(css = "#refresh")
    WebElement refreshButton;
    @FindBy(xpath = "//h3[contains(., 'USD')]")
    WebElement priceInMail;
    @FindBy(xpath = "//*[@id=\"ifmail\"]")
    WebElement frame;
    By header = By.xpath("//h1[contains(., 'Your Estimated Bill')]");



    public YopMailMainPage(WebDriver driver) {
        super(driver);
    }

    public YopMailMainPage moveToMailFrame(){
        driver.switchTo().frame(frame);
        return this;
    }



    public YopMailMainPage refreshMails(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        refreshButton.click();
        return this;
    }

    public double getPriceFromMail(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(header));
        return Double.parseDouble(priceInMail.getText().replaceFirst("USD ", "").replace(",",""));
    }

}
