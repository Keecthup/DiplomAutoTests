package uiTests;

import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HowToPlayTests {
    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);
    @Test
    void howToPlayPage(){
        open(baseURL.MAIN_PAGE_URL());
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[4]/a")).click();//открытие страницы
        //Заголовки
        $(By.xpath("//*[@id=\"root\"]/div/div/div[1]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[1]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[2]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[3]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[4]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[5]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[6]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[7]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[8]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[9]")).shouldBe(visible);
        //Проверка гипперссылок на сборки
        $(By.xpath("//*[@id=\"root\"]/div/div/article[4]/main/ul[2]/li[1]/a")).shouldBe(visible,clickable);
        $(By.xpath("//*[@id=\"root\"]/div/div/article[4]/main/ul[2]/li[2]/a")).shouldBe(visible,clickable);
        //текст в подвале
        $(By.xpath("//*[@id=\"root\"]/div/div/div[2]")).shouldBe(visible);

    }
}
