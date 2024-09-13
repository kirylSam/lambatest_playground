package org.kirylSam;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    WebElement acceptCookies;

    protected void waitForCookiesPopupAndAcceptIt() {
        //TODO FluentWait can be added here
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(acceptCookies)).click();

        System.out.println("Accepted cookies!");
    }
}
