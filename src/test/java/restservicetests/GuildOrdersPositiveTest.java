package restservicetests;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import model.requestDTO.AuthLogin;
import model.responseDTO.AuthLoginResponse;
import model.responseDTO.GuildOrder;
import model.requestDTO.GuildOrderDto;

import java.util.List;

import static values.Constants.*;
import static steps.Steps.API_STEPS;

public class GuildOrdersPositiveTest {
    private static String  TOKEN;
    @Test
    @Order(1)
    void loginAdmin(){
        AuthLogin authLogin = new AuthLogin(LOGIN_ADMIN.toString(), PASSWORD_ADMIN.toString());

        AuthLoginResponse response = API_STEPS.login(authLogin);
        TOKEN = response.getJwtTokenPairDto().getAccessToken();
    }
    @Test
    void allGuildsOrders(){
       API_STEPS.guildAll();
    }
    @Test
    @Order(2)
    void createGuildsMin(){
        GuildOrderDto order = new GuildOrderDto("wds","12345678","dsa");
        API_STEPS.createOrder(order,TOKEN);
    }@Test
    @Order(2)
    void createGuildsMax(){
        GuildOrderDto order = new GuildOrderDto(GUILD_NAME.toString(),GUILD_CONTENT.toString(),GUILD_PSEYDONIM.toString());
        API_STEPS.createOrder(order,TOKEN);
    }
    @Test
    @Order(3)
    void updateGuildsMin(){
        GuildOrderDto order = new GuildOrderDto("www","12345678", "www");
        List<GuildOrder> guildOrders = API_STEPS.guildAll().getGuildOrders();
        API_STEPS.updateOrder(guildOrders.stream().findFirst().get().getId(), order, TOKEN);
    }
    @Test
    @Order(3)
    void updateGuildsMax(){
        GuildOrderDto order = new GuildOrderDto(GUILD_NAME.toString(),GUILD_CONTENT.toString(),GUILD_PSEYDONIM.toString());
        List<GuildOrder> guildOrders = API_STEPS.guildAll().getGuildOrders();
        API_STEPS.updateOrder(guildOrders.stream().findFirst().get().getId(), order, TOKEN);
    }
    @Test
    @Order(4)
    void deleteGuilds(){
        List<GuildOrder> guildOrders = API_STEPS.guildAll().getGuildOrders();
        API_STEPS.deleteOrder(guildOrders.stream().findFirst().get().getId(),TOKEN);
    }
}
