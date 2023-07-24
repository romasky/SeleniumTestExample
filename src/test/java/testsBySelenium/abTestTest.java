package testsBySelenium;

import core.baseSeleniumTest;
import helpers.assertions;
import helpers.testValues;
import org.junit.jupiter.api.Test;
import pages.abTestPage;
import pages.javaScriptAlertsPage;
import pages.mainPage;

public class abTestTest  extends baseSeleniumTest {



        /*Check title text*/

        @Test
        public void testPositiveAbCheckTitleText() {
            abTestPage abTestPage = new mainPage()
                    .openAbTestPage();

            assertions.textCompare(testValues.AB_TITLE, testValues.AB_TITLE_2,abTestPage.getTitleText());
        }


    /*Check body text*/

    @Test
    public void testPositiveAbCheckBodyText() {
        abTestPage abTestPage = new mainPage()
                .openAbTestPage();

        assertions.textCompare(testValues.AB_DESCRIPTION, abTestPage.getBodyText());
    }





}


