package restservicetests;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import model.requestDTO.AuthLogin;
import model.responseDTO.AuthLoginResponse;
import model.requestDTO.PasswordChangeDto;

import java.io.File;

import static values.Constants.LOGIN_ADMIN;
import static values.Constants.PASSWORD_ADMIN;
import static steps.Steps.API_STEPS;

public class ProfilePositiveTest {
    private static String  TOKEN;

    @Test
    @Order(1)
    void loginAdmin(){
        AuthLogin authLogin = new AuthLogin(LOGIN_ADMIN.toString(), PASSWORD_ADMIN.toString());

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
    void changePicture(){
        File imageFile = new File("C:/Users/111/IdeaProjects/Test/src/main/resources/imgs/0cdbcea62e2c661e4670eae82d0d12f2.jpg");
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
}
