package apiTests;

import config.KPTCSMPTests;
import model.requestDTO.AuthLogin;
import model.requestDTO.PasswordChangeDto;
import model.responseDTO.AuthLoginResponse;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;

import static steps.Steps.API_STEPS;
import static steps.Steps.API_STEPS_NEGATIVE;

public class ProfileNegativeTest {
    private static String  TOKEN;

    KPTCSMPTests config = ConfigFactory.create(KPTCSMPTests.class);

    @Test
    @Order(1)
    void login(){
        AuthLogin authLogin = new AuthLogin(config.LOGIN_USER(), config.PASSWORD_USER());
        AuthLoginResponse response = API_STEPS.login(authLogin);
        TOKEN = response.getTokens().getAccessToken();
    }

    @Test
    @Order(2)
    void loginNegativeTooSmall(){
        AuthLogin authLogin = new AuthLogin("12","1234567");
        API_STEPS_NEGATIVE.login(authLogin);
    }

    @Test
    @Order(2)
    void loginNegativeTooBig(){
        AuthLogin authLogin = new AuthLogin("11111111111111111", "1111111111111111111111111111111");
        API_STEPS_NEGATIVE.login(authLogin);
    }

    @Test
    @Order(2)
    void resetPasswordTooSmall(){
        PasswordChangeDto password = new PasswordChangeDto(config.PASSWORD_USER(), "1234567","1234567");
        API_STEPS_NEGATIVE.updatePasswordBadRequest(password, TOKEN);
    }

    @Test
    @Order(2)
    void resetPasswordTooBig(){
        PasswordChangeDto password = new PasswordChangeDto(config.PASSWORD_USER(), "1111111111111111111111111111111", "1111111111111111111111111111111");
        API_STEPS_NEGATIVE.updatePasswordBadRequest(password,TOKEN);
    }

    @Test
    @Order(2)
    void changeAvatarSVG(){
        File image = new File(config.SVGPATH());
        API_STEPS_NEGATIVE.changePFPBadRequest(image, TOKEN);
    }

    @Test
    @Order(2)
    void changeAvatarGIF(){
        File image = new File(config.GIFPATH());
        API_STEPS_NEGATIVE.changePFPBadRequest(image, TOKEN);
    }

}
