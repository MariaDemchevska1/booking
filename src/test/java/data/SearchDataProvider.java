package data;

import org.testng.annotations.DataProvider;

public class SearchDataProvider {

    private static String cityName = "New York";
    private static String dayFrom = "10";
    private static String dayTo = "15";
    private static String monthAndYearFrom = "June 2019";
    private static String monthAndYearTo = "June 2019";


    @DataProvider(name = "searchDateProvider")
    public static Object[][] emptyAlertsProvider() {
        return new Object[][]{
                {cityName, dayFrom, monthAndYearFrom, dayTo, monthAndYearTo }
        };
    }

}



