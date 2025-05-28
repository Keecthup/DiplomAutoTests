package uiTests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenSiteTest {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/111/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://kptc-smp.ru/");
        driver.manage().window().maximize();
        driver.quit();
        }

    }


