package org.kirylSam.WebPages.radioButtonDemo;

import org.kirylSam.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class RadioButtonDropdownDemoPage extends BasePage {
    public RadioButtonDropdownDemoPage(WebDriver driver) {
        super(driver);
        navigateToPage();
        waitForCookiesPopupAndAcceptIt();
    }


    @FindBy(how = How.XPATH, using = "//input[@name='optradio' and @value='Male']" )
    private WebElement maleRadioButton;

    @FindBy(how = How.XPATH, using = "//input[@name='optradio' and @value='Female']" )
    private WebElement femaleRadioButton;

    @FindBy(how = How.ID, using = "buttoncheck")
    private WebElement getFirstValueButton;

    @FindBy(how = How.CSS, using = ".my-10")
    private WebElement radioButtonIsCheckedLabel;

    @FindBy(how = How.CSS, using = "input[type='radio'][value='RadioButton1']")
    private WebElement radioButton1;

    @FindBy(how = How.CSS, using = "input[type='radio'][value='RadioButton2']")
    private WebElement radioButton2;

    @FindBy(how = How.CSS, using = "input[type='radio'][value='RadioButton3']")
    private WebElement disabledRadioButton;

    @FindBy(how = How.XPATH, using = "//input[@name='gender' and @value='Male']" )
    private WebElement maleGetSelectedSectionRadioButton;

    @FindBy(how = How.XPATH, using = "//input[@name='gender' and @value='Female']" )
    private WebElement femaleGetSelectedSectionRadioButton;

    @FindBy(how = How.XPATH, using = "//input[@name='gender' and @value='Other']" )
    private WebElement otherGetSelectedSectionRadioButton;

    @FindBy(how = How.XPATH, using = "//input[@name='ageGroup' and @value='0 - 5']" )
    private WebElement zeroToFiveGetSelectedSectionRadioButton;

    @FindBy(how = How.XPATH, using = "//input[@name='ageGroup' and @value='5 - 15']" )
    private WebElement fiveToFifteenGetSelectedSectionRadioButton;

    @FindBy(how = How.XPATH, using = "//input[@name='ageGroup' and @value='15 - 50']" )
    private WebElement fifteenToFiftyGetSelectedSectionRadioButton;

    @FindBy(how = How.CSS, using = "[class='mt-30 rounded']:nth-of-type(3) button")
    private WebElement getValuesButton;


    private void navigateToPage() {
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
    }

    public void clickMaleRadioButton() {
        maleRadioButton.click();
    }

    public void clickFemaleRadioButton() {
        femaleRadioButton.click();
    }

    public void clickGetValueButton() {
        getFirstValueButton.click();
    }

    public boolean checkIfRadiobuttonIsCheckedLabelDisplaysCorrectValue(String value) {
        Wait<WebDriver> wait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        String displayedText = wait.until(driver -> radioButtonIsCheckedLabel).getText();
        return displayedText.contains(value);
    }

    public boolean isButtonEnabled(String radioButtonName) {
        return switch (radioButtonName) {
            case "Radio Button 1" -> radioButton1.isEnabled();
            case "Radio Button 2" -> radioButton2.isEnabled();
            case "Disabled Radio Button" -> disabledRadioButton.isEnabled();
            default -> false;
        };
    }
}


