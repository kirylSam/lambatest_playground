import org.kirylSam.Page1;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {
    @Test
    public void firstTest() {
        Page1 page = new Page1(driver);
        page.openGoogleTest();
    }
}
