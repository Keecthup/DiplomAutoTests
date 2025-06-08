package uiTests;

import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ChangeProfileInformation {

    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);
    @Test
    void changePFPJPG(){
        open(baseURL.MAIN_PAGE_URL());
        //Авторизация пользователя
        boolean isntLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).exists();
        if(isntLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }
        //Открытие страницы для редактирования информации
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible).click();
        //Добаваление аватарки
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[4]/p/button")).should(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/input")).uploadFile(new File(baseURL.JPGPATH()));
        $(".rounded-full").should(exist);
        //Закрытие окна
        $(By.xpath("/html/body/div[2]/section/main/form/button")).should(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/header/a")).click();
    }

    @Test
    void changePFPPNG(){
        open(baseURL.MAIN_PAGE_URL());
        //Авторизация пользователя
        boolean isntLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).exists();
        if(isntLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }
        //Открытие страницы для редактирования информации
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible).click();
        //Добаваление аватарки
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[4]/p/button")).should(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/input")).uploadFile(new File(baseURL.PNGPATH()));
        $(".rounded-full").should(exist);
        //Закрытие окна
        $(By.xpath("/html/body/div[2]/section/main/form/button")).should(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/header/a")).click();

    }

    @Test
    void changePFPJPEG(){
        open(baseURL.MAIN_PAGE_URL());
        //Авторизация пользователя
        boolean isntLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).exists();
        if(isntLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }
        //Открытие страницы для редактирования информации
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible).click();
        //Добаваление аватарки
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[4]/p/button")).should(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/input")).uploadFile(new File(baseURL.JPEGPATH()));
        $(".rounded-full").should(exist);
        //Закрытие окна
        $(By.xpath("/html/body/div[2]/section/main/form/button")).should(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/header/a")).click();

    }

    @Test
    void changePFPSVG(){
        open(baseURL.MAIN_PAGE_URL());
        //Авторизация пользователя
        boolean isntLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).exists();
        if(isntLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }
        //Открытие страницы для редактирования информации
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible).click();
        //Добаваление аватарки
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[4]/p/button")).should(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/input")).uploadFile(new File(baseURL.SVGPATH()));
        //Закрытие окна и сообщение об ошибке
        $(By.xpath("/html/body/div[2]/section/main/form/p")).shouldHave(exactText("Неверный тип файла. Доступны: jpg, jpeg, png"));
        $(By.xpath("/html/body/div[2]/section/main/form/button")).should(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/header/a")).click();
    }

    @Test
    void changeEmail(){
        open(baseURL.MAIN_PAGE_URL());
        //Авторизация пользователя
        boolean isntLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).exists();
        if(isntLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }
        //Открытие окна для смены почты
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[2]/p")).should(visible).click();
        //Почта соответствует пользователю
        $(By.xpath("/html/body/div[2]/section/main/div/p")).shouldBe(visible).shouldHave(exactText(baseURL.MAIL_USER()));
        $(By.xpath("/html/body/div[2]/section/main/div/button")).shouldBe(visible,clickable);
        //Пустые поля
        $(By.xpath("/html/body/div[2]/section/main/form/div/div")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div/p")).shouldBe(visible).shouldHave(exactText("Необходимо заполнить поле: Код"));
        //Неверный код
        $(By.xpath("/html/body/div[2]/section/main/form/div/div/input")).shouldBe(visible).setValue("111111");
        $(By.xpath("/html/body/div[2]/section/main/form/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/p")).shouldBe(visible).shouldHave(exactText("Неверный код"));
        //закрытие
        $(By.xpath("/html/body/div[2]/section/button")).shouldBe(visible).click();
    }

    @Test
    void changePasswordNormal(){
        open(baseURL.MAIN_PAGE_URL());
        //Авторизация
        boolean isntLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).exists();
        if(isntLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }
        //Открытие окна для смены пароля
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[3]/p/button")).should(visible).click();
        //Отображение кнопок
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/button")).shouldBe(visible, clickable);
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/button")).shouldBe(visible, clickable);
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/button")).shouldBe(visible, clickable);
        //Ввод пароля
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.PASSWORD_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/input")).setValue(baseURL.PASSWORD_USER());
        //соблюдение условий
        if($$(".svg-inline--fa.fa-circle-check.mr-2.text-\\[\\#4A88FC\\]").stream().toArray().length == 3){
            $(By.xpath("/html/body/div[2]/section/main/button")).shouldBe(visible).click();
        }
        $(By.xpath("/html/body/div[2]/section/button")).click();
    }

    @Test
    void changePasswordLeast(){
        open(baseURL.MAIN_PAGE_URL());
        //Авторизация
        boolean isntLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).exists();
        if(isntLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }
        //Открытие окна для смены пароля
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[3]/p/button")).should(visible).click();
        //Отображение кнопок
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/button")).shouldBe(visible).click();
        //Ввод пароля
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue("1234567");
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/input")).setValue("1234567");
        //Проверка работы условий
        if($$(".svg-inline--fa.fa-circle-check.mr-2.text-\\[\\#6B607B\\]").stream().toArray().length != 0) {
            $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/input")).setValue("8");
            if ($$(".svg-inline--fa.fa-circle-check.mr-2.text-\\[\\#4A88FC\\]").stream().toArray().length == 1) {
                $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue("8");
                if ($$(".svg-inline--fa.fa-circle-check.mr-2.text-\\[\\#4A88FC\\]").stream().toArray().length == 2) {
                    $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.PASSWORD_USER());
                    $(By.xpath("/html/body/div[2]/section/button")).click();
                }
            }
        }
    }
}
