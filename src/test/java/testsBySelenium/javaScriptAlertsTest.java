package testsBySelenium;

import core.baseSeleniumTest;
import helpers.alertHelpers;
import helpers.assertions;
import helpers.testValues;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.javaScriptAlertsPage;
import pages.mainPage;

public class javaScriptAlertsTest extends baseSeleniumTest {

    /*Open Alerts*/
    @Description("This test successfully checks opening an alerts")
    @Epic("Positive test")
    @DisplayName("Test positive opening an alerts")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest
    @ValueSource(strings = {"simple", "confirm", "prompt"})
    public void testPositiveAlertOpen(String condition) {
        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();

        if(condition.equals("simple")) {

            javaScriptAlertsPage.openAlert("simple");
            assertions.checkAlertAppears(javaScriptAlertsPage);
        } else if(condition.equals("confirm")) {

            javaScriptAlertsPage.openAlert("confirm");
            assertions.checkAlertAppears(javaScriptAlertsPage);
        }
        else if(condition.equals("prompt")) {

            javaScriptAlertsPage.openAlert("prompt");
            assertions.checkAlertAppears(javaScriptAlertsPage);
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    /*Check Alerts Text*/
    @Description("This test successfully checks text on the alerts")
    @Epic("Positive test")
    @DisplayName("Test positive text on alerts")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest
    @ValueSource(strings = {"simple", "confirm", "prompt"})
    public void testPositiveAlertCheckText(String condition) {
        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();

        if(condition.equals("simple")) {

            javaScriptAlertsPage.checkAlertsText("simple");
            assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT, alertHelpers.getAlertText(driver));
        } else if(condition.equals("confirm")) {

            javaScriptAlertsPage.checkAlertsText("confirm");
            assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT_CONFIRM,alertHelpers.getAlertText(driver));
        }
        else if(condition.equals("prompt")) {

            javaScriptAlertsPage.checkAlertsText("prompt");
            assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT_PROMPT,alertHelpers.getAlertText(driver));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    /*Check Alerts Text Result*/
    @Description("This test successfully checks text onthe page Result")
    @Epic("Positive test")
    @DisplayName("Test positive text Result")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest
    @ValueSource(strings = {"simpleok", "confirmok", "confirmcancel","promptok", "promptcancel"})
    public void testPositiveAlertCheckTextResult(String condition) {

        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();

        if(condition.equals("simpleok")) {

            assertions.textCompare(testValues.JSALERT_OK_TEXT_RESULT,javaScriptAlertsPage.checkAlertsTextResult(condition));
        } else if(condition.equals("confirmok")) {

            assertions.textCompare(testValues.JSALERT_CONFIRM_OK_TEXT_RESULT,javaScriptAlertsPage.checkAlertsTextResult(condition));
        }
        else if(condition.equals("confirmcancel")) {

            assertions.textCompare(testValues.JSALERT_CONFIRM_CANCEL_TEXT_RESULT,javaScriptAlertsPage.checkAlertsTextResult(condition));
        }
        else if(condition.equals("promptok")) {

            assertions.textCompare(testValues.JSALERT_PROMPT_TEXT_RESULT_START+testValues.JSALERT_PROMPT_TEXT_RESULT_ENTER,javaScriptAlertsPage.checkAlertsTextResult(condition));

        }
        else if(condition.equals("promptcancel")) {

            assertions.textCompare(testValues.JSALERT_PROMPT_TEXT_RESULT_START+testValues.JSALERT_PROMPT_TEXT_RESULT_NOENTER,javaScriptAlertsPage.checkAlertsTextResult(condition));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
        assertions.checkAlertClosed(javaScriptAlertsPage);
    }
}
