package com.selenium.makemytrip.test;

import com.selenium.makemytrip.base.BaseClass;
import com.selenium.makemytrip.pages.Dashboard;
import com.selenium.makemytrip.pages.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakeMyTripTest extends BaseClass {

//    @Test()
//    public void login_to_application() throws InterruptedException {
//        Login login=new Login(driver);
//        login.loginToApplication();
//        String expectedUrl="https://www.makemytrip.com/";
//        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
//    }
//
//    @Test()
//    public void select_from_to_location() throws InterruptedException {
//        Login login=new Login(driver);
//        login.loginToApplication();
//        Dashboard dashboard= new Dashboard(driver);
//        dashboard.from_round_trip();
//        dashboard.to_round_trip();
//        String expectedUrl="https://www.makemytrip.com/";
//        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
//
//    }
//
//    @Test()
//    public void select_departureDate_and_returnDate() throws InterruptedException {
//        Login login=new Login(driver);
//        login.loginToApplication();
//        Dashboard dashboard= new Dashboard(driver);
//        dashboard.from_round_trip();
//        dashboard.to_round_trip();
//        dashboard.select_departure_date();
//        dashboard.select_return_date();
//        String expectedTitle="MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
//        Assert.assertEquals(driver.getTitle(),expectedTitle);
//    }

    @Test()
    public void flight_booking_and_verify() throws InterruptedException {
        Login login=new Login(driver);
        login.loginToApplication();
        Dashboard dashboard= new Dashboard(driver);
        dashboard.from_round_trip();
        dashboard.to_round_trip();
        dashboard.select_departure_date();
        dashboard.select_return_date();
        dashboard.get_list_of_flights_Without_Filter();
        dashboard.get_list_of_flights_after_Filter();
        dashboard.selectFlight();
        dashboard.verify_flight_price();
        dashboard.verify_to_bottom_page_total_price();
        System.out.println(driver.getCurrentUrl());
        String expectedUrl="https://www.makemytrip.com/flight/search?itinerary=BOM-BLR-03/08/2021_BLR-BOM-10/08/2021&tripType=R&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
}
