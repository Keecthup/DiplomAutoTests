package steps;

import config.KPTCSMPTests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.requestDTO.AuthLogin;
import model.requestDTO.EmailDto;
import model.requestDTO.GuildOrderDto;
import model.requestDTO.NewsRequestDto;
import model.requestDTO.PasswordChangeDto;
import model.responseDTO.AuthLoginResponse;
import model.responseDTO.GuildOrder;
import model.responseDTO.GuildOrderGroupDto;
import model.responseDTO.HeadlineNewsGroupDto;
import model.responseDTO.NewsResponseDto;
import model.responseDTO.UserAccountDetailsDto;
import model.responseDTO.UserProfileDto;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;

public class ApiSteps {
    KPTCSMPTests config = ConfigFactory.create(KPTCSMPTests.class);
    public AuthLoginResponse login(AuthLogin authLogin){
        return RestAssured
                .given()
                .when()
                .contentType(ContentType.JSON)
                .body(authLogin)
                .post(config.LOGIN_URL())
                .then().statusCode(200)
                .log().all()
                .extract().response().body().as(AuthLoginResponse.class);
    }

    public NewsResponseDto newsPost(NewsRequestDto request, String token, File imageFile) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .multiPart("title", request.getTitle())
                .multiPart("content", request.getContent())
                .multiPart("image", imageFile, "image/jpeg")
                .when()
                .post(config.NEWS_URL())
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().body().as(NewsResponseDto.class);
    }

    public void newsUnAuthPost (NewsRequestDto request, File imageFile){
        RestAssured
                .given()
                .multiPart("title", request.getTitle())
                .multiPart("content", request.getContent())
                .multiPart("image", imageFile, "image/jpeg")
                .when()
                .post(config.NEWS_URL())
                .then()
                .statusCode(401)
                .log().all();
    }

    public void newsForbidenPost (NewsRequestDto request, File imageFile, String token){
        RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .multiPart("title", request.getTitle())
                .multiPart("content", request.getContent())
                .multiPart("image", imageFile, "image/jpeg")
                .when()
                .post(config.NEWS_URL())
                .then()
                .statusCode(403)
                .log().all();
    }

    public HeadlineNewsGroupDto newsList(String page){
        return RestAssured
                .given()
                .when()
                .get(config.NEWS_PAGE_URL() + page)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().body().as(HeadlineNewsGroupDto.class);
    }

   public NewsResponseDto newsFind(int id){
        return RestAssured
                .given()
                .when()
                .get(config.NEWS_WITH_ID_URL() + id)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().body().as(NewsResponseDto.class);
   }

   public NewsResponseDto newsUpdateContent(int id, NewsRequestDto request, String token){
        return RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(request)
                .put(config.NEWS_WITH_ID_URL() + id)
                .then()
                .log().all()
                .extract().response().as(NewsResponseDto.class);

   }

   public void newsUnAuthUpdateContent(int id, NewsRequestDto request){
        RestAssured
                .given()
                .when()
                .contentType("application/json")
                .body(request)
                .put(config.NEWS_WITH_ID_URL() + id)
                .then()
                .log().all();
   }

   public void newsForbidenUpdateContent(int id, NewsRequestDto request, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(request)
                .put(config.NEWS_WITH_ID_URL() + id)
                .then()
                .log().all();
   }

   public NewsResponseDto newsUpdatePic(int id, File imageFile, String token){
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .multiPart("image", imageFile, "image/jpeg")
                .when()
                .put(config.NEWS_WITH_ID_URL() + id + "/preview")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(NewsResponseDto.class);
   }

   public void newsUnAuthUpdatePic(int id, File imageFile){
        RestAssured
                .given()
                .multiPart("image", imageFile, "image/jpeg")
                .when()
                .put(config.NEWS_WITH_ID_URL() + id + "/preview")
                .then()
                .statusCode(401)
                .log().all();
   }

   public void newsForbidenUpdatePic(int id, File imageFile, String token){
        RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .multiPart("image", imageFile, "image/jpeg")
                .when()
                .put(config.NEWS_WITH_ID_URL() + id + "/preview")
                .then()
                .statusCode(403)
                .log().all();
   }

   public void newsDelete(int id, String token){
        RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(config.NEWS_WITH_ID_URL() + id)
                .then()
                .statusCode(200)
                .log().all();
   }

   public void newsUnAuthDelete(int id){
        RestAssured
                .given()
                .when()
                .delete(config.NEWS_WITH_ID_URL() + id)
                .then()
                .statusCode(401)
                .log().all();
   }

   public void newsForbidenDelete(int id, String token){
        RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(config.NEWS_WITH_ID_URL() + id)
                .then()
                .statusCode(403)
                .log().all();
   }

   public GuildOrderGroupDto ordersList(String id){
        return RestAssured
                .given()
                .when()
                .get(config.GUILD_ORDERS_URL()+"?page=" + id)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GuildOrderGroupDto.class);
   }

   public GuildOrder orderCreate(GuildOrderDto order, String token){
        return RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .body(order)
                .contentType("application/json")
                .post(config.GUILD_ONE_ORDER_URL())
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GuildOrder.class);
   }

   public void orderForbidenCreate(GuildOrderDto order, String token){
       RestAssured
               .given()
               .when()
               .header("Authorization", "Bearer " + token)
               .body(order)
               .contentType("application/json")
               .post(config.GUILD_ONE_ORDER_URL())
               .then()
               .statusCode(403)
               .log().all();
   }

   public void orderUnAuthCreate(GuildOrderDto order){
        RestAssured
                .given()
                .when()
                .body(order)
                .contentType("application/json")
                .post(config.GUILD_ONE_ORDER_URL())
                .then()
                .statusCode(401)
                .log().all();
   }

   public GuildOrder orderUpdate(int id, GuildOrderDto order ,String token){
        return RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .body(order)
                .contentType("application/json")
                .when()
                .put(config.GUILD_ID_URL() + id)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GuildOrder.class);
    }

    public void orderUnAuthUpdate(int id, GuildOrderDto orderDto){
        RestAssured
                .given()
                .when()
                .body(orderDto)
                .contentType("application/json")
                .when()
                .put(config.GUILD_ID_URL() + id)
                .then()
                .statusCode(401)
                .log().all();
    }

    public void orderForbidenUpdate (int id, GuildOrderDto orderDto, String token){
        RestAssured
                .given()
                .when()
                .body(orderDto)
                .header("Authorization", "Bearer " + token)
                .body(orderDto)
                .contentType("application/json")
                .when()
                .put(config.GUILD_ID_URL() + id)
                .then()
                .statusCode(403)
                .log().all();
    }

   public void orderDelete(int id, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(config.GUILD_ID_URL() + id)
                .then()
                .statusCode(200)
                .log().all();
   }

   public void orderUnAuthDelete(int id){
        RestAssured
                .given()
                .when()
                .when()
                .delete(config.GUILD_ID_URL() + id)
                .then()
                .statusCode(401)
                .log().all();
   }

   public void orderForbidenDelete(int id, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .delete(config.GUILD_ID_URL() + id)
                .then()
                .statusCode(403)
                .log().all();
   }

public void sendEmailCode(EmailDto email){
        RestAssured
                .given()
                .when()
                .body(email)
                .contentType("application/json")
                .post(config.EMAIL_CODE_URL())
                .then()
                .statusCode(200)
                .log().all();
}

public void passwordUpdate(PasswordChangeDto password, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .body(password)
                .contentType("application/json")
                .put(config.RESET_PASSWORD_URL())
                .then()
                .statusCode(200)
                .log().all();
}

public void changePFP(File imageFile,String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .multiPart("image", imageFile, "image/jpeg")
                .put(config.CHANGE_AVATAR_URL())
                .then()
                .statusCode(200)
                .log().all();
}

public UserProfileDto userProfile(String token){
        return RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .get(config.USER_PROFILE_URL())
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(UserProfileDto.class);
}

public UserAccountDetailsDto accountDetails(String token){
    return RestAssured
            .given()
            .when()
            .header("Authorization", "Bearer " + token)
            .get(config.ACCOUNT_DETAIL_URL())
            .then()
            .statusCode(200)
            .log().all()
            .extract().response().as(UserAccountDetailsDto.class);
}
}