package Framework.Test;

import Framework.Page.GoogleCloudHomePage;
import Framework.Page.GoogleCloudPricingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetToPricingPageTest extends CommonConditions {
    private final Logger logger = LogManager.getRootLogger();
    By header = By.xpath("//h2[contains(., 'Google Cloud Pricing Calculator')]");



    @Test
    public void getToPricingPage() {
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);

        GoogleCloudPricingPage pricingPage = googleCloudHomePage.openPage()
                .inputSearchText("Google Cloud Platform Pricing Calculator")
                .clickCalculatorLink();

        Assert.assertTrue(driver.getCurrentUrl().contains("calculator"));

    }
}
