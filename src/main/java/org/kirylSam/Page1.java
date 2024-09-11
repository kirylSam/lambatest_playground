package org.kirylSam;

import org.openqa.selenium.WebDriver;

public class Page1 extends BasePageObject{

    public Page1(WebDriver driver) {
        super(driver);
    }

    public Page1 openGoogleTest() {
        //testing git
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        return this;
    }
}
