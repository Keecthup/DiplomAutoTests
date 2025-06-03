package steps;

import config.KPTCSMPTests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.requestDTO.AuthLogin;
import model.requestDTO.GuildOrderDto;
import model.requestDTO.NewsRequestDto;
import model.requestDTO.PasswordChangeDto;
import model.responseDTO.GuildOrder;
import model.responseDTO.GuildOrderGroupDto;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;

public class ApiStepsNegative {
    KPTCSMPTests config = ConfigFactory.create(KPTCSMPTests.class);

    public void login(AuthLogin authLogin){
         RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(authLogin)
                .post(config.LOGIN_URL())
                .then().statusCode(400);
    }

    public void newsListBadRequest(String page){
        RestAssured
                .given()
                .when()
                .get(config.NEWS_PAGE_URL() + page)
                .then()
                .statusCode(400)
                .log().all();
    }

    public void newsFindBadRequest(String id){
        RestAssured
                .given()
                .when()
                .get(config.NEWS_WITH_ID_URL() + id)
                .then()
                .statusCode(400)
                .log().all();
    }

    public void newsFindNotExist(int id){
        RestAssured
                .given()
                .when()
                .get(config.NEWS_WITH_ID_URL() + id)
                .then()
                .statusCode(404)
                .log().all();
    }

    public void newsCreateBadRequest(NewsRequestDto request, String token, File imageFile) {
        RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .multiPart("title", request.getTitle())
                .multiPart("content", request.getContent())
                .multiPart("image", imageFile, "image/jpeg")
                .when()
                .post(config.NEWS_URL())
                .then()
                .statusCode(400)
                .log().all();
    }

    public void newsEditContentBadRequest(int id, NewsRequestDto request, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(request)
                .put(config.NEWS_WITH_ID_URL() + id)
                .then()
                .statusCode(400)
                .log().all();
    }

    public void newsEditContentNotExist(int id, NewsRequestDto request, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(request)
                .put(config.NEWS_WITH_ID_URL() + id)
                .then()
                .statusCode(404)
                .log().all();
    }

        public void newsEditPictureBadRequest(int id, File imageFile, String token){
            RestAssured
                    .given()
                    .header("Authorization", "Bearer " + token)
                    .multiPart("image", imageFile, "image/jpeg")
                    .when()
                    .put(config.NEWS_WITH_ID_URL() + id + "/preview")
                    .then()
                    .statusCode(400)
                    .log().all();
        }

    public void newsEditPictureNotExist(int id, File imageFile, String token){
        RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .multiPart("image", imageFile, "image/jpeg")
                .when()
                .put(config.NEWS_WITH_ID_URL() + id + "/preview")
                .then()
                .statusCode(404)
                .log().all();
    }

    public void orderListBadRequest(String id){
         RestAssured
                .given()
                .when()
                .get(config.GUILD_ORDERS_URL()+"?page=" + id)
                .then()
                .statusCode(400)
                .log().all();
    }

    public void orderCreateBadRequest(GuildOrderDto order, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .body(order)
                .contentType("application/json")
                .post(config.GUILD_ONE_ORDER_URL())
                .then()
                .statusCode(400)
                .log().all();
    }

    public void orderUpdateBadRequest(int id, GuildOrderDto orderDto, String token){
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
                .statusCode(400)
                .log().all();
    }

    public void orderUpdateNotExist(int id, GuildOrderDto order , String token){
             RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .body(order)
                .contentType("application/json")
                .when()
                .put(config.GUILD_ID_URL() + id)
                .then()
                .statusCode(404)
                .log().all();
    }

    public void updatePasswordBadRequest(PasswordChangeDto password, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .body(password)
                .contentType("application/json")
                .put(config.RESET_PASSWORD_URL())
                .then()
                .statusCode(400)
                .log().all();
    }

    public void changePFPBadRequest(File imageFile,String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .multiPart("image", imageFile, "image/jpeg")
                .put(config.CHANGE_AVATAR_URL())
                .then()
                .statusCode(400)
                .log().all();
    }

    public void orderDeleteNotExist(int id, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(config.GUILD_ID_URL() + id)
                .then()
                .statusCode(404)
                .log().all();
    }

    public void orderDeleteBadRequest(int id, String token){
        RestAssured
                .given()
                .when()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(config.GUILD_ID_URL() + id)
                .then()
                .statusCode(400)
                .log().all();
    }

}
