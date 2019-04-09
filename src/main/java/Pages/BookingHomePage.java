package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BookingHomePage extends AbstractBrowserTestBase {

    @FindBy(id = "logo_no_globe_new_logo")
    private WebElement bookingLogo;

    @FindBy(id = "ss")
    private WebElement searchField;

    @FindBy(className = "sb-searchbox__button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span")
    private WebElement checkInButton;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr/td")
    private List<WebElement> columns;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[2]/td[1]")
    private WebElement dayButton;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/div")
    private WebElement monthYearButton;

    @FindBy(className = "bui-calendar__control--next")
    private WebElement nextButton;

    public BookingHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BookingHomePage isBookingLaunched() {
        Assert.assertTrue(bookingLogo.isDisplayed());
        System.out.println("Booking.com is successfully launched!");
        return this;
    }

    public BookingHomePage inputSearchTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
        return this;
    }

    public BookingHomePage submitSearch() {
        searchButton.click();
        return this;
    }

    public BookingHomePage openCalendar() {
        checkInButton.click();
        return this;
    }

    public BookingHomePage selectMonth(String month) {
        while (!monthYearButton.getText().equals(month)) {
            nextButton.click();
        }
        return this;
    }

    public BookingHomePage selectDay(String day) {
        for (WebElement cell : columns) {
            if (cell.getText().equals(day)) {
                cell.click();
                break;
            }
        }
        return this;
    }

    public BookingHomePage performSearch(String cityName, String dayFrom, String monthAndYearFrom, String dayTo, String monthAndYearTo) {
        inputSearchTerm(cityName);
        openCalendar();
        selectMonth(monthAndYearFrom);
        selectDay(dayFrom);
        selectMonth(monthAndYearTo);
        selectDay(dayTo);
        submitSearch();
        return this;
    }
}










