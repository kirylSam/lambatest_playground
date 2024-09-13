package org.kirylSam.WebPages.selectDropdownDemo;

import org.kirylSam.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class SelectDropdownDemoPage extends BasePage {
    public SelectDropdownDemoPage(WebDriver driver) {
        super(driver);
        navigateToPage();
        waitForCookiesPopupAndAcceptIt();
    }

    @FindBy(how = How.XPATH, using = "//h1[.='Dropdown Demo']")
    WebElement pageHeader;

    @FindBy (how = How.CSS, using = "select#select-demo")
    WebElement selectOneOption;

    @FindBy(how = How.CSS, using = "[class='px-10 pt-10 pb-5'] p")
    WebElement selectOneOptionDisplayedValue;

    @FindBy(how = How.ID, using = "#multi-select")
    WebElement multiSelect;

    @FindBy(how = How.CLASS_NAME, using = "genderbutton")
    WebElement multiSelectFirstOptionDisplayedValue;

    @FindBy(how = How.CSS, using = ".block.break-words.groupradiobutton")
    WebElement multiSelectSecondOptionDisplayedValue;

    @FindBy(how = How.ID, using = "printMe")
    WebElement getFirstSelectedButton;

    @FindBy(how = How.ID, using = "printAll")
    WebElement getLastSelectedButton;

    private Select selectOne () {
        return new Select(selectOneOption);
    }

    public void selectOptionInSingleSelectDropdown() {
        selectOne().selectByValue("Sunday");
    }

    public Boolean checkIfDisplayedDaySelectedIsCorrect() {
        Wait<WebDriver> wait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        String displayedText = wait.until(driver -> selectOneOptionDisplayedValue).getText();
        return displayedText.contains("Sunday");
    }

    private void navigateToPage() {
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
    }
}
