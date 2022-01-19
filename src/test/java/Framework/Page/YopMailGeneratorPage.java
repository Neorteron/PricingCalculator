package Framework.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopMailGeneratorPage {
    private WebDriver driver;
    @FindBy (css = "#egen")
    WebElement generatedCode;
    @FindBy (xpath = "/html/body/div/div[2]/main/div/div[2]/div/div/div[2]/button[2]") WebElement checkMailButton;
    By inbox = By.xpath("//*[@id=\"ifinbox\"]");

    public YopMailGeneratorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
