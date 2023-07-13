package readProperties;

import core.baseTestSelenide;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PropertiesTest extends baseTestSelenide {


    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String urlFromProperty = System.getProperty("url");
        System.out.println(urlFromProperty);
    }

    @Test
    public void readFromConf() {
        String urlFromConf = ConfigProvider.URL;
        System.out.println(urlFromConf);
        String isLogin = ConfigProvider.readConfig().getString("usersParams.user.login");
        System.out.println(isLogin);
        String isLPass = ConfigProvider.readConfig().getString("usersParams.user.password");
        System.out.println(isLPass);
    }


}
