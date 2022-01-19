package Framework.Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class YopMailHomePage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"listeliens\"]/a[1]")
    WebElement generator;

    public YopMailHomePage(WebDriver driver) {
        super(driver);
    }

    public YopMailHomePage openPage(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
        driver.get("https://yopmail.com/ru/");
        return this;
    }

    public YopMailGeneratorPage openGenerator(){
        generator.click();
        return new YopMailGeneratorPage(driver);
    }

}
