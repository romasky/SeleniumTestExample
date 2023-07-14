package pages;

import core.baseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class mainPage extends baseSeleniumPage { //extends для того чтобы работал вебдрайвер

    /* private final By queueList = By.id("id_queue"); //Обозначение самих локаторов, т.е. путь к самому элементу, а не их нахождение
     private final By queueList2 = By.xpath("//select[@id="id_queue"]");*/

    @FindBy(xpath = "//a[@href='/javascript_alerts']")  //JavaScript Alerts
    private WebElement jsAlertsPage;                      //происходит инициализация данного элемента, когда мы к нему обращаемся



    public mainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
        //PageFactory в Selenium упрощает и автоматизирует инициализацию элементов страницы
        // и обеспечивает удобное взаимодействие с ними в тестовых сценариях.
    }



    //необходимо открыть страницу javaScriptAlertsTest
    public javaScriptAlertsPage openJSAlertsPage(){
        jsAlertsPage.click();
        return new javaScriptAlertsPage();
    }
}
