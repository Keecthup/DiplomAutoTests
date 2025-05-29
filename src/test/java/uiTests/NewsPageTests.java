package uiTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class NewsPageTests {
    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);

    @Test
    void LatestNews(){
        open(baseURL.MAIN_PAGE_URL());
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[2]/a")).shouldBe(visible).click();

        $(By.className("_article_6p680_1")).shouldBe(visible).hover();
        $(By.className("_article_6p680_1")).shouldBe(visible).click();
        $(".z-10.relative.rounded-2xl.max-h-\\[500px\\].mx-auto.my-6").should(visible);
        $(".text-4xl.break-all.mb-3").should(visible);
        $(".text-blue-500.mb-2").should(visible);

        $(".ml-4").should(visible).click();
    }
    @Test
    void AllPages(){
        open(baseURL.MAIN_PAGE_URL());
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[2]/a")).shouldBe(visible).click();

        ElementsCollection elementsPages = $$(".border-none.text-white.focus\\:outline-none.bg-blue-800.hover\\:bg-blue-900");
        for(SelenideElement pages : elementsPages) {
            $$("._article_6p680_1").last().shouldBe(visible);
        }
    }

}
