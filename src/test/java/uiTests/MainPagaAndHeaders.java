package uiTests;

import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPagaAndHeaders {
    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);
    @Test
    void mainPage(){
        open(baseURL.MAIN_PAGE_URL());
        //Текст и картинки
        $(By.xpath("//*[@id=\"root\"]/main/div/section[1]/div[1]/img")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[1]/div[2]/img")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[1]/div[4]/img")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[1]/div[5]/img")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[1]/div[3]/div[1]/h1")).shouldBe(visible);
        //Кнопка "Начать игру"
        $(By.xpath("//*[@id=\"root\"]/main/div/section[1]/div[3]/div[2]/button")).shouldBe(visible).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[1]/a")).shouldBe(visible).click();
        //Текст и картинки
        $(By.xpath("//*[@id=\"root\"]/main/div/section[2]/div[1]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[2]/div[2]/div[2]/code")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[2]/div[2]")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[3]/div")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[3]/img")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[4]/img")).shouldBe(visible);
        $(By.xpath("//*[@id=\"root\"]/main/div/section[4]/div")).shouldBe(visible);
    }
    @Test
    void headers(){
        open(baseURL.MAIN_PAGE_URL());
        $(By.xpath("//*[@id=\"root\"]/header/div/a")).shouldBe(visible, clickable);
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/div")).shouldBe(exist); //существует, но не отображается на широких
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[1]/a")).shouldBe(visible,clickable);
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[2]/a")).shouldBe(visible,clickable);
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[3]/a")).shouldBe(visible,clickable);
        $(By.xpath("//*[@id=\"root\"]/header/div/nav/ul/li[4]/a")).shouldBe(visible,clickable);
        boolean isntLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).exists();
        if(isntLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).shouldBe(visible).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[1]")).shouldBe(visible, clickable);
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible,clickable);
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/button")).shouldBe(visible).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible,clickable);
    }
}
