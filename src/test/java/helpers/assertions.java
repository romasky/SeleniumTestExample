package helpers;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import pages.javaScriptAlertsPage;

public class assertions {

    public static void checkAlertAppears(javaScriptAlertsPage javaScriptAlertsPage) {
        Assertions.assertNotNull(javaScriptAlertsPage.alert, "Failed to open the alert");

    }

    public static void checkAlertText(String expectedValue, String actualValue) {
        Assertions.assertEquals(expectedValue, actualValue, "Alert text is not equal to expectedValue " + expectedValue);

    }
}
