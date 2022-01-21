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


    public GoogleCloudPricingPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingPage fillPricingPage(PricingList pricingList){
        switchFrames();

        instances.sendKeys(pricingList.getInstances().toString());

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(series));
        series.click();
        setSeries(pricingList.getSeries());

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineType));
        machineType.click();
        setMachineType(pricingList.getMachineType());

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuCheckbox));
        if (pricingList.haveGPU().equals("true")) {
            gpuCheckbox.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuType));
            gpuType.click();
            setGpuType(pricingList.getGpuType());

            gpuNumber.click();
            setGpuNumber(pricingList.getGpuNumber());

            localSSD.click();
            setLocalSSD(pricingList.getLocalSSD());
        }

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(dataCenter));
        dataCenter.click();
        setDataCenter(pricingList.getDataCenter());

        committedUsage.click();
        setCommittedUsage(pricingList.getCommittedUsage());

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

    private void setSeries(String series){
        String xpathLink = "//md-option[contains(., '"+ series +"')]";
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLink)));
        driver.findElement(By.xpath(xpathLink)).click();
    }

    private void setMachineType(String machineType){
        String xpathLink = "//md-option[contains(., '"+machineType+"')]";
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLink)));
        driver.findElement(By.xpath(xpathLink)).click();
    }

    private void setGpuType(String gpuType){
        String xpathLink = "//md-option[contains(., '"+gpuType+"')]";
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLink)));
        driver.findElement(By.xpath(xpathLink)).click();
    }

    private void setGpuNumber(String gpuNumber){
        String xpathLink = "(//md-option[@value="+gpuNumber+"][@ng-value='item.value'])[2]";
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLink)));
        driver.findElement(By.xpath(xpathLink)).click();
    }

    private void setLocalSSD(String localSSD){
        String xpathLink = "//md-option[contains(., '"+localSSD+"')]";
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLink)));
        driver.findElement(By.xpath(xpathLink)).click();
    }

    private void setDataCenter(String dataCenter){
        String xpathLink = "(//md-option[contains(., '"+dataCenter+"')])[3]";
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLink)));
        driver.findElement(By.xpath(xpathLink)).click();
    }

    private void setCommittedUsage(String committedUsage){
        String xpathLink = "(//md-option[contains(., '"+committedUsage+"')])[2]";
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLink)));
        driver.findElement(By.xpath(xpathLink)).click();
    }
}

