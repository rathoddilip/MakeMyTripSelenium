package com.selenium.makemytrip.pages;

import com.selenium.makemytrip.base.BaseClass;
import com.selenium.makemytrip.utility.UtilityClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dashboard extends BaseClass {

    String departureMonth = "August2021";
    String departureDate = "5";
    String returnMonth = "August2021";
    String returnDate = "12";

    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    WebElement roundTripButton;
    @FindBy(xpath = "//span[normalize-space()='From']")
    WebElement findFrom;
    @FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/div/input")
    WebElement fromInput;
    @FindBy(css = "p[class='font14 appendBottom5 blackText']")
    List<WebElement> listFromInputCity;
    @FindBy(xpath = "//span[normalize-space()='To']")
    WebElement findTo;
    @FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin makeFlex column spaceBetween']/div/input")
    WebElement toInput;
    @FindBy(css = "p[class='font14 appendBottom5 blackText']")
    List<WebElement> listToInputCity;
    @FindBy(xpath = "//span[normalize-space()='DEPARTURE']")
    WebElement departureLabel;
    @FindBy(xpath = "//div[@class='DayPicker-Months']/div[1]/div[1]/div")
    WebElement todayDateDep;
    @FindBy(xpath = "//span[@aria-label='Next Month']")
    WebElement nextMonth;
    @FindBy(xpath = "//div[@class='dateInnerCell']/p")
    List<WebElement> listDate;
    @FindBy(xpath = "//span[normalize-space()='RETURN']")
    WebElement returnLabel;
    @FindBy(xpath = "//div[@class='DayPicker-Months']/div[1]/div[3]/div/div[@class='DayPicker-Day']/div/p[1]")
    List<WebElement> listReturnDate;
    @FindBy(xpath = "//div[@class='DayPicker-Months']/div[1]/div[1]/div")
    WebElement returnDatePath;
    @FindBy(xpath = "//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")
    WebElement search;
    @FindBy(xpath = "//b[contains(text(),'Mumbai → Bengaluru')]")
    List<WebElement> deparetureLocation;
    @FindBy(xpath = "//div[@class='paneView']//b[contains(text(),'Bengaluru → Mumbai')]")
    List<WebElement> returnLocation;
    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][1]/div/div/div/label[1]")
    WebElement on_non_stop;
    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][1]/div/div/div/label[2]")
    WebElement on_one_stop;
    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][2]/div/div/div/label[1]")
    WebElement return_non_stop;
    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][2]/div/div/div/label[2]")
    WebElement return_one_stop;
    @FindBy(xpath = "//div[@class='paneView'][1]/div[2]/div/div")
    List<WebElement> getAllDepartureFlights;
    @FindBy(xpath = "//div[@class='paneView'][2]/div[2]/div/div")
    List<WebElement> getAllReturnFlights;
    @FindBy(xpath = "//div[@class='paneView'][1]/div[2]/div/div/label/div/div[2]/div[2]/p")
    List<WebElement> departurePrice;
    @FindBy(xpath = "//div[@class='paneView'][2]/div[2]/div/div/label/div/div[2]/div[2]/p")
    List<WebElement> returnPrice;
    @FindBy(xpath = "//span[@class='whiteText blackFont fontSize16']")
    List<WebElement> bottomPagePrice;
    @FindBy(xpath = "//span[@class='whiteText fontSize22 boldFont']")
    WebElement bottomTotalPrice;

    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void from_round_trip() throws InterruptedException {

        Thread.sleep(2000);
        roundTripButton.click();
        Thread.sleep(1000);
        findFrom.click();
        Thread.sleep(1000);
        fromInput.sendKeys("Mumbai");
        Thread.sleep(1000);

        for (WebElement fromWebElement : listFromInputCity) {
            String fromCityName = fromWebElement.getText();
            System.out.println("From city :-> " + fromCityName);
            if (fromCityName.contains("Mumbai")) {
                fromWebElement.click();
                break;
            }
        }
        Thread.sleep(1000);
    }

    public void to_round_trip() throws InterruptedException {

        Thread.sleep(1000);
        findTo.click();
        Thread.sleep(1000);
        toInput.sendKeys("Bengaluru");
        Thread.sleep(2000);
        for (WebElement toWebElement : listToInputCity) {
            String toCityName = toWebElement.getText();
            System.out.println("To city:-> " + toCityName);
            if (toCityName.contains("Bengaluru")) {
                toWebElement.click();
                break;
            }
        }
    }

    public void select_departure_date() throws InterruptedException {

        Thread.sleep(2000);
        departureLabel.click();
        Thread.sleep(2000);
        while (true) {
            String departureTextMonth = todayDateDep.getText();
            System.out.println("Departure month: " + departureTextMonth);
            if (departureTextMonth.equals(departureMonth)) {
                break;
            } else {
                nextMonth.click();
            }
        }
        for (WebElement depWebElement : listDate) {

            String depaDate = depWebElement.getText();
            if (depaDate.contains(departureDate)) {
                depWebElement.click();
                System.out.println("Departure date:-> " + depaDate);
                break;
            }
        }
    }

    public void select_return_date() throws InterruptedException {
        Thread.sleep(2000);
        returnLabel.click();
        while (true) {
            String returnMonthText = returnDatePath.getText();
            System.out.println("Return month: " + returnMonthText);
            if (returnMonthText.equals(returnMonth)) {
                break;
            } else {
                nextMonth.click();
            }
        }
        for (WebElement returnWebElement : listReturnDate) {

            String returnDateText = returnWebElement.getText();
            if (returnDateText.contains(returnDate)) {
                returnWebElement.click();
                System.out.println("Return date:-> " + returnDateText);
                break;
            }
        }
    }

    public void get_list_of_flights_Without_Filter() throws InterruptedException {
        search.click();
        Thread.sleep(4000);
        System.out.println("**********************************************************************************");
        System.out.println("List of departure flights without filter: " + getAllDepartureFlights.size());
        System.out.println("**********************************************************************************");
        for (WebElement departureElement : deparetureLocation) {
            System.out.println("Departure flight: " + departureElement.getText());

            for (WebElement listFlight : getAllDepartureFlights) {
                String flightsName = listFlight.getText();
                Thread.sleep(400);
                System.out.println("Flights Name: " + flightsName);
                System.out.println("----------------------------------------");
            }
        }
        Thread.sleep(4000);
        System.out.println("**********************************************************************************");
        System.out.println("List of return flights without filter: " + getAllReturnFlights.size());
        System.out.println("**********************************************************************************");
        for (WebElement departureElement : returnLocation) {
            System.out.println(" Return flight: " + departureElement.getText());

            for (WebElement listFlight : getAllReturnFlights) {
                String flightsName = listFlight.getText();
                Thread.sleep(400);
                System.out.println("Flights Name: " + flightsName);
                System.out.println("----------------------------------------");
            }
        }

    }

    public void get_list_of_flights_after_Filter() throws InterruptedException {
        on_non_stop.click();
        Thread.sleep(1000);
        on_one_stop.click();
        Thread.sleep(1000);
        return_non_stop.click();
        Thread.sleep(1000);
        return_one_stop.click();
        Thread.sleep(2000);
        System.out.println("**********************************************************************************");
        System.out.println("List of departure flights with filter: " + getAllDepartureFlights.size());
        System.out.println("**********************************************************************************");
        for (WebElement departureElement : deparetureLocation) {
            System.out.println("Departure flight: " + departureElement.getText());

            for (WebElement listFlight : getAllDepartureFlights) {
                String flightsName = listFlight.getText();
                Thread.sleep(400);
                System.out.println("Flights Name: " + flightsName);
                System.out.println("----------------------------------------");
            }

        }
        Thread.sleep(4000);
        System.out.println("**********************************************************************************");
        System.out.println("List of return flights without filter: " + getAllReturnFlights.size());
        System.out.println("**********************************************************************************");
        for (WebElement departureElement : returnLocation) {
            System.out.println(" Return flight: " + departureElement.getText());

            for (WebElement listFlight : getAllReturnFlights) {
                String flightsName = listFlight.getText();
                Thread.sleep(400);
                System.out.println("Flights Name: " + flightsName);
                System.out.println("----------------------------------------");
            }
        }
    }

    public void selectFlight() throws InterruptedException {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getAllDepartureFlights.get(4));
        Thread.sleep(2000);
        getAllDepartureFlights.get(4).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getAllReturnFlights.get(4));
        Thread.sleep(2000);
        getAllReturnFlights.get(4).click();
        Thread.sleep(1000);
    }

    public void verify_flight_price() {
        int priceDeparture = UtilityClass.priceConverter(departurePrice.get(4).getText());
        int priceReturn = UtilityClass.priceConverter(returnPrice.get(4).getText());
        System.out.println("Departure flight Price: " + priceDeparture);
        System.out.println("Return flight Price: " + priceReturn);
        boolean verifyDepPrice = departurePrice.get(4).getText().equals(bottomPagePrice.get(0).getText());
        System.out.println("Verify departure price with bottom page departure price:" + verifyDepPrice);
        boolean verifyRetPrice = returnPrice.get(4).getText().equals(bottomPagePrice.get(1).getText());
        System.out.println("Verify return price with bottom page return price price:" + verifyRetPrice);
    }

    public void verify_to_bottom_page_total_price() {
        int bottomDepPrice = UtilityClass.priceConverter(bottomPagePrice.get(0).getText());
        System.out.println("bottom page departure price: " + bottomDepPrice);
        int retBottomPrice = UtilityClass.priceConverter(bottomPagePrice.get(1).getText());
        System.out.println("bottom page return price: " + retBottomPrice);
        int totalBottomPrice = UtilityClass.priceConverter(bottomTotalPrice.getText());
        System.out.println("Total bottom page price: " + totalBottomPrice);
        int additionOfDepAndReturn = bottomDepPrice + retBottomPrice;
        System.out.println("Addition of Departure and return flight price :" + additionOfDepAndReturn);
        boolean verityBottomTotal = totalBottomPrice == additionOfDepAndReturn;
        System.out.println("verifying total price of bottom page: " + verityBottomTotal);
    }

}
