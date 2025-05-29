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
    void GuildOrders(){
        open(baseURL.MAIN_PAGE_URL());
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[3]/a")).shouldBe(visible).click();

        $(By.xpath("//*[@id=\"root\"]/div/div/div/button[1]")).shouldBe(clickable, visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/div/button[2]")).shouldBe(clickable, visible);
        $(".border-none.text-white.focus\\:outline-none.bg-blue-900.scale-95").shouldBe(exist, visible, clickable);

        ElementsCollection elementsPages = $$(".border-none.text-white.focus\\:outline-none.bg-blue-800.hover\\:bg-blue-900");
        for(SelenideElement pages : elementsPages) {
            $$(".cursor-pointer.transiotion-filter.duration-200.ease.hover\\:brightness-75").last().shouldBe(visible);

            ElementsCollection elementsOrders = $$(".cursor-pointer.transiotion-filter.duration-200.ease.hover\\:brightness-75");
            for (SelenideElement orders : elementsOrders) {
                orders.click();
                $(".text-center.text-2xl.mb-4").should(exist, visible);
                $(".text-base.text-blue-600.font-bold").should(exist, visible);
            }
            $(By.xpath("//*[@id=\"root\"]/div/div/div/button[2]")).click();
        }
    }

}
