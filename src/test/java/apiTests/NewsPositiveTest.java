package apiTests;

import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import model.requestDTO.AuthLogin;
import model.responseDTO.AuthLoginResponse;
import model.responseDTO.HeadlineNewsDto;
import model.requestDTO.NewsRequestDto;

import java.io.File;
import java.util.List;

import static steps.Steps.API_STEPS;

public class NewsPositiveTest {

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
    @Order(2)
    void newsPostMin(){
        NewsRequestDto request = new NewsRequestDto("tes", "12345678");
        File imageFile = new File(config.JPGPATH());
        API_STEPS.postNews(request,TOKEN,imageFile);
    }

    @Test
    @Order(2)
    void newsPostMax(){
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(),config.NEWS_CONTENT());
    File imageFile = new File(config.PNGPATH());
        API_STEPS.postNews(request,TOKEN,imageFile);
    }

    @Test
    void newsGetAllFist(){
        API_STEPS.allNews("1");
    }

    @Test
    void newsGetAllHungred(){
        API_STEPS.allNews("100");
    }

    @Test
    void  newsGetByIdFist(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.allNews("1").getNews();
        API_STEPS.onenews(newsDtoList.stream().findFirst().get().getId());
    }

    @Test
    @Order(3)
    void newsUpdateMin(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.allNews("1").getNews();
        NewsRequestDto request = new NewsRequestDto("tes", "12345678");
        API_STEPS.editNews(newsDtoList.stream().findFirst().get().getId(), request, TOKEN);
    }

    @Test
    @Order(3)
    void newsUpdateMax(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.allNews("1").getNews();
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(),config.NEWS_CONTENT());
        API_STEPS.editNews(newsDtoList.stream().findFirst().get().getId(), request, TOKEN);
    }

    @Test
    @Order(3)
    void newsUpdatePicjpg(){
        File imageFile = new File(config.JPGPATH());
        List<HeadlineNewsDto> newsDtoList = API_STEPS.allNews("1").getNews();
        API_STEPS.editPic(newsDtoList.stream().findFirst().get().getId(),imageFile,TOKEN);
    }

    @Test
    @Order(3)
    void newsUpdatePicpng(){
        File imageFile = new File(config.PNGPATH());
        List<HeadlineNewsDto> newsDtoList = API_STEPS.allNews("1").getNews();
        API_STEPS.editPic(newsDtoList.stream().findFirst().get().getId(),imageFile,TOKEN);
    }

    @Test
    @Order(4)
    void deleteNews(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.allNews("1").getNews();
        API_STEPS.deleteNews(newsDtoList.stream().findFirst().get().getId(), TOKEN);
    }
}
