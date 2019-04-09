import Pages.AbstractBrowserTestBase;
import Pages.BookingHomePage;
import Pages.ResultsPage;
import data.SearchDataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigProperties;


public class BookingSearchTest extends AbstractBrowserTestBase {

    @BeforeClass
    public void beforeTest() {
        getDriver();
        getUrl(ConfigProperties.getTestProperty("url"));
    }

    @Test(description = "Check all hotels have correct location",
            dataProvider = "searchDateProvider", dataProviderClass = SearchDataProvider.class)
    public void checkResultsTest(String cityName, String dayFrom, String monthAndYearFrom, String dayTo, String monthAndYearTo) {
        BookingHomePage bookingHomePage = new BookingHomePage(getDriver());
        ResultsPage resultsPage = new ResultsPage(getDriver());
        bookingHomePage.performSearch(cityName, dayFrom, monthAndYearFrom, dayTo, monthAndYearTo);
        resultsPage.readLocation(cityName);
    }

    @AfterClass
    public void afterTest() {
        closeBrowser();
    }

}
