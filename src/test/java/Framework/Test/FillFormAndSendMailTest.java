package Framework.Test;

import Framework.Model.PricingList;
import Framework.Page.*;
import Framework.Service.ListCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.util.ArrayList;


public class FillFormAndSendMailTest extends CommonConditions {

    private final Logger logger = LogManager.getRootLogger();


    @Test
    public void FillFormAndSendMail() {
        //Setup pricing
        PricingList defaultList = ListCreator.withCredentialsFromProperty();
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);

        GoogleCloudPricingPage pricingPage = googleCloudHomePage.openPage()
                .InputSearchText("Google Cloud Platform Pricing Calculator")
                .ClickCalculatorLink()
                .fillPricingPage(defaultList)
                .AddToEstimate()
                .EmailEstimate();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input_529")));
        //Setup Email
        YOPmailHomePage yopMailHomePage = new YOPmailHomePage(driver);
        String generatedMail = yopMailHomePage.openPage()
                .OpenGenerator()
                .getEmail();
        logger.info("Created mail with name: " + generatedMail);

        //Set Email to pricing
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        Double sumFromPricing = pricingPage.moveToFrameTwo()
                .inputEmailInEstimate(generatedMail)
                .sendMail()
                .makeCalculation();

        //Checking incoming mail
        driver.switchTo().window(tabs.get(tabs.size()-1));
        YOPmailGeneratorPage generatorPage = new YOPmailGeneratorPage(driver);
        Double sumFromMail = generatorPage.checkMail()
                .refreshMails()
                .moveToMailFrame()
                .getPriceFromMail();

        Assert.assertEquals(sumFromMail, sumFromPricing);
    }

}
