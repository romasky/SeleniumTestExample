package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


abstract public class baseSeleniumTest {
    protected WebDriver driver;
    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //отвечает за процесс взаимодействия с самим браузером, а хром это сам браузер
        driver.manage().window().maximize(); //Запуск драйвера на весь экран
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //неявное ожидание, для загрузки веб-страницы
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //неявное ожидание
        baseSeleniumPage.setDriver(driver);
    }


    @AfterEach
    public void tearDown() {
        driver.close(); //закрываем именно ChromeDriver
        driver.quit(); //закрываем именно браузер
    }

}
