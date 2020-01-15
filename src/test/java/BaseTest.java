import drivers.Drivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        Drivers.create(Drivers.DEFAULT_DRIVER_NAME, Drivers.CHROME_DRIVER);
        driver = Drivers.get(Drivers.DEFAULT_DRIVER_NAME);
    }

    @AfterClass
    public static void tearDown(){
        Drivers.clear();
    }
}
