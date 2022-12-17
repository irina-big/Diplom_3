package pageobjects;

import org.openqa.selenium.By;

public class AllLocators {
    public static final String BASE_URL  = "https://stellarburgers.nomoreparties.site/";
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String REGISTER_URL  = "https://stellarburgers.nomoreparties.site/register";
    public static final By BUTTON_LOGIN = By.xpath(".//button[text() = 'Войти']");
    public static final By LINK_LOGIN = By.xpath("//p/a[text() = 'Войти']");
    public static final By BUTTON_LOGIN_ACCOUNT = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By BUTTON_REGISTRATION = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By BUTTON_ACCOUNT = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
    public static final By BUTTON_LOGOUT = By.xpath(".//button[text()='Выход']");
    public static final By BUTTON_CONSTRUCTOR = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
    public static final By TAB_FILLINGS = By.xpath(".//span[text() = 'Начинки']");
    public static final By TAB_SAUSES = By.xpath(".//span[text() = 'Соусы']");
    public static final By TAB_BUNS = By.xpath(".//span[text() = 'Булки']");
    public static final By TAB_SELECT = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");
    public static final By LINK_PASSWORD_RECOVERY = By.xpath("//a[text() = 'Восстановить пароль']");
    public static final By STELLAR_BURGERS_LOGO = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");
    public static final By FIELD_EMAIL_REGISTR    = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    public static final By FIELD_EMAIL_LOGIN    = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    public static final By FIELD_PASSWORD_REGISTR = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/div/input");
    public static final By FIELD_PASSWORD_LOGIN = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    public static final By FIELD_NAME     = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    public static final By HEADER_LOGIN = By.xpath(".//h2[text()='Вход']");
    public static final By INCORRECT_PASSWORD = By.xpath("//p[@class = 'input__error text_type_main-default' and text()='Некорректный пароль'] ");
    public static final By HEADER_PROFILE = By.xpath("//ul[@class = 'Account_list__3KQQf mb-20']/li[1]");
}
