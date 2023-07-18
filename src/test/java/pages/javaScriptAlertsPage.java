package pages;

import core.baseSeleniumPage;
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

    private Logger logger = LogManager.getLogger(javaScriptAlertsPage.class);

    public Alert alert;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement jsAlertButton;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement jsConfirmAlertButton;

    @FindBy(xpath = "//p[@id]")
    private WebElement jsAlertText;






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
        }
    }

    public String getAlertText() {   // Получаем текст из алерта
        alertHandler(driver);
        return alert.getText();
    }

    public void acceptAlert() {   // Принимаем алерт
        alert.accept();
    }

    public void dismissAlert() {  // Отклоняем алерт
        alert.dismiss();
    }

    public void sendKeysToAlert(String text) {   // Вводим текст в поле ввода алерта
        alert.sendKeys(text);
    }

    public void closeAlert() {  // Закрываем алерт и возвращаемся к основному окну
        alert.accept();
        driver.switchTo().defaultContent();
    }



//создадим методы, которые будут открывать simple, confirm, prompt alerts

    //Simple Alert
    public void openSimpleAlertCheck() {
        jsAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        logger.info("Simple Alert is open");
        alertHandler(driver);
    }

    public void openSimpleAlertAndMakeSomeAction() {
        jsAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alertHandler(driver);
        logger.info("Simple Alert is open");
    }

    public String checkTextSimpleAlertCompare() {
        jsAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alertHandler(driver);
        logger.info("Simple Alert is open");
        acceptAlert();
        driver.switchTo().defaultContent();
        return jsAlertText.getText();
    }

    public void openSimpleAlertAndCloseIt() {
        jsAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alertHandler(driver);
        logger.info("Simple Alert is open");
        closeAlert();
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        alert = null;
        logger.info("Simple Alert is closed");
    }


    //Confirm Alert

    public void openConfirmAlertCheck() {
        jsConfirmAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alertHandler(driver);
        logger.info("Confirm Alert is open");
    }






    //Prompt Alert


    public void openPromptAlert() {

    }


}
