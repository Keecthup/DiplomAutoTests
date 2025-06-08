package apiTests;

import config.KPTCSMPTests;
import model.requestDTO.AuthLogin;
import model.requestDTO.NewsRequestDto;
import model.responseDTO.AuthLoginResponse;
import model.responseDTO.HeadlineNewsDto;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static steps.Steps.API_STEPS;
import static steps.Steps.API_STEPS_NEGATIVE;

public class NewsNegativeTest {
    private static String  ADMIN_TOKEN;

    KPTCSMPTests config = ConfigFactory.create(KPTCSMPTests.class);

    @Test
    @BeforeEach
    void loginAdmin(){
        AuthLogin authLogin = new AuthLogin(config.LOGIN_ADMIN(), config.PASSWORD_ADMIN());

        AuthLoginResponse response = API_STEPS.login(authLogin);
        ADMIN_TOKEN = response.getTokens().getAccessToken();
    }

    @Test
    @Order(2)
    void newsListBadRequestString(){
        API_STEPS_NEGATIVE.newsListBadRequest("string");
    }

    @Test
    @Order(2)
    void newsListBadRequestOverInt(){
        API_STEPS_NEGATIVE.newsListBadRequest("1000001");
    }

    @Test
    @Order(2)
    void newsFindNotExist(){
        API_STEPS_NEGATIVE.newsFindNotExist(1000000);
    }

    @Test
    @Order(2)
    void newsFindBadRequest(){
        API_STEPS_NEGATIVE.newsFindBadRequest("string");
    }

    @Test
    @Order(2)
    void newsPostMin(){
        NewsRequestDto request = new NewsRequestDto("te", "1234567");
        File imageFile = new File(config.JPGPATH());
        API_STEPS_NEGATIVE.newsCreateBadRequest(request,ADMIN_TOKEN,imageFile);
    }

    @Test
    @Order(2)
    void newsPostMax(){
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME_MAX(),config.NEWS_CONTENT_MAX());
        File imageFile = new File(config.PNGPATH());
        API_STEPS_NEGATIVE.newsCreateBadRequest(request,ADMIN_TOKEN,imageFile);
    }

    @Test
    @Order(2)
    void newsPostSVG(){
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(), config.NEWS_CONTENT());
        File image = new File(config.SVGPATH());
        API_STEPS_NEGATIVE.newsCreateBadRequest(request,ADMIN_TOKEN,image);
    }

    @Test
    @Order(2)
    void newsPostGIF(){
        NewsRequestDto request = new NewsRequestDto("это гиф", "это гифкакакак");
        File image = new File(config.GIFPATH());
        API_STEPS_NEGATIVE.newsCreateBadRequest(request, ADMIN_TOKEN, image);
    }

    @Test
    @Order(2)
    void newsEditContentMax(){
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME_MAX(), config.NEWS_CONTENT_MAX());
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS_NEGATIVE.newsEditContentBadRequest(newsDtoList.stream().findFirst().get().getId(), request, ADMIN_TOKEN);
    }

    @Test
    @Order(2)
    void newsEditContentMin(){
        NewsRequestDto request = new NewsRequestDto("12", "1234567");
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS_NEGATIVE.newsEditContentBadRequest(newsDtoList.stream().findFirst().get().getId(), request, ADMIN_TOKEN);
    }

    @Test
    @Order(2)
    void newsEditContentID(){
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(), config.NEWS_CONTENT());
        API_STEPS_NEGATIVE.newsEditContentBadRequest(-1, request, ADMIN_TOKEN);
    }

    @Test
    @Order(2)
    void newsEditPictureNotFound(){
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(), config.NEWS_CONTENT());
        API_STEPS_NEGATIVE.newsEditContentNotExist(1000000, request, ADMIN_TOKEN);
    }

    @Test
    @Order(2)
    void newsEditPictureSVG(){
        File image = new File(config.SVGPATH());
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS_NEGATIVE.newsEditPictureBadRequest(newsDtoList.stream().findFirst().get().getId(), image, ADMIN_TOKEN);
    }

    @Test
    @Order(2)
    void newsEditPictureGIF(){
        File image = new File(config.GIFPATH());
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS_NEGATIVE.newsEditPictureBadRequest(newsDtoList.stream().findFirst().get().getId(), image, ADMIN_TOKEN);
    }

    @Test
    @Order(2)
    void newsEditPictureID(){
        File image = new File(config.JPEGPATH());
        API_STEPS_NEGATIVE.newsEditPictureBadRequest(-1, image, ADMIN_TOKEN);
    }

    @Test
    @Order(2)
    void newsEditPictureNotExist(){
        File image = new File(config.JPEGPATH());
        API_STEPS_NEGATIVE.newsEditPictureNotExist(1000000, image, ADMIN_TOKEN);
    }
}
