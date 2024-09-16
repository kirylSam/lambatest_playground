package Tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kirylSam.WebPages.selectDropdownDemo.SelectDropdownDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDropdownDemoTests extends BaseTest {
    @Test
    public void testSingleSelectDropdown() {
        logger.debug("Running Single Dropdown Test");
        SelectDropdownDemoPage page = new SelectDropdownDemoPage(this.driver);
        page.selectOptionInSingleSelectDropdown();
        Assert.assertTrue(page.checkIfDisplayedDaySelectedIsCorrect());
    }

    @Test
    public void testMultiSelectDropdown() {
        logger.debug("Running Multi Dropdown Test");
        SelectDropdownDemoPage page = new SelectDropdownDemoPage(this.driver);
        page.selectTwoOptionsInMultiSelect();
        Assert.assertTrue(page.checkIfDisplayedMultiStateFirstSelectedIsCorrect());
        Assert.assertTrue(page.checkIfDisplayedMultiStateLastSelectedIsCorrect());
    }
}
