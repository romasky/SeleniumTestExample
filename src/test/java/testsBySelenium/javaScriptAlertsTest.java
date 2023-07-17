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
    public void openSimpleAlert() {   //Проверяем, что алерт открылся и отобразился

        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();
        javaScriptAlertsPage.openSimpleAlertCheck();

        assertions.checkAlertAppears(javaScriptAlertsPage);
    }

    @Test
    public void openSimpleAlertAndCheckText() { //Проверяем, что алерт открылся и отобразился необходимый текст

        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage()
                .openSimpleAlertAndMakeSomeAction();

        assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT,javaScriptAlertsPage.getAlertText());
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
