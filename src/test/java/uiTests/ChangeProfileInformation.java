package uiTests;

import com.codeborne.selenide.Configuration;
import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ChangeProfileInformation {

    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);
    @Test
    void ChangePFP(){
        open(baseURL.MAIN_PAGE_URL());

        boolean isLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).exists();
        if(isLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }

        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[4]/p/button")).should(visible).click();

        $("._exitButton_3co66_38").should(clickable,visible);
        $(By.xpath("/html/body/div[2]/section/main/form/input")).uploadFile(new File(baseURL.JPGPATH()));
        $(".rounded-full").should(exist);
        $(By.xpath("/html/body/div[2]/section/main/form/button")).should(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/header/a")).click();
    }
    @Test
    void ChangePassword(){
        open(baseURL.MAIN_PAGE_URL());

        boolean isLoggedIn = $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).exists();
        if(isLoggedIn){
            $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
            $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.LOGIN_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
            $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        }

        $(By.xpath("//*[@id=\"root\"]/header/div/section/div")).click();
        $(By.xpath("//*[@id=\"root\"]/header/div/section/div/div/a[2]")).shouldBe(visible).click();
        $(By.xpath("//*[@id=\"root\"]/div/main/section/section/div[2]/div[3]/p/button")).shouldBe(visible).click();

        $(By.xpath("/html/body/div[2]/section/button")).shouldBe(clickable, visible);
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/button")).shouldBe(visible, clickable);
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/button")).shouldBe(visible, clickable);
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/button")).shouldBe(visible, clickable);

        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue(baseURL.PASSWORD_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.PASSWORD_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/input")).setValue(baseURL.PASSWORD_USER());

        if($$(".svg-inline--fa.fa-circle-check.mr-2.text-\\[\\#4A88FC\\]").stream().toArray().length == 3){
            $(By.xpath("/html/body/div[2]/section/main/button")).shouldBe(visible).click();
        }
    }
}
