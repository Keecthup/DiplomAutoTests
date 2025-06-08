package apiTests;

import config.KPTCSMPTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import model.requestDTO.AuthLogin;
import model.responseDTO.AuthLoginResponse;
import model.responseDTO.GuildOrder;
import model.requestDTO.GuildOrderDto;

import java.util.List;

import static steps.Steps.API_STEPS;

public class GuildOrdersPositiveTest {
    private static String  ADMIN_TOKEN;
    private static String USER_TOKEN;
    KPTCSMPTests config = ConfigFactory.create(KPTCSMPTests.class);

    @Test
    @BeforeEach
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
    void allGuildsOrders(){
       API_STEPS.ordersList("1");
    }

    @Test
    void GuildOrdersMax(){API_STEPS.ordersList("1000000");}

    @Test
    @Order(2)
    void forbidenCreateGuild(){
        GuildOrderDto order = new GuildOrderDto("wds", "12345678", "dsa");
        API_STEPS.orderForbidenCreate(order, USER_TOKEN);
    }

    @Test
    @Order(2)
    void UnAuthCreateGuild(){
        GuildOrderDto orderDto = new GuildOrderDto("wds", "12345678", "dsa");
        API_STEPS.orderUnAuthCreate(orderDto);
    }

    @Test
    @Order(2)
    void createGuildsMin(){
        GuildOrderDto order = new GuildOrderDto("wds","12345678","dsa");
        API_STEPS.orderCreate(order,ADMIN_TOKEN);
    }

    @Test
    @Order(2)
    void createGuildsMax(){
        GuildOrderDto order = new GuildOrderDto(config.GUILD_NAME(), config.GUILD_CONTENT(),config.GUILD_PSEYDONIM());
        API_STEPS.orderCreate(order,ADMIN_TOKEN);
    }

    @Test
    @Order(3)
    void updateGuildsMin(){
        GuildOrderDto order = new GuildOrderDto("www","12345678", "www");
        List<GuildOrder> guildOrders = API_STEPS.ordersList("").getGuildOrders();
        API_STEPS.orderUpdate(guildOrders.stream().findFirst().get().getId(), order, ADMIN_TOKEN);
    }

    @Test
    @Order(3)
    void updateGuildsMax(){
        GuildOrderDto order = new GuildOrderDto(config.GUILD_NAME(), config.GUILD_CONTENT(), config.GUILD_PSEYDONIM());
        List<GuildOrder> guildOrders = API_STEPS.ordersList("").getGuildOrders();
        API_STEPS.orderUpdate(guildOrders.stream().findFirst().get().getId(), order, ADMIN_TOKEN);
    }

    @Test
    @Order(3)
    void unAuthUpdateOrder(){
        GuildOrderDto order = new GuildOrderDto(config.GUILD_NAME(), config.GUILD_CONTENT(), config.GUILD_PSEYDONIM());
        List<GuildOrder> guildOrders = API_STEPS.ordersList("").getGuildOrders();
        API_STEPS.orderUnAuthUpdate(guildOrders.stream().findFirst().get().getId(), order);
    }

    @Test
    @Order(3)
    void forbidenUpdateOrder(){
        GuildOrderDto order = new GuildOrderDto(config.GUILD_NAME(), config.GUILD_CONTENT(), config.GUILD_PSEYDONIM());
        List<GuildOrder> guildOrders = API_STEPS.ordersList("").getGuildOrders();
        API_STEPS.orderForbidenUpdate(guildOrders.stream().findFirst().get().getId(), order, USER_TOKEN);
     }

    @Test
    @Order(4)
    void deleteGuilds(){
        List<GuildOrder> guildOrders = API_STEPS.ordersList("").getGuildOrders();
        API_STEPS.orderDelete(guildOrders.stream().findFirst().get().getId(),ADMIN_TOKEN);
    }

    @Test
    @Order(4)
    void unAuthDeleteGuilds(){
        List<GuildOrder> guildOrders = API_STEPS.ordersList("").getGuildOrders();
        API_STEPS.orderUnAuthDelete(guildOrders.stream().findFirst().get().getId());
    }

    @Test
    @Order(4)
    void forbidenDeleteGuilds(){
        List<GuildOrder> guildOrders = API_STEPS.ordersList("").getGuildOrders();
        API_STEPS.orderForbidenDelete(guildOrders.stream().findFirst().get().getId(), USER_TOKEN);
    }

}
