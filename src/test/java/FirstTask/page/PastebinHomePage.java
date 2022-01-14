package FirstTask.page;


import FirstTask.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PastebinHomePage {
    private By pasteForm = By.id("postform-text");
    private By pasteExpiration = By.id("postform-expiration");
    private By pasteTitle = By.id("postform-name");
    private By pasteCreateButton = By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button");
    private WebDriver driver;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setPasteForm(String pasteFormText) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(pasteForm));
        driver.findElement(pasteForm).sendKeys(pasteFormText);
    }

    public void setPasteExpiration() {
        WebElement selectElem = driver.findElement(By.cssSelector("#postform-expiration"));
        Select select = new Select(selectElem);
        List options = select.getOptions();
        driver.findElement(By.cssSelector("#select2-postform-expiration-container")).click();
        select.selectByVisibleText("10 Minutes");
    }

    public void setPasteTitle(String pasteTitleText) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(pasteTitle));
        driver.findElement(pasteTitle).sendKeys(pasteTitleText);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://pastebin.com");
        new WebDriverWait(driver, 10).until(CustomConditions.jQueryAJAXsCompleted());
    }

    public void createPaste(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(pasteCreateButton));
        WebElement element = driver.findElement(pasteCreateButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }
}
