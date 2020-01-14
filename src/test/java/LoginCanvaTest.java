import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import properties.PropertyHolder;
import web.pages.LoginPage;

import static utils.Groups.smoke;

@Feature("Login")
@Story("Positive way of Login")
public class LoginCanvaTest extends BaseTest{

    @Test(description = "Check possibility to login for just created user", groups = {smoke})
    public void loginCanvaTest(){

        driver.get(PropertyHolder.getPropValue("URL_Login"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login()
                .validateThatMenuDisplayed();

    }
}
