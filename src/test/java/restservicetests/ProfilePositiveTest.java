package restservicetests;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pojo.AuthLogin;
import pojo.AuthLoginResponse;
import pojo.PasswordChangeDto;

import java.io.File;

import static steps.Steps.API_STEPS;

public class ProfilePositiveTest {
    private static String  TOKEN;

    @Test
    @Order(1)
    void loginAdmin(){
        AuthLogin authLogin = new AuthLogin("Rinwave", "abcd7777");

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
