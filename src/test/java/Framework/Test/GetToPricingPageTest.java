package Framework.Test;

import Framework.Page.GoogleCloudHomePage;
import Framework.Page.GoogleCloudPricingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetToPricingPageTest extends CommonConditions {
    private final Logger logger = LogManager.getRootLogger();




    @Test
    public void GetToPricingPage() {
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);

        GoogleCloudPricingPage pricingPage = googleCloudHomePage.openPage()
                .InputSearchText("Google Cloud Platform Pricing Calculator")
                .ClickCalculatorLink();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("calculator"));

    }
}
