package testsBySelenium;

import core.baseSeleniumTest;
import helpers.assertions;
import helpers.testValues;
import org.junit.jupiter.api.Test;
import pages.abTestPage;
import pages.brokenImagesPage;
import pages.mainPage;

import java.io.IOException;

public class brokenImagesTest  extends baseSeleniumTest {



    @Test
    public void testPositiveAbCheckTitleText() throws IOException {
        brokenImagesPage brokenImagesPage = new mainPage()
                .openBrokenImagesPage();

        assertions.checkImageLinks(brokenImagesPage.getImagesLinks());
    }


}
