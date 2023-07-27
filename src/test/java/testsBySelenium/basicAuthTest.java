package testsBySelenium;

import core.baseSeleniumTest;
import helpers.assertions;
import helpers.testValues;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import pages.basicAuthPage;
import pages.mainPage;

import java.time.Duration;

public class basicAuthTest extends baseSeleniumTest {


    /*Open Alerts*/

    @Test
    public void testPositiveSuccessfullyloginViaAlert() {
        basicAuthPage basicAuthPage = new mainPage()
                .openbasicAuthPage();

        assertions.textCompare(testValues.BAT_TITLE_TEXT, basicAuthPage.getTextFromPage("titleAuthText"));
        assertions.textCompare(testValues.BAT_BODY_TEXT, basicAuthPage.getTextFromPage("bodyAuthText"));
    }
}
