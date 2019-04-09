import Pages.AbstractBrowserTestBase;
import Pages.BookingHomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigProperties;


public class BookingIsLauchedTest extends AbstractBrowserTestBase {

    @BeforeClass
    public void beforeTest() {
        getDriver();
        getUrl(ConfigProperties.getTestProperty("url"));
    }

    @Test(description = "Check Booking.com can be opened")
    void openBooking() {
        BookingHomePage bookingHomePage = new BookingHomePage(getDriver());
        bookingHomePage.isBookingLaunched();
    }

    @AfterClass
    public void afterTest() {
        closeBrowser();
    }

}

