package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kirylSam.driver.DriverFactory;
import org.kirylSam.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    DriverManager driverManager;
    protected static final Logger logger = LogManager.getLogger();

    @BeforeMethod (alwaysRun = true)
    public void createDriver() {
        this.driverManager = DriverFactory.valueOf("CHROME").getDriverManager();
        this.driver = driverManager.getDriver();
    }

    @AfterMethod (alwaysRun = true)
    public void closeDriver() {
        driverManager.quitDriver();
    }
}
