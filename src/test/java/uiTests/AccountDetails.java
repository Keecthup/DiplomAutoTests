package uiTests;

import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AccountDetails {
    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);
    @Test
    void accountDetailsPage(){
        open(baseURL.MAIN_PAGE_URL());
        //Авторизация
        $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Открытие страницы с деталями аккаунта
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[1]")).click();
        //Название страницы
        $(By.xpath("//*[@id=\"root\"]/div/main/h2")).shouldBe(visible);
        //Навигация между обзор и редактированием
        $(By.xpath("//*[@id=\"root\"]/div/main/section/nav/ul/li[1]")).shouldBe(visible,clickable);
        $(By.xpath("//*[@id=\"root\"]/div/main/section/nav/ul/li[2]")).shouldBe(visible,clickable);
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[1]/div/a")).shouldBe(visible,clickable);
        //Проверка коректности данных
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[1]/p")).shouldBe(visible).shouldHave(exactText(baseURL.LOGIN_USER()));
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[2]/p")).shouldBe(visible).shouldHave(exactText("11.05.2025"));
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[3]/p")).shouldBe(visible).shouldHave(exactText(baseURL.MAIL_USER()));
    }
}
