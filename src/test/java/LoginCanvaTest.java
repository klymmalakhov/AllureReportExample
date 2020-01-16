import io.qameta.allure.*;
import org.testng.annotations.Test;
import properties.PropertyHolder;
import web.pages.LoginPage;

import static io.qameta.allure.Allure.step;
import static utils.Groups.smoke;

@Epic("User management")
@Feature("Login")
public class LoginCanvaTest extends BaseTest{

    @Story("Bla-bla-bla")
    @Description("Description")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "allure", type = "issue")
    @Test(description = "Check possibility to login for just created user", groups = {smoke})
    public void loginCanvaTest(){

        driver.get(PropertyHolder.getPropValue("URL_Login"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login()
                .validateThatMenuDisplayed();

    }
}
