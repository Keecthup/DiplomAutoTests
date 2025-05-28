package restservicetests;

import model.requestDTO.AuthLogin;
import model.requestDTO.EmailDto;
import model.responseDTO.AuthLoginResponse;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

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
