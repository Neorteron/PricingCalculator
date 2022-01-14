package FirstTask.test;

import FirstTask.page.PastebinHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PastebinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }



    public void browserTitleEqualPasteTitle() {
        PastebinHomePage page = new PastebinHomePage(driver);
        page.openPage();
        page.setPasteForm("Test form text");
        page.setPasteTitle("Test title");
        page.setPasteExpiration();
        //page.createPaste();
        // new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div")));
        //String url = driver.getCurrentUrl();
        //System.out.println(url);
        //Assert.assertTrue(url.contains("Test title"), "Title equal to url");
    }


    public void browserShutdowm(){
       driver.quit();
       driver = null;
    }

}
