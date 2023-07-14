package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
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


    public javaScriptAlertsPage() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void alertHandler(WebDriver driver) {
        // Переключаемся на алерт
        this.alert = driver.switchTo().alert();
    }

    public String getAlertText() {
        // Получаем текст из алерта
        alertHandler(driver);
        return alert.getText();
    }

    public void acceptAlert() {
        // Принимаем алерт
        alertHandler(driver);
        alert.accept();
    }

    public void dismissAlert() {
        // Отклоняем алерт
        alertHandler(driver);
        alert.dismiss();
    }

    public void sendKeysToAlert(String text) {
        // Вводим текст в поле ввода алерта
        alertHandler(driver);
        alert.sendKeys(text);
    }

    public void closeAlert() {
        // Закрываем алерт и возвращаемся к основному окну
        alertHandler(driver);
        alert.accept();
        driver.switchTo().defaultContent();
    }



//создадим методы, которые будут открывать simple, confirm, prompt alerts

    public void openSimpleAlertCheck() {
        jsAlertButton.click();
        logger.info("Page opened successfully");
        wait.until(ExpectedConditions.alertIsPresent());
        alertHandler(driver);
    }



    public javaScriptAlertsPage openSimpleAlertAndMakeSomeAction() {
        jsAlertButton.click();
        logger.info("Page opened successfully");
        wait.until(ExpectedConditions.alertIsPresent());
        alertHandler(driver);
        return new javaScriptAlertsPage();
    }

    public void openConfirmAlert() {

    }


    public void openPromptAlert() {

    }


}
