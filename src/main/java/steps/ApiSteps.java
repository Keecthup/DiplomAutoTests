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
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(authLogin)
                .post(config.LOGIN_URL())
                .then().statusCode(200)
                .extract().response().body().as(AuthLoginResponse.class);
    }

    public NewsResponseDto postNews(NewsRequestDto request, String token, File imageFile) {
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

    public HeadlineNewsGroupDto allNews(String page){
        return RestAssured
                .given()
                .when()
                .get(config.NEWS_PAGE_URL() + page)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().body().as(HeadlineNewsGroupDto.class);
    }

   public NewsResponseDto onenews(int id){
        return RestAssured
                .given()
                .when()
                .get(config.NEWS_URL() + id)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().body().as(NewsResponseDto.class);
   }

   public NewsResponseDto editNews(int id, NewsRequestDto request, String token){
        return RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(request)
                .put(config.NEWS_URL() + id)
                .then()
                .extract().response().as(NewsResponseDto.class);

   }

   public NewsResponseDto editPic(int id, File imageFile, String token){
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .multiPart("image", imageFile, "image/jpeg")
                .when()
                .put(config.NEWS_URL() + id + "/preview")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(NewsResponseDto.class);
   }

   public void deleteNews(int id, String token){
        RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(config.NEWS_URL() + id)
                .then()
                .statusCode(200)
                .log().all();
   }

   public GuildOrderGroupDto guildAll(){
        return RestAssured
                .given()
                .when()
                .get(config.GUILD_ORDERS_URL())
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GuildOrderGroupDto.class);
   }

   public GuildOrder createOrder(GuildOrderDto order, String token){
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

   public GuildOrder updateOrder(int id, GuildOrderDto order ,String token){
        return RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .body(order)
                .contentType("application/json")
                .when()
                .put(config.GUILD_ONE_ORDER_URL() + id)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(GuildOrder.class);
    }

   public void deleteOrder(int id, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(config.GUILD_ONE_ORDER_URL() + id)
                .then()
                .statusCode(200)
                .log().all();
   }

public void sendCode(EmailDto email){
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

public void resetPassword(PasswordChangeDto password, String token){
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

public void changePicture(File imageFile,String token){
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