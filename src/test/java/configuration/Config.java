package configuration;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config {
    public static String
            baseUrl = "https://demoqa.com",
            resourceSrc = "src/test/resources/",
            browserSize = "1920x1080";

    public static ChromeOptions browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

    public static void setConfiguration () {
        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
        Configuration.browserCapabilities = browserCapabilities;
    }

}
