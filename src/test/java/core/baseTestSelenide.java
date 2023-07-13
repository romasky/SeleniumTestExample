package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class baseTestSelenide {

    /**
     * Selenide init
     */
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    /**
     * Execute method before test start
     */

    @BeforeEach
    public void init() {
        setUp();
    }

    /**
     * Execute method after close each test
     */

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }




}
