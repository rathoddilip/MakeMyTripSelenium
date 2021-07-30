package com.selenium.makemytrip.test;

import com.selenium.makemytrip.base.BaseClass;
import com.selenium.makemytrip.pages.Dashboard;
import com.selenium.makemytrip.pages.Login;
import org.testng.annotations.Test;

public class MakeMyTripTest extends BaseClass {

    @Test
    public void login_to_application() throws InterruptedException {
        Login login=new Login(driver);
        login.loginToApplication();
    }
    @Test
    public void round_trip_test() throws InterruptedException {
        Login login=new Login(driver);
        login.loginToApplication();
        Dashboard dashboard= new Dashboard(driver);
        dashboard.from_round_trip();
        dashboard.to_round_trip();
    }

    @Test
    public void round_trip_select_date_test() throws InterruptedException {
        Login login=new Login(driver);
        login.loginToApplication();
        Dashboard dashboard= new Dashboard(driver);
        dashboard.from_round_trip();
        dashboard.to_round_trip();
        dashboard.select_departure_date();
        dashboard.select_return_date();
        dashboard.clickSearch();
    }
}
