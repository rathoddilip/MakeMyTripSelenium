package com.selenium.makemytrip.utility;

public class UtilityClass {

    public static int priceConverter(String priceText) {
        String priceValue = priceText.replaceAll("[^(0-9)]+", "");
        return Integer.parseInt(priceValue);
    }
}
