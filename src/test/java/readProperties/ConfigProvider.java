package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String USER_LOGIN = readConfig().getString("usersParams.user.login");
    String USER_PASS = readConfig().getString("usersParams.user.password");

}
