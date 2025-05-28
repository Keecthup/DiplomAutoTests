package restservicetests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pojo.*;

import java.io.File;

import static steps.Steps.API_STEPS;


public class RestTest {
    private static String  TOKEN;
    @Test
    @Order(1)
    void loginAdmin(){
        AuthLogin authLogin = new AuthLogin("Rinwave", "abcd7777");

        AuthLoginResponse response = API_STEPS.login(authLogin);
        TOKEN = response.getJwtTokenPairDto().getAccessToken();
    }

    @Test
    void sendEmailCode(){
        EmailDto email = new EmailDto("vip.inboxtest123@mail.ru");
        API_STEPS.sendCode(email);
    }
}
