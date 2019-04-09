package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import java.util.List;


public class ResultsPage extends AbstractBrowserTestBase {

    @FindBy(xpath = "//*[@id=\"right\"]/div[3]/div/div/div/h2")
    private WebElement resultsBar;

    @FindBy(className = "address")
    private List<WebElement> locationButtons;

    @FindBy(xpath = "//*[@id=\"search_results_table\"]/div[4]/div[1]/ul/li[2]/ul/li/a")
    private List<WebElement> pagination;

    @FindBy(xpath = "//*[@id=\"search_results_table\"]/div[4]/div[1]/ul/li[3]/a")
    private WebElement nextButton;

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ResultsPage readLocation(String city) {
        int i = 0;
        for (WebElement element : locationButtons) {
            Assert.assertTrue(waitMethodVisibilityOf(element).getText().contains(city));
            i++;
        }
        System.out.println("All found " + i + " hotels on the page are placed in " + city);
        return this;
    }


}












