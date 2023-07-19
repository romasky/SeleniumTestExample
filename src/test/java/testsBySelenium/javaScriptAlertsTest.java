package testsBySelenium;

import core.baseSeleniumTest;
import helpers.assertions;
import helpers.testValues;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.javaScriptAlertsPage;
import pages.mainPage;

public class javaScriptAlertsTest extends baseSeleniumTest {


    /*Open Alerts*/

    @ParameterizedTest
    @ValueSource(strings = {"simple", "confirm", "prompt"})
    public void testPositiveAlertOpen(String condition) {

        if(condition.equals("simple")) {
            javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                    .openJSAlertsPage();
            javaScriptAlertsPage.openAlert("simple");

            assertions.checkAlertAppears(javaScriptAlertsPage);
        } else if(condition.equals("confirm")) {
            javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                    .openJSAlertsPage();
            javaScriptAlertsPage.openAlert("confirm");

            assertions.checkAlertAppears(javaScriptAlertsPage);
        }
        else if(condition.equals("prompt")) {
            javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                    .openJSAlertsPage();
            javaScriptAlertsPage.openAlert("prompt");

            assertions.checkAlertAppears(javaScriptAlertsPage);
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    /*Check Alerts Text*/

    @ParameterizedTest
    @ValueSource(strings = {"simple", "confirm", "prompt"})
    public void testPositiveAlertCheckText(String condition) {

        if(condition.equals("simple")) {
            javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                    .openJSAlertsPage();
            javaScriptAlertsPage.checkAlertsText("simple");

            assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT,javaScriptAlertsPage.getAlertText());
        } else if(condition.equals("confirm")) {
            javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                    .openJSAlertsPage();
            javaScriptAlertsPage.checkAlertsText("confirm");

            assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT_CONFIRM,javaScriptAlertsPage.getAlertText());
        }
        else if(condition.equals("prompt")) {
            javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                    .openJSAlertsPage();
            javaScriptAlertsPage.checkAlertsText("prompt");

            assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT_PROMPT,javaScriptAlertsPage.getAlertText());
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }








    @Test void CheckSimpleAlertTextAfterSuccessfullyClosed() { //Проверяем, что текст совпадает после закрытия алерта
        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();
        assertions.textCompare(testValues.ALERT_TEXT_JSALERT_TEXT,javaScriptAlertsPage.checkTextSimpleAlertCompare());
    }

    @Test
    public void openSimpleAlertAndCloseIt() {   //Проверяем, что алерт открылся, отобразился и закрылся

        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();
        javaScriptAlertsPage.openSimpleAlertAndCloseIt();

        assertions.checkAlertClosed(javaScriptAlertsPage);
    }














}
