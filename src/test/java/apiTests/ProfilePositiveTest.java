package apiTests;

import config.KPTCSMPTests;
import model.requestDTO.EmailDto;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import model.requestDTO.AuthLogin;
import model.responseDTO.AuthLoginResponse;
import model.requestDTO.PasswordChangeDto;

import java.io.File;

import static steps.Steps.API_STEPS;

public class ProfilePositiveTest {

    private static String  TOKEN;
    KPTCSMPTests config = ConfigFactory.create(KPTCSMPTests.class);

    @Test
    @Order(1)
    void loginAdmin(){
        AuthLogin authLogin = new AuthLogin(config.LOGIN_ADMIN(), config.PASSWORD_ADMIN());

        AuthLoginResponse response = API_STEPS.login(authLogin);
        TOKEN = response.getJwtTokenPairDto().getAccessToken();
    }

    @Test
    @Order(3)
    void resetPassword(){
        PasswordChangeDto password = new PasswordChangeDto("abcd7777", "abcd7778", "abcd7778");
        API_STEPS.resetPassword(password, TOKEN);
    }

    @Test
    @Order(2)
    void changePicturePNG(){
        File imageFile = new File(config.PNGPATH());
    API_STEPS.changePicture(imageFile, TOKEN);
    }

    @Test
    @Order(2)
    void changePictureJPG(){
        File imageFile = new File(config.JPGPATH());
        API_STEPS.changePicture(imageFile, TOKEN);
    }

    @Test
    @Order(2)
    void userProfile(){
        API_STEPS.userProfile(TOKEN);
    }

    @Test
    @Order(2)
    void detailsAccount(){
        API_STEPS.accountDetails(TOKEN);
    }

    @Test
    void sendEmailCode(){
        EmailDto email = new EmailDto("vip.inboxtest123@mail.ru");
        API_STEPS.sendCode(email);
    }
}
