package com.selenium.makemytrip.test;

import com.selenium.makemytrip.base.BaseClass;
import com.selenium.makemytrip.pages.Dashboard;
import com.selenium.makemytrip.pages.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakeMyTripTest extends BaseClass {

    @Test(priority = 1)
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
    }
}
