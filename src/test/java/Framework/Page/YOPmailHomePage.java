package Framework.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class YOPmailHomePage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"listeliens\"]/a[1]")
    WebElement generator;

    public YOPmailHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public YOPmailHomePage openPage(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
        driver.get("https://yopmail.com/ru/");
        return this;
    }

    public YOPmailGeneratorPage OpenGenerator(){
        generator.click();
        return new YOPmailGeneratorPage(driver);
    }

}
