package listener;




import drivers.Drivers;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static org.openqa.selenium.logging.LogType.BROWSER;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureReportListener implements IHookable {


    /**
     * Attach screenshot to Allure report
     */
    @Attachment(value = "Screenshot on failure", type = "image/png")
    private static byte[] takeScreenShot() throws IOException {
        return com.google.common.io.Files.toByteArray(
                ((TakesScreenshot)  Drivers.get(Drivers.DEFAULT_DRIVER_NAME)).getScreenshotAs(OutputType.FILE));
    }


    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {

        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            try {
                takeScreenShot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
