package Tests;

import base.BaseTest;
import org.kirylSam.WebPages.selectDropdownDemo.SelectDropdownDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDropdownDemoTests extends BaseTest {
    @Test
    public void testSingleSelectDropdown() {
        SelectDropdownDemoPage page = new SelectDropdownDemoPage(this.driver);
        page.selectOptionInSingleSelectDropdown();
        Assert.assertTrue(page.checkIfDisplayedDaySelectedIsCorrect(), "Check the test");
    }
}
