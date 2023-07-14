package testsBySelenium;

import core.baseSeleniumTest;
import helpers.assertions;
import helpers.testValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.javaScriptAlertsPage;
import pages.mainPage;

public class javaScriptAlertsTest extends baseSeleniumTest {


    @Test
    public void openSimpleAlert() {

        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();
        javaScriptAlertsPage.openSimpleAlertCheck();

        assertions.checkAlertAppears(javaScriptAlertsPage);
    }

    @Test
    public void openSimpleAlertAndCheckText() {

        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage()
                .openSimpleAlertAndMakeSomeAction();

        assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT,javaScriptAlertsPage.getAlertText());
    }




}
