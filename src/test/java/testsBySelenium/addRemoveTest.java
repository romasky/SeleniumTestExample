package testsBySelenium;

import core.baseSeleniumTest;
import helpers.assertions;
import org.junit.jupiter.api.Test;
import pages.addRemovePage;
import pages.mainPage;

public class addRemoveTest extends baseSeleniumTest {


    /*Check Button "Detele" appears N times*/
    @Test
    public void testPositiveCheckDeleteButtonAppears() {
        addRemovePage addRemovePage = new mainPage()
                .addRemovePage();
        addRemovePage.clickAddElementButton();

        assertions.deleteButtonAppearsNTimes(addRemovePage);
    }


    /*Check Button "Detele" appears and clicks N times*/

    @Test
    public void testPositiveCheckDeleteButtonsDisappear() {
        addRemovePage addRemovePage = new mainPage()
                .addRemovePage();
        addRemovePage.deleteButtonAppears();

        assertions.zeroListSize(addRemovePage);
    }





}
