package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class abTestPage extends baseSeleniumPage {
    private final Logger logger = LogManager.getLogger(javaScriptAlertsPage.class);

    public Alert alert;

    @FindBy(xpath = "//h3")
    private WebElement abPageTitleText;

    @FindBy(xpath = "//p")
    private WebElement abPageTextBody;


    public abTestPage() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    /*Создадим методы, которые будут получать текст */

    public String getTitleText() {
        return abPageTitleText.getText();
    }

    public String getBodyText() {
        return abPageTextBody.getText();
    }

}
