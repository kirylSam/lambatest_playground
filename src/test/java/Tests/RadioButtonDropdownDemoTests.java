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
        page.clickGetFirstValueButton();
        Assert.assertTrue(page.checkIfRadiobuttonIsCheckedLabelDisplaysCorrectValue("Male"));
        page.clickFemaleRadioButton();
        page.clickGetFirstValueButton();
        Assert.assertTrue(page.checkIfRadiobuttonIsCheckedLabelDisplaysCorrectValue("Female"));
    }
}
