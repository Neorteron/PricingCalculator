package FirstTask.page;

import org.openqa.selenium.WebDriver;

public class NewPastePage {
    private WebDriver driver;

    public NewPastePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
