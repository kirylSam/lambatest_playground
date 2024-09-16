package org.kirylSam.WebPages.selectDropdownDemo;

import org.kirylSam.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
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

    @FindBy(how = How.ID, using = "multi-select")
    WebElement multiSelect;

    @FindBy(how = How.CLASS_NAME, using = "genderbutton")
    WebElement multiSelectFirstOptionDisplayedValue;

    @FindBy(how = How.CSS, using = ".block.break-words.groupradiobutton")
    WebElement multiSelectSecondOptionDisplayedValue;

    @FindBy(how = How.ID, using = "printMe")
    WebElement getFirstSelectedButton;

    @FindBy(how = How.ID, using = "printAll")
    WebElement getLastSelectedButton;

    private void navigateToPage() {
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
    }

    private Select selectOne () {
        return new Select(selectOneOption);
    }

    private Select selectMultiple () {
        return new Select(multiSelect);
    }

    public void selectOptionInSingleSelectDropdown() {
        selectOne().selectByValue("Sunday");
    }

    public boolean checkIfDisplayedDaySelectedIsCorrect() {
        Wait<WebDriver> wait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        String displayedText = wait.until(driver -> selectOneOptionDisplayedValue).getText();
        return displayedText.contains("Sunday");
    }

    public void selectTwoOptionsInMultiSelect() {
        Actions actions = new Actions(driver);
        Select select = selectMultiple();
        List<WebElement> options = select.getOptions();

        actions.keyDown(Keys.CONTROL)
                .click(options.get(0))
                .click(options.get(1))
                .build()
                .perform();
    }

    public boolean checkIfDisplayedMultiStateFirstSelectedIsCorrect() {
        getFirstSelectedButton.click();
        Wait<WebDriver> wait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        String displayedText = wait.until(driver -> multiSelectFirstOptionDisplayedValue).getText();
        return displayedText.contains("California");
    }

    public boolean checkIfDisplayedMultiStateLastSelectedIsCorrect() {
        getLastSelectedButton.click();
        Wait<WebDriver> wait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        String displayedText = wait.until(driver -> multiSelectSecondOptionDisplayedValue).getText();
        return displayedText.contains("California,Florida");
    }
}
