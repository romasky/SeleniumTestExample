package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class alertHelpers {

    private final Logger logger = LogManager.getLogger(alertHelpers.class);

    public static Alert alert;

    public static void alertHandler(WebDriver driver) {  // Переключаемся на алерт

        try {
            alert = driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            // Обработка случая, когда алерт отсутствует
            alert = null;
            System.out.println("Alert is null");
        }
    }

    public static void acceptAlert(WebDriver driver) {   // Принимаем алерт
        alert.accept();
        driver.switchTo().defaultContent();
    }

    public static void dismissAlert(WebDriver driver) {  // Отклоняем алерт
        alert.dismiss();
        driver.switchTo().defaultContent();
    }

    public static String getAlertText(WebDriver driver) {   // Получаем текст из алерта
        alertHandler(driver);
        return alert.getText();}

    public static void sendKeysToAlert(String text) {   // Вводим текст в поле ввода алерта
        alert.sendKeys(text);
    }

}
