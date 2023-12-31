package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//В этом классе мы присвоили вебдрайвер, который инициализируется в тестовом классе
abstract public class baseSeleniumPage {

    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}


/** Все страницы на сайте будем разбивать по классам, реализуя Паттерн Page Object - это популярный паттерн проектирования
 * в автоматизации тестирования веб-приложений.
 * Он предлагает организацию автоматизированных тестов на основе объектно-ориентированного подхода.

 * Суть паттерна Page Object заключается в том, что каждая страница веб-приложения представляется в виде отдельного объекта (Page Object).
 * Этот объект инкапсулирует логику и элементы, присутствующие на странице.
 * Он предоставляет удобные методы для взаимодействия с элементами страницы, выполнения операций и проверки состояния страницы.
 */
