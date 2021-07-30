package com.selenium.makemytrip.pages;

import com.selenium.makemytrip.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dashboard extends BaseClass {

    String departureMonth="July2021";
    String departureDate="31";
    String returnMonth="August2021";
    String returnDate="7";

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

    @FindBy(xpath = "//*[@id=\"listing-id\"]/div/div[1]")
    List<WebElement> listOfFlight;
    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void from_round_trip() throws InterruptedException {
        Thread.sleep(2000);
        roundTripButton.click();
        Thread.sleep(4000);
        findFrom.click();
        Thread.sleep(2000);
        fromInput.sendKeys("Mumbai");
        Thread.sleep(2000);
        for(WebElement fromWebElement:listFromInputCity)
        {
            String toCityName=fromWebElement.getText();
            System.out.println("From list of cities:-> " +toCityName);
            if(toCityName.contains("Mumbai"))
            {
                fromWebElement.click();
                break;
            }
        }
        Thread.sleep(3000);
    }

    public void to_round_trip() throws InterruptedException {
        Thread.sleep(2000);
        Thread.sleep(4000);
        findTo.click();
        Thread.sleep(2000);
        toInput.sendKeys("Bengaluru");
        Thread.sleep(2000);
        for(WebElement toWebElement:listToInputCity)
        {
            String toCityName=toWebElement.getText();
            System.out.println("To list of cities:-> "+toCityName);
            if(toCityName.contains("Bengaluru"))
            {
                toWebElement.click();
                break;
            }
        }
    }

    public void select_departure_date() throws InterruptedException {
        Thread.sleep(4000);
        departureLabel.click();
        Thread.sleep(2000);
        while (true)
        {
            String departureTextMonth=todayDateDep.getText();
            System.out.println("Departure month: "+departureTextMonth);
            if (departureTextMonth.equals(departureMonth))
            {
                break;
            }
            else {
                nextMonth.click();
            }
        }
        for(WebElement depWebElement:listDate)
        {
            String depaDate=depWebElement.getText();
            System.out.println("Departure date:-> "+depaDate);
            if(depaDate.contains(departureDate))
            {
                depWebElement.click();
                break;
            }
        }
    }
    public void select_return_date() throws InterruptedException {
        Thread.sleep(4000);
        returnLabel.click();
        while (true)
        {
            String returnMonthText=returnDatePath.getText();
            System.out.println("Return month: "+returnMonthText);
            if (returnMonthText.equals(returnMonth))
            {
                break;
            }
            else {
                nextMonth.click();
            }
        }
        for(WebElement returnWebElement:listReturnDate)
        {
            String returnDateText=returnWebElement.getText();
            System.out.println("Return date:-> "+returnDateText);
            if(returnDateText.contains(returnDate))
            {
                returnWebElement.click();
                break;
            }
        }
    }
    public void clickSearch() throws InterruptedException {

        search.click();
        System.out.println(listOfFlight.size());
        for(WebElement listFlight:listOfFlight)
        {
            String flightsName=listFlight.getText();
            Thread.sleep(4000);
            System.out.println("List of flights: "+flightsName);
        }
    }

}
