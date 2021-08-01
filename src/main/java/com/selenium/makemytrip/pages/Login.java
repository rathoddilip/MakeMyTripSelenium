package com.selenium.makemytrip.pages;

import com.selenium.makemytrip.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {

    static String username = "diliprathodtest@gmail.com";
    static String password = "Login@123";

    @FindBy(xpath = "//ul[@class='userSection pushRight']/li[3]/div/p")
    WebElement login;
    @FindBy(id = "username")
    WebElement enterEmail;
    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement continueButton;
    @FindBy(id = "password")
    WebElement enterPassword;
    @FindBy(xpath = "//button[@class='capText font16']")
    WebElement loginButton;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication() throws InterruptedException {

        Thread.sleep(2000);
        login.click();
        Thread.sleep(2000);
        enterEmail.sendKeys(username);
        Thread.sleep(3000);
        continueButton.click();
        Thread.sleep(3000);
        enterPassword.sendKeys(password);
        Thread.sleep(3000);
        loginButton.click();
        Thread.sleep(500);
    }

}
