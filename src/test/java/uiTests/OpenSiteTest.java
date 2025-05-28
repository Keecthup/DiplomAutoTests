package uiTests;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OpenSiteTest {
    @Test
    public void test(){
            open ();
            $(By.className(".relative.z-20.text-base.text-nowrap"));
        }

    }


