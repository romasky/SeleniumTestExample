package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.javaScriptAlertsPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


abstract public class baseSeleniumTest {
    protected WebDriver driver;
    private final Logger logger = LogManager.getLogger(baseSeleniumTest.class);
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(); //отвечает за процесс взаимодействия с самим браузером, а хром это сам браузер
        driver.manage().window().maximize(); //Запуск драйвера на весь экран
/*        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //неявное ожидание, для загрузки веб-страницы
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //неявное ожидание*/

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        baseSeleniumPage.setDriver(driver);
        logger.info("Driver is initialized");
    }


    @AfterEach
    public void tearDown() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            // Алерт не найден, продолжаем
        }
        driver.close(); //закрываем именно ChromeDriver
        driver.quit(); //закрываем именно браузер
        logger.info("Driver is closed and quit");
    }

}
