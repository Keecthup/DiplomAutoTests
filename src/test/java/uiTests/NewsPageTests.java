package uiTests;

import com.codeborne.selenide.Condition;
import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class NewsPageTests {
    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);

    @Test
    void LatestNews(){
        System.setProperty("selenide.baseUrl", baseURL.MAIN_PAGE_URL());
        open("news?page=1");
        $(By.className("_article_6p680_1")).should(clickable).click();
        $(".z-10.relative.rounded-2xl.max-h-\\[500px\\].mx-auto.my-6").should(exist);
        $(".text-4xl.break-all.mb-3").should(exist);
        $(".text-blue-500.mb-2").should(exist);
        $(".ml-4").should(clickable).click();
    }
    @Test
    void Pages(){
        System.setProperty("selenide.baseUrl", baseURL.MAIN_PAGE_URL());
        open("news?page=1");
        $$(".bg-blue-800.border-none.text-white.hover\\:bg-blue-900.focus\\:outline-none").find(exactText("〉")).click();
    }

}
