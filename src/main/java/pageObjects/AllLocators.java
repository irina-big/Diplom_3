package pageObjects;

import org.openqa.selenium.By;

public class AllLocators {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final By BUTTON_LOGIN = By.xpath(".//button[text() = 'Войти']");
    public static final By BUTTON_LOGIN_ACCOUNT = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By BUTTON_REGISTRATION = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By BUTTON_ACCOUNT = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
    public static final By BUTTON_LOGOUT = By.xpath(".//button[text()='Выход']");
    public static final By BUTTON_CREATE_ORDER = By.xpath(".//button[text()='Оформить заказ']");
    public static final By BUTTON_CONSTRUCTOR = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
    public static final By BUTTON_LIST_ORDERS  = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Лента Заказов']");
    public static final By LINK_FILLINGS = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Начинки']");
    public static final By LINK_SAUSES = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Соусы']");
    public static final By LINK_BUNS = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Булки']");
    public static final By LINK_REGISTRATION = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Зарегистрироваться']");
    public static final By STELLAR_BURGERS_LOGO = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");
    public static final By FIELD_EMAIL = By.xpath(".//input[@name = 'name']");
    public static final By FIELD_PASSWORD = By.xpath(".//input[@name = 'Пароль']");

}
