import io.qameta.allure.*;
import org.testng.annotations.Test;
import properties.PropertyHolder;
import web.pages.LoginPage;

import static utils.Groups.smoke;

@Epic("User management")
@Feature("Login")
public class LoginCanvaTest extends BaseTest {

    /**
     * 1) Login into Canva
     * 2) Search for A4 document
     * 3) Open it
     * 4) Edit this:
     * 4.1) Search for image
     * 4.2) Add the image into document
     */


    @Story("Bla-bla-bla")
    @Description("Description")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "allure", type = "issue")
    @Test(description = "Check possibility to login for just created user", groups = {smoke})
    public void loginCanvaTest() {

        driver.get(PropertyHolder.getPropValue("URL_Login"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login()
                .validateThatMenuDisplayed()
                .searchAnyItem("a4")
                .addImageIntoDocument();

    }

}
