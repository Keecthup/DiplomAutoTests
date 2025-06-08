package uiTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class NewsPageTests {
    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);

    @Test
    void latestNews(){
        open(baseURL.MAIN_PAGE_URL());
        //Открытие страницы новостей
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[2]/a")).shouldBe(visible).click();
        //Просмотр последней новости(первая в списке)
        $(By.className("_articlePreview_f10f5_38")).shouldBe(visible).hover();
        $(By.className("_article_f10f5_1")).shouldBe(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/main/div/img[2]")).should(visible);
        $(By.xpath("//*[@id=\"root\"]/div/main/p")).should(visible);
        $(By.xpath("//*[@id=\"root\"]/div/main/header/div/h1")).should(visible);
        $(By.xpath("//*[@id=\"root\"]/div/main/header/p")).shouldBe(visible);
       //Закрытие
        $(".ml-4").should(visible).click();
    }
    @Test
    void allPages(){
        open(baseURL.MAIN_PAGE_URL());
        //Открытие страницы новостей
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[2]/a")).shouldBe(visible).click();
        //проверка пагинации
        ElementsCollection elementsPages = $$(".border-none.text-white.focus\\:outline-none.bg-blue-800.hover\\:bg-blue-900");
        for(SelenideElement pages : elementsPages) {
            $$("._article_6p680_1").last().shouldBe(visible);
        }
    }
}
