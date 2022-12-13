package pageobjects;

import org.openqa.selenium.By;

public class PageConstructor {

    private final By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");
    private final By buttonConstructor = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
    private final By buttonListOrders  = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Лента Заказов']");
    private final By linkFillings = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Начинки']");
    private final By linkSauces = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Соусы']");
    private final By linkBuns = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Булки']");


}
