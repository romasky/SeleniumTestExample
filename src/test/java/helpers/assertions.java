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
    public static void checkAlertClosed(javaScriptAlertsPage javaScriptAlertsPage) {
        Assertions.assertNull(javaScriptAlertsPage.alert, "Failed to close the alert");
    }

    public static void textCompare(String expectedValue, String actualValue) {
        Assertions.assertEquals(expectedValue, actualValue,"Text value is not equal to expectedValue " + expectedValue);

    }

}
