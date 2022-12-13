package pageobjects;

import org.openqa.selenium.By;

public class PageMain {

    //локаторы
    private final By buttonLogin = By.xpath(".//button[text() = 'Войти']");
    private final By buttonAccount = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
    private final By buttonLogout = By.xpath(".//button[text()='Выход']");
    private final By buttonConstructor = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
    private final By buttonListOrders  = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Лента Заказов']");
    private final By linkFillings = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Начинки']");
    private final By linkSauces = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Соусы']");
    private final By linkBuns = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Булки']");
    private final By stellarBurgersLogo = By.xpath("");

    private final By fieldEmail = By.xpath(".//input[@name = 'name']");
    private final By fieldPassword = By.xpath(".//input[@name = 'Пароль']");


}
