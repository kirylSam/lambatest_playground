package Tests;

import base.BaseTest;
import org.kirylSam.WebPages.radioButtonDemo.RadioButtonDropdownDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonDropdownDemoTests extends BaseTest {
    @Test
    public void testSingleSelectDropdown() {
        logger.debug("Running First Radio Button Dropdown Test");
        RadioButtonDropdownDemoPage page = new RadioButtonDropdownDemoPage(driver);
        page.clickMaleRadioButton();
        page.clickGetValueButton();
        Assert.assertTrue(page.checkIfRadiobuttonIsCheckedLabelDisplaysCorrectValue("Male"));
        page.clickFemaleRadioButton();
        page.clickGetValueButton();
        Assert.assertTrue(page.checkIfRadiobuttonIsCheckedLabelDisplaysCorrectValue("Female"));
    }

    @Test
    public void testDisabledRadioButtons() {
        logger.debug(("Running Disabled Radio Button test"));
        RadioButtonDropdownDemoPage page = new RadioButtonDropdownDemoPage(driver);
        Assert.assertTrue(page.isButtonEnabled("Radio Button 1"));
        Assert.assertTrue(page.isButtonEnabled("Radio Button 2"));
        Assert.assertFalse(page.isButtonEnabled("Disabled Radio Button"));
    }

    @Test
    public void testGetGenderAndAgeValues() {
        //Click Male, click O to 5, click Get Values
        //Compare displayed values

        //Click Female, click 5 to 15, click Get Values
        //Compare displayed values
    }
}
