package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBrowserTestBase {

    public WebDriver driver;

    protected WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
        driver = new ChromeDriver();
        return driver;
    }

    public void getUrl(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public WebElement waitMethodVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement waitForRefresh = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        return waitForRefresh;

    }

    public WebElement waitMethodToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement waitForRefresh = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
        return waitForRefresh;

    }

}



