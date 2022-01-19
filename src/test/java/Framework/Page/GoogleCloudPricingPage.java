package Framework.Page;

import Framework.Model.PricingList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleCloudPricingPage extends AbstractPage {
    @FindBy(xpath = "//input[@name='quantity']")
    WebElement instances;
    @FindBy(xpath = "//md-input-container[contains(., 'Machine type')]/md-select")
    WebElement machineType;
    @FindBy(xpath = "//md-input-container[contains(., 'Series')]/md-select")
    WebElement series;
    @FindBy(xpath = "//md-checkbox[contains(., 'Add GPUs')]")
    WebElement gpuCheckbox;
    @FindBy(xpath = "//md-input-container[contains(., 'GPU type')]/md-select")
    WebElement gpuType;
    @FindBy(xpath = "//md-input-container[contains(., 'Number of GPUs')]/md-select")
    WebElement gpuNumber;
    @FindBy(xpath = "//md-input-container[contains(., 'Local SSD')]/md-select")
    WebElement localSSD;
    @FindBy(xpath = "//md-input-container[contains(., 'Datacenter location')]/md-select")
    WebElement dataCenter;
    @FindBy(xpath = "//md-input-container[contains(., 'Committed usage')]/md-select")
    WebElement committedUsage;
    @FindBy(xpath = "//button[contains(., 'Add to Estimate')][1]")
    WebElement estimate;
    @FindBy(css = "#email_quote")
    WebElement emailEstimate;
    @FindBy(xpath = "//md-input-container[contains(., 'Email')]/input")
    WebElement estimateEmailInput;
    @FindBy(xpath = "//button[contains(., 'Send Email')]")
    WebElement sendMailButton;
    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    WebElement frame1;
    @FindBy(xpath = "//*[@id=\"myFrame\"]")
    WebElement frame2;
    @FindBy(xpath = "//md-option[contains(., 'N1')]")
    WebElement seriesN1;
    @FindBy(xpath = "//md-option[contains(., 'N2')]")
    WebElement seriesN2;
    @FindBy(xpath = "//md-option[contains(., 'E2')]")
    WebElement seriesE2;
    @FindBy(xpath = "(//md-option[contains(., 'London')])[3]")
    WebElement dataCenterLondon;
    @FindBy(xpath = "(//md-option[contains(., 'Frankfurt (europe-west3)')])[3]")
    WebElement dataCenterFrankfurt;
    @FindBy(xpath = "(//md-option[contains(., 'Taiwan')])[3]")
    WebElement dataCenterTaiwan;
    @FindBy(xpath = "//md-option[contains(., 'n1-standard-8')]")
    WebElement machineTypeN1_8;
    @FindBy(xpath = "//md-option[contains(., 'n1-standard-4')]")
    WebElement machineTypeN1_4;
    @FindBy(xpath = "//md-option[contains(., 'n2-standard-8 (vCPU')]")
    WebElement machineTypeN2_8;
    @FindBy(xpath = "//md-option[contains(., 'n2-standard-4')]")
    WebElement machineTypeN2_4;
    @FindBy(xpath = "//md-option[contains(., 'e2-standard-8')]")
    WebElement machineTypeE2_8;
    @FindBy(xpath = "//md-option[contains(., 'e2-standard-4')]")
    WebElement machineTypeE2_4;
    @FindBy(xpath = "//md-option[contains(., 'NVIDIA Tesla V100')]")
    WebElement gpuTypeV100;
    @FindBy(xpath = "//md-option[contains(., 'NVIDIA Tesla P4')]")
    WebElement gpuTypeP4;
    @FindBy(xpath = "//md-option[contains(., 'NVIDIA Tesla T4')]")
    WebElement gpuTypeT4;
    @FindBy(xpath = "(//md-option[@value=1][@ng-value='item.value'])[2]")
    WebElement gpuNumber1;
    @FindBy(xpath = "(//md-option[@value=2][@ng-value='item.value'])[2]")
    WebElement gpuNumber2;
    @FindBy(xpath = "(//md-option[@value=4][@ng-value='item.value'])[2]")
    WebElement gpuNumber4;
    @FindBy(xpath = "//md-option[contains(., '1x375')]")
    WebElement localSSD_1x375;
    @FindBy(xpath = "//md-option[contains(., '2x375')]")
    WebElement localSSD_2x375;
    @FindBy(xpath = "//md-option[contains(., '3x375')]")
    WebElement localSSD_3x375;
    @FindBy(xpath = "(//md-option[contains(., 'None')])[2]")
    WebElement comittedUsage_None;
    @FindBy(xpath = "(//md-option[contains(., '1 Year')])[2]")
    WebElement comittedUsage_1year;
    @FindBy(xpath = "(//md-option[contains(., '3 Years')])[2]")
    WebElement comittedUsage_3years;


    public GoogleCloudPricingPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingPage fillPricingPage(PricingList pricingList){
        switchFrames();

        instances.sendKeys(pricingList.getInstances().toString());

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(series));
        series.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(seriesN1));
        switch (pricingList.getSeries()){
            case "N1":
                seriesN1.click();
                break;
            case "N2":
                seriesN2.click();
                break;
            case "E2":
                seriesE2.click();
                break;
            default:
                seriesN2.click();
                break;
        }

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineType));
        machineType.click();
        switch (pricingList.getMachineType()){
            case "n1-standard-8":
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineTypeN1_8));
                machineTypeN1_8.click();
                break;
            case "n1-standard-4":
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineTypeN1_4));
                machineTypeN1_4.click();
                break;
            case "n2-standard-8":
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineTypeN2_8));
                machineTypeN2_8.click();
                break;
            case "n2-standard-4":
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineTypeN2_4));
                machineTypeN2_4.click();
                break;
            case "e2-standard-8":
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineTypeE2_8));
                machineTypeE2_8.click();
                break;
            case "e2-standard-4":
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineTypeE2_4));
                machineTypeE2_4.click();
                break;
            default:
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineTypeN2_8));
                machineTypeN2_8.click();
                break;
        }

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuCheckbox));
        if (pricingList.haveGPU().equals("true")) {
            gpuCheckbox.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuType));
            gpuType.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuTypeV100));
            switch (pricingList.getGpuType()){
                case "NVIDIA Tesla V100":
                    gpuTypeV100.click();
                    break;
                case "NVIDIA Tesla P4":
                    gpuTypeP4.click();
                    break;
                case "NVIDIA Tesla T4":
                    gpuTypeT4.click();
                    break;
                default:
                    gpuTypeV100.click();
                    break;
            }

            gpuNumber.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuNumber1));
            switch (pricingList.getGpuNumber()){
                case "1":
                    gpuNumber1.click();
                    break;
                case "2":
                    gpuNumber2.click();
                    break;
                case "4":
                    gpuNumber4.click();
                    break;
                default:
                    gpuNumber1.click();
                    break;
            }

            localSSD.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(localSSD_1x375));

            switch (pricingList.getLocalSSD()){
                case "1x375 GB":
                    localSSD_1x375.click();
                    break;
                case "2x375 GB":
                    localSSD_2x375.click();
                    break;
                case "3x375 GB":
                    localSSD_3x375.click();
                    break;
                default:
                    localSSD_1x375.click();
                    break;
            }
        }

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(dataCenter));
        dataCenter.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(dataCenterFrankfurt));
        switch (pricingList.getDataCenter()){
            case "Frankfurt":
                dataCenterFrankfurt.click();
                break;
            case "London":
                dataCenterLondon.click();
                break;
            case "Taiwan":
                dataCenterTaiwan.click();
                break;
            default:
                dataCenterFrankfurt.click();
                break;
        }
        
        committedUsage.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(comittedUsage_None));
        switch (pricingList.getCommittedUsage()){
            case "0":
                comittedUsage_None.click();
                break;
            case "1":
                comittedUsage_1year.click();
                break;
            case "3":
                comittedUsage_3years.click();
                break;
            default:
                comittedUsage_1year.click();
                break;
        }


        return this;
    }


    public GoogleCloudPricingPage moveToFrameTwo(){
        driver.switchTo().frame(frame1);
        driver.switchTo().frame(frame2);
        return this;
    }

    public GoogleCloudPricingPage addToEstimate(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(estimate));
        estimate.click();
        return this;
    }
    public GoogleCloudPricingPage emailEstimate(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(emailEstimate));
        emailEstimate.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input_529")));
        return this;
    }

    public GoogleCloudPricingPage inputEmailInEstimate(String email){
        estimateEmailInput.sendKeys(email);
        return this;
    }

    public GoogleCloudPricingPage sendMail(){
        sendMailButton.click();
        return this;
    }

    public Double makeCalculation(){
        Double sum = 0.0;
        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='ng-binding'][contains(., 'USD')]"));
        for (WebElement price:webElementList) {
        sum = sum + Double.parseDouble(price.getText().replaceFirst("USD ", ""));
        }
        return sum;
    }

    private void switchFrames(){
        driver.switchTo().frame(frame1);
        driver.switchTo().frame(frame2);
    }
}

