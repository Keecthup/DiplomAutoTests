package uiTests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GuildOrdersTests {
    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);
    @Test
    void GuildOrders(){
        System.setProperty("selenide.baseUrl", baseURL.MAIN_PAGE_URL());
        open("guild?page=1");
        //$(".bg-\\[#111111\\].mb-4.rounded-lg.px-6.py-2").shouldHave(exactText("Еженедельные задания"));
        ElementsCollection elements = $$(".cursor-pointer.transiotion-filter.duration-200.ease.hover\\:brightness-75");
        for (SelenideElement el : elements){
            el.shouldBe(clickable, visible).click();
            $(".text-center.text-2xl.mb-4").should(exist,visible);
            $("text-base.text-blue-600.font-bold").should(exist, visible);
        }
        $$(".bg-blue-800.border-none.text-white.hover\\:bg-blue-900.focus\\:outline-none").find(exactText("〉")).shouldBe(clickable, visible);
        $$(".bg-blue-800.border-none.text-white.hover\\:bg-blue-900.focus\\:outline-none").find(exactText("〈")).shouldBe(clickable, visible);
        $(".border-none.text-white.focus\\:outline-none.bg-blue-900.scale-95").shouldBe(exist, visible).shouldHave(exactText("1"));

    }

}
