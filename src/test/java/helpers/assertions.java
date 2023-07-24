package helpers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import pages.javaScriptAlertsPage;

public class assertions {

    private static final Logger logger = LogManager.getLogger(assertions.class);

    public static void checkAlertAppears(javaScriptAlertsPage javaScriptAlertsPage) {
        Assertions.assertNotNull(javaScriptAlertsPage.alert, "Failed to open the alert");
        logger.info("Alert is appears");
    }

    public static void checkAlertText(String expectedValue, String actualValue) {
        Assertions.assertEquals(expectedValue, actualValue, "Alert text is not equal to expectedValue " + expectedValue);
        logger.info("Text is equals on Alerts popup");
    }
    public static void checkAlertClosed(javaScriptAlertsPage javaScriptAlertsPage) {
        Assertions.assertNull(javaScriptAlertsPage.alert, "Failed to close the alert");
        logger.info("Alert has been closed");
    }

    public static void textCompare(String expectedValue, String actualValue) {
        Assertions.assertEquals(expectedValue, actualValue,"Text value is not equal to expectedValue " + expectedValue);
        logger.info("Text is equals");
    }
    public static void textCompare(String expectedValue1, String expectedValue2, String actualValue) {
        if (actualValue.equals(expectedValue1) || actualValue.equals(expectedValue2)) {
            logger.info("Text is equals");
        } else {
            Assertions.fail("Text value is not equal to expectedValue " + expectedValue1 + " or " + expectedValue2);
        }
    }
}
