package Framework.Test;

import Framework.Model.PricingList;
import Framework.Page.*;
import Framework.Service.ListCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class FillFormAndSendMailTest extends CommonConditions {

    private final Logger logger = LogManager.getRootLogger();


    @Test
    public void fillFormAndSendMail() {
        //Setup pricing
        PricingList defaultList = ListCreator.withCredentialsFromProperty();
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);

        GoogleCloudPricingPage pricingPage = googleCloudHomePage.openPage()
                .inputSearchText("Google Cloud Platform Pricing Calculator")
                .clickCalculatorLink()
                .fillPricingPage(defaultList)
                .addToEstimate()
                .emailEstimate();


        //Setup Email
        YopMailHomePage yopMailHomePage = new YopMailHomePage(driver);
        String generatedMail = yopMailHomePage.openPage()
                .openGenerator()
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
        YopMailGeneratorPage generatorPage = new YopMailGeneratorPage(driver);
        Double sumFromMail = generatorPage.checkMail()
                .refreshMails()
                .moveToMailFrame()
                .getPriceFromMail();

        Assert.assertEquals(sumFromMail, sumFromPricing);
    }

}
