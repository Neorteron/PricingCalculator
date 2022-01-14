package Framework.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YOPmailMainPage {
    private WebDriver driver;
    @FindBy(css = "#refresh")
    WebElement refreshButton;
    @FindBy(xpath = "//*[@id=\"mail\"]/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3") WebElement priceInMail;


    public YOPmailMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YOPmailMainPage moveToMailFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"ifmail\"]")));
        return this;
    }



    public YOPmailMainPage refreshMails(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        refreshButton.click();
        return this;
    }

    public double getPriceFromMail(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mail\"]/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")));
        return Double.parseDouble(priceInMail.getText().replaceFirst("USD ", "").replace(",",""));
    }

}
