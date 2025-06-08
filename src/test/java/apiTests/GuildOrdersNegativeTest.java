package apiTests;

import config.KPTCSMPTests;
import model.requestDTO.AuthLogin;
import model.requestDTO.GuildOrderDto;
import model.responseDTO.AuthLoginResponse;
import model.responseDTO.GuildOrder;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static steps.Steps.API_STEPS;
import static steps.Steps.API_STEPS_NEGATIVE;

public class GuildOrdersNegativeTest {
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
    void orderListBadRequest(){
        API_STEPS_NEGATIVE.orderListBadRequest("string");
    }

    @Test
    void guildCreateOverMin(){
        GuildOrderDto order = new GuildOrderDto("12", "1234567", "12");
        API_STEPS_NEGATIVE.orderCreateBadRequest(order, ADMIN_TOKEN);
    }

    @Test
    void guildCreateOverMax(){
        GuildOrderDto order = new GuildOrderDto(config.GUILD_NAME_MAX(),config.GUILD_CONTENT_MAX(),config.GUILD_PSEYDONIM_MAX());
        API_STEPS_NEGATIVE.orderCreateBadRequest(order, ADMIN_TOKEN);
    }

    @Test
    void guildUpdateOverMin(){
        GuildOrderDto order = new GuildOrderDto("12", "1234567", "12");
        List<GuildOrder> guildOrders = API_STEPS.ordersList("").getGuildOrders();
        API_STEPS_NEGATIVE.orderUpdateBadRequest(guildOrders.stream().findFirst().get().getId(),order, ADMIN_TOKEN);
    }

    @Test
    void guildUpdateOverMax(){
        GuildOrderDto order = new GuildOrderDto(config.GUILD_NAME_MAX(), config.GUILD_CONTENT_MAX(), config.GUILD_PSEYDONIM_MAX());
        List<GuildOrder> guildOrders = API_STEPS.ordersList("").getGuildOrders();
        API_STEPS_NEGATIVE.orderUpdateBadRequest(guildOrders.stream().findFirst().get().getId(),order, ADMIN_TOKEN);
    }

    @Test
    void guildUpdateBadRequest(){
        GuildOrderDto order = new GuildOrderDto(config.GUILD_NAME(), config.GUILD_CONTENT(), config.GUILD_PSEYDONIM());
        API_STEPS_NEGATIVE.orderUpdateBadRequest(-1,order,ADMIN_TOKEN);
    }

    @Test
    void guildUpdateNotExist(){
        GuildOrderDto order = new GuildOrderDto(config.GUILD_NAME(), config.GUILD_CONTENT(), config.GUILD_PSEYDONIM());
        API_STEPS_NEGATIVE.orderUpdateNotExist(1000000,order,ADMIN_TOKEN);
    }

    @Test
    void deleteOrderBadRequest(){
        API_STEPS_NEGATIVE.orderDeleteBadRequest(-1,ADMIN_TOKEN);
    }

}
