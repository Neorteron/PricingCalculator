package Framework.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopMailGeneratorPage extends AbstractPage {
    @FindBy (css = "#egen")
    WebElement generatedCode;
    @FindBy (xpath = "//button[contains(., 'Проверить почту')]") WebElement checkMailButton;
    By inbox = By.xpath("//*[@id=\"ifinbox\"]");

    public YopMailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public String getEmail(){
        return generatedCode.getText();
    }

    public YopMailMainPage checkMail(){
        checkMailButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(inbox));
        return new YopMailMainPage(driver);
    }

}
