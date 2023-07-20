package pages;

import core.baseSeleniumPage;
import helpers.testValues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class javaScriptAlertsPage extends baseSeleniumPage {

    private final Logger logger = LogManager.getLogger(javaScriptAlertsPage.class);

    public Alert alert;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement jsAlertButton;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement jsConfirmAlertButton;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    private WebElement jsPromptAlertButton;

    @FindBy(xpath = "//p[@id]")
    private WebElement jsAlertResultText;


    public javaScriptAlertsPage() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void alertHandler(WebDriver driver) {  // Переключаемся на алерт

        try {
            this.alert = driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            // Обработка случая, когда алерт отсутствует
            this.alert = null;
            System.out.println("Alert is null");
        }
    }

    public String getAlertText() {   // Получаем текст из алерта
        alertHandler(driver);
        return alert.getText();
    }

    public void acceptAlert() {   // Принимаем алерт
        alert.accept();
        driver.switchTo().defaultContent();
    }

    public void dismissAlert() {  // Отклоняем алерт
        alert.dismiss();
        driver.switchTo().defaultContent();
    }

    public void sendKeysToAlert(String text) {   // Вводим текст в поле ввода алерта
        alert.sendKeys(text);
    }


/*Создадим методы, которые будут открывать simple, confirm, prompt alerts*/

    /*Open Alerts*/

    public void openAlert(String type) {
        switch (type.toLowerCase()) {
            case "simple":
                jsAlertButton.click();
                break;
            case "confirm":
                jsConfirmAlertButton.click();
                break;
            case "prompt":
                jsPromptAlertButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid alert type: " + type);
        }

        wait.until(ExpectedConditions.alertIsPresent());
        alertHandler(driver);
        logger.info("Alert " +type+ " is open");
    }

    /*Check Alerts Text*/

    public void checkAlertsText(String type) {
        switch (type.toLowerCase()) {
            case "simple":
                jsAlertButton.click();
                break;
            case "confirm":
                jsConfirmAlertButton.click();
                break;
            case "prompt":
                jsPromptAlertButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid alert type: " + type);

        }

        wait.until(ExpectedConditions.alertIsPresent());
        alertHandler(driver);
        logger.info("Alert " +type+ " is open");
    }

    /*Check Alerts Text Result*/

    public String checkAlertsTextResult(String type) {
        switch (type.toLowerCase()) {
            case "simpleok":
                jsAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Simple Alert is open");
                alertHandler(driver);
                acceptAlert();
                break;
            case "confirmok":
                jsConfirmAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Confirm Alert is open");
                alertHandler(driver);
                acceptAlert();
                break;
            case "confirmcancel":
                jsConfirmAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Confirm Alert is open");
                alertHandler(driver);
                dismissAlert();
                break;
            case "promptok":
                jsPromptAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Confirm Alert is open");
                alertHandler(driver);
                sendKeysToAlert(testValues.JSALERT_PROMPT_TEXT_RESULT_ENTER);
                acceptAlert();
                break;
            case "promptcancel":
                jsPromptAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Confirm Alert is open");
                alertHandler(driver);
                dismissAlert();
                break;
            default:
                throw new IllegalArgumentException("Invalid alert type: " + type);
        }
        alert = null;
        return jsAlertResultText.getText();
    }
}
