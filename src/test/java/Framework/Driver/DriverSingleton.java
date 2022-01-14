package Framework.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;
    private static final String RESOURCES_PATH = "src/test/java/Framework/Resourses/";

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            //System.setProperty("browser", "default");
            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--window-size=1920,1080");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                }
            }
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }



}
