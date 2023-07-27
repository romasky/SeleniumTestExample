package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class mainPage extends baseSeleniumPage { //extends для того чтобы работал вебдрайвер

    private final Logger logger = LogManager.getLogger(mainPage.class);


    /* private final By queueList = By.id("id_queue"); //Обозначение самих локаторов, т.е. путь к самому элементу, а не их нахождение
     private final By queueList2 = By.xpath("//select[@id="id_queue"]");*/

    @FindBy(xpath = "//a[@href='/abtest']")  //a/b Test Page
    private WebElement abTestPage;                      //происходит инициализация данного элемента, когда мы к нему обращаемся

    @FindBy(xpath = "//a[@href='/add_remove_elements/']")  //Add/Remove Elements Page
    private WebElement addRemovePage;

    @FindBy(xpath = "//a[@href='/basic_auth']")  //Basic Auth (user and pass: admin)
    private WebElement basicAuthPage;

    @FindBy(xpath = "//a[@href='/broken_images']")  //Basic Auth (user and pass: admin)
    private WebElement brokenImages;




    @FindBy(xpath = "//a[@href='/javascript_alerts']")  //JavaScript Alerts page
    private WebElement jsAlertsPage;



    public mainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
        //PageFactory в Selenium упрощает и автоматизирует инициализацию элементов страницы
        // и обеспечивает удобное взаимодействие с ними в тестовых сценариях.
    }

    /*необходимо открыть страницу abTestPage*/
    public abTestPage openAbTestPage(){
        abTestPage.click();
        logger.info("abTestPage is open");
        return new abTestPage();
    }

    /*необходимо открыть страницу addRemovePage*/
    public addRemovePage openaddRemovePage(){
        addRemovePage.click();
        logger.info("addRemovePage is open");
        return new addRemovePage();
    }

    /*необходимо открыть страницу addRemovePage*/
    public basicAuthPage openbasicAuthPage(){
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(()->new UsernameAndPassword(ConfigProvider.USER_LOGIN,ConfigProvider.USER_PASS));
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        logger.info("basicAuthPage is open");
        return new basicAuthPage();
    }

    /*необходимо открыть страницу addRemovePage*/
    public brokenImagesPage openBrokenImagesPage(){
        brokenImages.click();
        logger.info("brokenImagesPage is open");
        return new brokenImagesPage();
    }





    //необходимо открыть страницу javaScriptAlertsPage
    public javaScriptAlertsPage openJSAlertsPage(){
        jsAlertsPage.click();
        logger.info("javaScriptAlertsPage is open");
        return new javaScriptAlertsPage();
    }


}
