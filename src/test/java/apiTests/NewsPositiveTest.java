package apiTests;

import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
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

    private static String  ADMIN_TOKEN;
    private static String USER_TOKEN;
    KPTCSMPTests config = ConfigFactory.create(KPTCSMPTests.class);

    @Test
    @Order(1)
    void loginAdmin(){
        AuthLogin authLogin = new AuthLogin(config.LOGIN_ADMIN(), config.PASSWORD_ADMIN());

        AuthLoginResponse response = API_STEPS.login(authLogin);
        ADMIN_TOKEN = response.getTokens().getAccessToken();
    }

    @Test
    @Order(1)
    void loginUser(){
        AuthLogin authLogin = new AuthLogin(config.LOGIN_USER(), config.PASSWORD_USER());

        AuthLoginResponse response = API_STEPS.login(authLogin);
        USER_TOKEN = response.getTokens().getAccessToken();
    }

    @Test
    @Order(2)
    void newsPostMin(){
        NewsRequestDto request = new NewsRequestDto("tes", "12345678");
        File imageFile = new File(config.JPGPATH());
        API_STEPS.newsPost(request,ADMIN_TOKEN,imageFile);
    }

    @Test
    @Order(2)
    void newsPostMax(){
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(),config.NEWS_CONTENT());
    File imageFile = new File(config.PNGPATH());
        API_STEPS.newsPost(request,ADMIN_TOKEN,imageFile);
    }

    @Test
    @Order(2)
    void unAuthPostNews(){
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(), config.NEWS_CONTENT());
        File file = new File(config.PNGPATH());
        API_STEPS.newsUnAuthPost(request, file);
    }

    @Test
    @Order(2)
    void forbidenPostNews(){
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(), config.NEWS_CONTENT());
        File file = new File(config.JPGPATH());
        API_STEPS.newsForbidenPost(request, file, USER_TOKEN);
    }

    @Test
    void newsGetAllFist(){
        API_STEPS.newsList("1");
    }

    @Test
    void newsGetAllMax(){
        API_STEPS.newsList("1000000");
    }

    @Test
    void  newsGetByIdFist(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS.newsFind(newsDtoList.stream().findFirst().get().getId());
    }

    @Test
    @Order(3)
    void newsUpdateMin(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        NewsRequestDto request = new NewsRequestDto("tes", "12345678");
        API_STEPS.newsUpdateContent(newsDtoList.stream().findFirst().get().getId(), request, ADMIN_TOKEN);
    }

    @Test
    @Order(3)
    void newsUpdateMax(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(),config.NEWS_CONTENT());
        API_STEPS.newsUpdateContent(newsDtoList.stream().findFirst().get().getId(), request, ADMIN_TOKEN);
    }

    @Test
    @Order(3)
    void unAuthUpdateNews(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(), config.NEWS_CONTENT());
        API_STEPS.newsUnAuthUpdateContent(newsDtoList.stream().findFirst().get().getId(), request);
    }

    @Test
    @Order(3)
    void forbidenUpdateNews(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        NewsRequestDto request = new NewsRequestDto(config.NEWS_NAME(), config.NEWS_CONTENT());
        API_STEPS.newsForbidenUpdateContent(newsDtoList.stream().findFirst().get().getId(), request, USER_TOKEN);
    }

    @Test
    @Order(3)
    void newsUpdatePicjpg(){
        File imageFile = new File(config.JPGPATH());
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS.newsUpdatePic(newsDtoList.stream().findFirst().get().getId(),imageFile,ADMIN_TOKEN);
    }

    @Test
    @Order(3)
    void newsUpdatePicpng(){
        File imageFile = new File(config.PNGPATH());
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS.newsUpdatePic (newsDtoList.stream().findFirst().get().getId(),imageFile,ADMIN_TOKEN);
    }

    @Test
    @Order(3)
    void unAuthUpdatePicNews(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        File imageFile = new File(config.JPGPATH());
        API_STEPS.newsUnAuthUpdatePic(newsDtoList.stream().findFirst().get().getId(), imageFile);
    }

    @Test
    @Order(3)
    void forbidenUpdatePicNews(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        File imageFile = new File(config.PNGPATH());
        API_STEPS.newsForbidenUpdatePic(newsDtoList.stream().findFirst().get().getId(),imageFile,USER_TOKEN);
    }

    @Test
    @Order(4)
    void deleteNews(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS.newsDelete(newsDtoList.stream().findFirst().get().getId(), ADMIN_TOKEN);
    }

    @Test
    @Order(4)
    void unAuthDeleteNews(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS.newsUnAuthDelete(newsDtoList.stream().findFirst().get().getId());
    }

    @Test
    @Order(4)
    void forbidenDeleteNews(){
        List<HeadlineNewsDto> newsDtoList = API_STEPS.newsList("1").getNews();
        API_STEPS.newsForbidenDelete(newsDtoList.stream().findFirst().get().getId(), USER_TOKEN);
    }
}
