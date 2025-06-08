package uiTests;

import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ModuleWindows {
    KPTCSMPTests baseURL = ConfigFactory.create(KPTCSMPTests.class);
    @Test
    void registrationWindowLeast(){
        open(baseURL.MAIN_PAGE_URL());
        //Открытие окна регистрации
        $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/p[2]")).shouldBe(visible).click();
        //Пустые значения
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/input")).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[4]/div/input")).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[5]/div/input")).click();
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Меньше минимальных
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue("12");
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue("1");
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/input")).setValue("12345");
        $(By.xpath("/html/body/div[2]/section/main/form/div[4]/div/input")).setValue("abcd777");
        $(By.xpath("/html/body/div[2]/section/main/form/div[4]/div/button[2]")).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[5]/div/input")).setValue("abcd777");
        $(By.xpath("/html/body/div[2]/section/main/form/div[5]/div/button[2]")).click();
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
    }

    @Test
    void registrationWindowNormal(){
        open(baseURL.MAIN_PAGE_URL());
        //Открытие окна регистрации
        $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/p[2]")).shouldBe(visible).click();
        //Введен только логин
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue("123");
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Введен код
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/input")).setValue("123456");
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Введен пароль
        $(By.xpath("/html/body/div[2]/section/main/form/div[4]/div/input")).setValue(baseURL.PASSWORD_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Введено подтверждение пароля
        $(By.xpath("/html/body/div[2]/section/main/form/div[5]/div/input")).setValue(baseURL.PASSWORD_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Введен адрес эл.почты (занят)
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue(baseURL.MAIL_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Введен адрес эл.почты (новый)
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue("1arturkovalev867@gmail.com");
        //Выход
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/div[2]/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
    }

    @Test
    void registrationWindowMaximum(){
        open(baseURL.MAIN_PAGE_URL());
        //Открытие окна регистрации
        $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/p[2]")).shouldBe(visible).click();
        //Попытка ввести сверх макс. логин
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/input")).setValue("11111111111111111");
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Попытка ввести сверх макс. код
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/input")).setValue("1111111");
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Попытка ввести сверх макс. пароль
        $(By.xpath("/html/body/div[2]/section/main/form/div[4]/div/input")).setValue("1111111111111111111111111111111");
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Попытка ввести сверх макс. подверждение пароля
        $(By.xpath("/html/body/div[2]/section/main/form/div[5]/div/input")).setValue("1111111111111111111111111111111");
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //Попытка ввести сверх макс. Эл.почта
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/input")).setValue("1111111111111111111111111111111");
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();

        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/div[2]/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/button")).click();
        //стереть введенные значения и закрыть
        $(By.xpath("/html/body/div[2]/section/main/form/div[1]/div/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[2]/div/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/div/div[1]")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[4]/div/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[5]/div/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/button")).shouldBe(visible).click();

    }

    @Test
    void forgotPasswordWindow(){
        open(baseURL.MAIN_PAGE_URL());
        //Открытие окна потеря пароля
        $(By.xpath("//*[@id=\"root\"]/header/div/section/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div[3]/p[1]")).shouldBe(visible).click();
        //Не заполнены поля
        $(By.xpath("/html/body/div[2]/section/main/form/div/div/input")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/div/p")).shouldBe(visible).shouldHave(exactText("Необходимо заполнить поле: Электронная почта"));
        //не существующее почта
        $(By.xpath("/html/body/div[2]/section/main/form/div/div/input")).shouldBe(visible).setValue("1@mail");
        $(By.xpath("/html/body/div[2]/section/main/form/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/main/form/p")).shouldBe(visible).shouldHave(exactText("Пользователь не найден"));
        $(By.xpath("/html/body/div[2]/section/main/form/div/div/button"));
        //существующая почта, неправильный код
        $(By.xpath("/html/body/div[2]/section/main/form/div/div/input")).shouldBe(visible).setValue(baseURL.MAIL_USER());
        $(By.xpath("/html/body/div[2]/section/main/form/button")).shouldBe(visible).click();
        $(By.xpath("/html/body/div[2]/section/button")).shouldBe(visible).click();

    }
}
