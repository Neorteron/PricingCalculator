package Framework.Page;

import Framework.Model.PricingList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.invoke.SwitchPoint;

public class GoogleCloudPricingPage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"input_75\"]")
    WebElement instances;
    @FindBy(xpath = "//*[@id=\"select_102\"]") WebElement machineType;
    @FindBy(css = "#select_100") WebElement series;
    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[11]/div[1]/md-input-container/md-checkbox") WebElement gpuCheckbox;
    @FindBy(css = "#select_451") WebElement gpuType;
    @FindBy(css = "#select_453") WebElement gpuNumber;
    @FindBy(css = "#select_413") WebElement localSSD;
    @FindBy(css = "#select_108") WebElement dataCenter;
    @FindBy(css = "#select_115") WebElement committedUsage;
    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[18]/button") WebElement estimate;
    @FindBy(css = "#email_quote") WebElement emailEstimate;
    @FindBy(css = "#input_528") WebElement estimateEmailInput;
    @FindBy(xpath = "//*[@id=\"dialogContent_534\"]/form/md-dialog-actions/button[2]") WebElement sendMailButton;
    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[5]/div[2]") WebElement binding1;
    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[7]/div[2]") WebElement binding2;



    public GoogleCloudPricingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingPage fillPricingPage(PricingList pricingList){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"myFrame\"]")));
        instances.sendKeys(pricingList.getInstances().toString());

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(series));
        series.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select_option_215")));
        switch (pricingList.getSeries()){
            case "N1":
                driver.findElement(By.cssSelector("#select_option_215")).click();
                break;
            case "N2":
                driver.findElement(By.cssSelector("#select_option_216")).click();
                break;
            case "E2":
                driver.findElement(By.cssSelector("#select_option_217")).click();
                break;
            default:
                driver.findElement(By.cssSelector("#select_option_215")).click();
                break;
        }

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(dataCenter));
        dataCenter.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select_option_236")));
        switch (pricingList.getDataCenter()){
            case "Frankfurt":
                driver.findElement(By.cssSelector("#select_option_236")).click();
                break;
            case "London":
                driver.findElement(By.cssSelector("#select_option_235")).click();
                break;
            case "Taiwan":
                driver.findElement(By.cssSelector("#select_option_238")).click();
                break;
            default:
                driver.findElement(By.cssSelector("#select_option_236")).click();
                break;
        }

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(machineType));
        machineType.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select_option_418")));
        switch (pricingList.getMachineType()){
            case "n1-standard-8":
                driver.findElement(By.cssSelector("#select_option_418")).click();
                break;
            case "n1-standard-4":
                driver.findElement(By.cssSelector("#select_option_728")).click();
                break;
            case "n2-standard-8":
                driver.findElement(By.cssSelector("#select_option_762")).click();
                break;
            case "n2-standard-4":
                driver.findElement(By.cssSelector("#select_option_761")).click();
                break;
            case "e2-standard-8":
                driver.findElement(By.cssSelector("#select_option_812")).click();
                break;
            case "e2-standard-4":
                driver.findElement(By.cssSelector("#select_option_811")).click();
                break;
            default:
                driver.findElement(By.cssSelector("#select_option_418")).click();
                break;
        }

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuCheckbox));
        if (pricingList.haveGPU().equals("true")) {
            gpuCheckbox.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuType));
            gpuType.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select_option_458")));
            switch (pricingList.getGpuType()){
                case "NVIDIA Tesla V100":
                    driver.findElement(By.cssSelector("#select_option_458")).click();
                    setGpuNumberOnGpuType("NVIDIA Tesla V100", pricingList.getGpuNumber());
                    break;
                case "NVIDIA Tesla P4":
                    driver.findElement(By.cssSelector("#select_option_457")).click();
                    break;
                case "NVIDIA Tesla T4":
                    driver.findElement(By.cssSelector("#select_option_459")).click();
                    break;
                default:
                    driver.findElement(By.cssSelector("#select_option_458")).click();
                    break;
            }


            localSSD.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select_option_439")));

            switch (pricingList.getLocalSSD()){
                case "1x375 GB":
                    driver.findElement(By.cssSelector("#select_option_438")).click();
                    break;
                case "2x375 GB":
                    driver.findElement(By.cssSelector("#select_option_439")).click();
                    break;
                case "3x375 GB":
                    driver.findElement(By.cssSelector("#select_option_440")).click();
                    break;
                default:
                    driver.findElement(By.cssSelector("#select_option_439")).click();
                    break;
            }
        }



        committedUsage.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select_option_112")));
        switch (pricingList.getCommittedUsage()){
            case "0":
                driver.findElement(By.cssSelector("#select_option_112")).click();
                break;
            case "1":
                driver.findElement(By.cssSelector("#select_option_113")).click();
                break;
            case "3":
                driver.findElement(By.cssSelector("#select_option_114")).click();
                break;
            default:
                driver.findElement(By.cssSelector("#select_option_113")).click();
                break;
        }


        return this;
    }


    public GoogleCloudPricingPage moveToFrameTwo(){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"myFrame\"]")));
        return this;
    }

    public GoogleCloudPricingPage setInstances(String text){
        instances.sendKeys(text);
        return this;
    }

    public GoogleCloudPricingPage setSeries(By option){
        series.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(option));
        driver.findElement(option).click();
        return this;
    }

    public GoogleCloudPricingPage setMachineType(By option){
        machineType.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(option));
        driver.findElement(option).click();
        return this;
    }

    public GoogleCloudPricingPage SetGpu(){
        gpuCheckbox.click();
        return this;
    }

    public GoogleCloudPricingPage SetGpuType(By option){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuType));
        gpuType.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(option));
        driver.findElement(option).click();
        return this;
    }

    public GoogleCloudPricingPage SetGpuNumber(By option){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gpuNumber));
        gpuNumber.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(option));
        driver.findElement(option).click();
        return this;
    }

    public GoogleCloudPricingPage SetLocalSSD (By option){
        localSSD.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(option));
        driver.findElement(option).click();
        return this;
    }

    public GoogleCloudPricingPage SetDataCenter(By option){
        dataCenter.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(option));
        driver.findElement(option).click();
        return this;
    }

    public GoogleCloudPricingPage SetCommittedUsage(By option){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(committedUsage));
        committedUsage.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(option));
        driver.findElement(option).click();
        return this;
    }
    public GoogleCloudPricingPage AddToEstimate(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(estimate));
        estimate.click();
        return this;
    }
    public GoogleCloudPricingPage EmailEstimate(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(emailEstimate));
        emailEstimate.click();
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
        Double price1 = Double.parseDouble(binding1.getText().replaceFirst("USD ", ""));
        Double price2 = Double.parseDouble(binding2.getText().replaceFirst("USD ", ""));
        return price1+price2;
    }

    private void setGpuNumberOnGpuType (String GpuType, String number){

        gpuNumber.click();
        switch (GpuType){
            case "NVIDIA Tesla T4":
                new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#select_option_485")));
                switch (number){
                    case "0":
                        driver.findElement(By.cssSelector("#select_option_485")).click();
                        break;
                    case "1":
                        driver.findElement(By.cssSelector("#select_option_486")).click();
                        break;
                    case "2":
                        driver.findElement(By.cssSelector("#select_option_487")).click();
                        break;
                    case "4":
                        driver.findElement(By.cssSelector("#select_option_488")).click();
                        break;
                    default:
                        driver.findElement(By.cssSelector("#select_option_486")).click();
                        break;
                }
                break;
            case "NVIDIA Tesla P4":
                new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#select_option_495")));
                switch (number){
                    case "0":
                        driver.findElement(By.cssSelector("#select_option_494")).click();
                        break;
                    case "1":
                        driver.findElement(By.cssSelector("#select_option_495")).click();
                        break;
                    case "2":
                        driver.findElement(By.cssSelector("#select_option_496")).click();
                        break;
                    case "4":
                        driver.findElement(By.cssSelector("#select_option_497")).click();
                        break;
                    default:
                        driver.findElement(By.cssSelector("#select_option_495")).click();
                        break;
                }
                break;
            case "NVIDIA Tesla V100":
                new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#select_option_462")));
                switch (number){
                    case "0":
                        driver.findElement(By.cssSelector("#select_option_461")).click();
                        break;
                    case "1":
                        driver.findElement(By.cssSelector("#select_option_462")).click();
                        break;
                    case "2":
                        driver.findElement(By.cssSelector("#select_option_463")).click();
                        break;
                    case "4":
                        driver.findElement(By.cssSelector("#select_option_464")).click();
                        break;
                    case "8":
                        driver.findElement(By.cssSelector("#select_option_465")).click();
                        break;
                    default:
                        driver.findElement(By.cssSelector("#select_option_462")).click();
                        break;
                }
                break;

        }


    }
}

