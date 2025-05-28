package config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/main/resources/KPTC-smpConfig.properties"})
public interface KPTCSMPTests extends Config {
    @Key("LOGIN_ADMIN")
    String LOGIN_ADMIN();

    @Key("PASSWORD_ADMIN")
    String PASSWORD_ADMIN();

    @Key("GUILD_NAME")
    String GUILD_NAME();

    @Key("GUILD_CONTENT")
    String GUILD_CONTENT();

    @Key("GUILD_PSEYDONIM")
    String GUILD_PSEYDONIM();

    @Key("JPGPATH")
    String JPGPATH();

    @Key("PNGPATH")
    String PNGPATH();

    @Key("NEWS_NAME")
    String NEWS_NAME();

    @Key("NEWS_CONTENT")
    String NEWS_CONTENT();

    @Key("LOGIN_URL")
    String LOGIN_URL();

    @Key("NEWS_URL")
    String NEWS_URL();

    @Key("NEWS_PAGE_URL")
    String NEWS_PAGE_URL();

    @Key("GUILD_ORDERS_URL")
    String GUILD_ORDERS_URL();

    @Key("GUILD_ONE_ORDER_URL")
    String GUILD_ONE_ORDER_URL();

    @Key("EMAIL_CODE_URL")
    String EMAIL_CODE_URL();

    @Key("RESET_PASSWORD_URL")
    String RESET_PASSWORD_URL();

    @Key("CHANGE_AVATAR_URL")
    String CHANGE_AVATAR_URL();

    @Key("USER_PROFILE_URL")
    String USER_PROFILE_URL();

    @Key("ACCOUNT_DETAIL_URL")
    String ACCOUNT_DETAIL_URL();
}
