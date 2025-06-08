package config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/main/resources/KPTC-smpConfig.properties"})
public interface KPTCSMPTests extends Config {
    @Key("LOGIN_ADMIN")
    String LOGIN_ADMIN();

    @Key("PASSWORD_ADMIN")
    String PASSWORD_ADMIN();

    @Key("LOGIN_USER")
    String LOGIN_USER();

    @Key("PASSWORD_USER")
    String PASSWORD_USER();

    @Key("MAIL_USER")
    String MAIL_USER();

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

    @Key("JPEGPATH")
    String JPEGPATH();

    @Key("SVGPATH")
    String SVGPATH();

    @Key("GIFPATH")
    String GIFPATH();

    @Key("NEWS_NAME")
    String NEWS_NAME();

    @Key("NEWS_NAME_MAX")
    String NEWS_NAME_MAX();

    @Key("NEWS_CONTENT")
    String NEWS_CONTENT();

    @Key("NEWS_CONTENT_MAX")
    String NEWS_CONTENT_MAX();

    @Key("LOGIN_URL")
    String LOGIN_URL();

    @Key("NEWS_URL")
    String NEWS_URL();

    @Key("NEWS_WITH_ID_URL")
    String NEWS_WITH_ID_URL();

    @Key("NEWS_PAGE_URL")
    String NEWS_PAGE_URL();

    @Key("GUILD_ORDERS_URL")
    String GUILD_ORDERS_URL();

    @Key("GUILD_ID_URL")
    String GUILD_ID_URL();

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

    @Key("MAIN_PAGE_URL")
    String MAIN_PAGE_URL();

    @Key("GUILD_CONTENT_MAX")
    String GUILD_CONTENT_MAX();

    @Key("GUILD_NAME_MAX")
    String GUILD_NAME_MAX();

    @Key("GUILD_PSEYDONIM_MAX")
    String GUILD_PSEYDONIM_MAX();
}
