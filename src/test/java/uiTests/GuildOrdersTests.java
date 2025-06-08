package uiTests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GuildOrdersTests {
    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);
    @Test
    void guildOrders(){
        open(baseURL.MAIN_PAGE_URL());
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[3]/a")).shouldBe(visible).click();//Открытие страницы с гильдиями
        //проверка погинации
        $(By.xpath("//*[@id=\"root\"]/div/div/div/button[1]")).shouldBe(clickable, visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/div/button[2]")).shouldBe(clickable, visible);
        $(".border-none.text-white.focus\\:outline-none.bg-blue-900.scale-95").shouldBe(exist, visible, clickable);
        //Проверка каждого заказа
        ElementsCollection elementsPages = $$(".border-none.text-white.focus\\:outline-none.bg-blue-800.hover\\:bg-blue-900");
        for(SelenideElement pages : elementsPages) {
            $$(By.xpath("//*[@id=\"root\"]/div/div/div/button[4]")).last().shouldBe(visible);
            ElementsCollection elementsOrders = $$("._orderImage_1vllh_19");
            for (SelenideElement orders : elementsOrders) {
                orders.click();
                $("._orderTitle_7yqle_18").should(exist, visible);
                $("._orderContent_7yqle_25").should(exist, visible);
                $("._orderAuthor_7yqle_29").should(exist, visible);
            }
            $(".bg-blue-800.border-none.text-white.hover\\:bg-blue-900.focus\\:outline-none").click();
        }

    }

}
