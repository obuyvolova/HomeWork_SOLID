package com.company;

import com.company.products.Dishwasher;
import com.company.products.Fridge;
import com.company.products.Product;
import com.company.shoppingcart.ShoppingCart;
import com.company.shopwindow.ShopWindow;

import java.util.Scanner;

public class Main {

    public static ShopWindow shopWindow = new ShopWindow();
    public static Scanner sc = new Scanner(System.in);
    public static ShoppingCart shoppingCart = new ShoppingCart();

    public static void main(String[] args) throws InterruptedException {
        //создаем магазин с товарами
        shopInit(shopWindow);

        //отправляемся за покупками
        welcomeToShop();
    }

    //стартовая страница магазина
    private static void welcomeToShop() throws InterruptedException {
        System.out.println("Добрый день! Мы приветствуем Вас в нашем магазине!");
        System.out.println("""
                1 - начать покупки
                2 - покинуть магазин
                3 - оформить возврат товара""");
        int input = sc.nextInt();

        switch (input) {
            case 1 -> shopMenu();
            case 2 -> System.out.println("Мы будем рады видеть Вас снова!");
            case 3 ->
                System.out.println("Раздел находится в разработке. " +
                        "Для возврата товара необходимо связаться с магазином по телефону 8(499)777-77-77" +
                        "\n До новых встреч!");

            default -> {
                System.out.println("Вы ввели некорректное значение!\n");
                welcomeToShop();
            }
        }
    }

    //главное меню магазина
    private static void shopMenu() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Выберите дальнейшее действие:
                    0 - вернуться в предыдущее меню
                    1 - показать все товары
                    2 - перейти в раздел с посудомоечными машинами
                    3 - перейти в раздел с холодильниками
                    4 - покинуть магазин""");
            int input = sc.nextInt();
            switch (input) {
                case 0 -> flag = false;
                case 1 -> shopWindow.printAllItems();
                case 2 -> dishwashersShop();
                case 3 -> fridgesShop();
                case 4 -> {
                    System.out.println("Мы будем рады видеть Вас снова!");
                    flag = false;
                }
                default -> {
                    System.out.println("Вы ввели некорректное значение!\n");
                    shopMenu();
                }
            }
        }
    }

    //раздел с посудомоечными машинами
    private static void dishwashersShop() throws InterruptedException {
        boolean flag = true;
        System.out.println("На сегодняшний день в нашем магазине представлены следующие посудомоечные машины: ");
        shopWindow.printDishwasherList();
        while (flag) {
            System.out.println("""

                    Выберите дальнейшее действие:
                    0 - вернуться в предыдущее меню
                    1 - отсортировать посудомоечные машины по рейтингу
                    2 - отсортировать посудомоечные машины по цене
                    3 - добавить товар в корзину
                    4 - удалить товар из корзины
                    5 - перейти в корзину""");
            int input = sc.nextInt();

            switch (input) {
                case 0 -> flag = false;
                case 1 -> {
                    shopWindow.sortByRating();
                    shopWindow.printDishwasherList();
                }
                case 2 -> {
                    shopWindow.sortByPrice();
                    shopWindow.printDishwasherList();
                }
                case 3 -> {
                    addItem();
                }
                case 4 -> {
                    removeItem();
                }
                case 5 -> cart();
                default -> {
                    System.out.println("Вы ввели некорректное значение!\n");
                    dishwashersShop();
                }
            }
        }

    }

    //корзина
    private static void cart() throws InterruptedException {
        System.out.println("~~~Корзина:~~~");
        shoppingCart.printAllItems();
        System.out.println("""
                \nДля продолжения выберите пункт меню:
                0 - оплатить товары в корзине
                1 - показать товары в корзине
                2 - продолжить покупки
                """);
        int input_cart = sc.nextInt();
        switch (input_cart) {
            case 0:
                buyItem();
                break;
            case 1:
                shoppingCart.printAllItems();
            default:
                break;
        }
    }

    //купить товары
    private static void buyItem() throws InterruptedException {
        System.out.println("Введите номер карты (введите 123)");
        int cartNumber = sc.nextInt();
        if (cartNumber == 123) {
            System.out.println("Номер карты принят. Ожидаем оплату от Вашего банка.");
            System.out.print(".");
            Thread.sleep(1_000);
            System.out.print(".");
            Thread.sleep(1_000);
            System.out.println(".");
            Thread.sleep(1_000);
            System.out.println("=============> Оплата прошла успешно.");
            System.out.println("Спасибо за покупку. Ваш заказ успешно оплачен. " +
                    "Электронный чек будет отправлен на email.");
            shoppingCart.deleteAllItems();
        } else {
            System.out.println("Вы ввели некорректный номер карты.");
        }
    }

    //удалить товар из корзины
    private static void removeItem() {
        System.out.println("Для удаления товара из корзины, Вам необходимо ввести артикул товара:\n");
        System.out.println("Введите артикул:");
        int article = sc.nextInt();
        shoppingCart.removeItemFromCard(shopWindow.getProductByArticle(article));
        System.out.println("Товар был успешно удален из корзины.");

    }

    //добавить единицу товара в корзину
    public static void addItem() {
        System.out.println("Для добавления товара в корзину, Вам необходимо ввести артикул товара:\n");
        System.out.println("Введите артикул:");
        int article = sc.nextInt();
        shoppingCart.addItemToCard(shopWindow.getProductByArticle(article));
        System.out.println("Товар был успешно добавлен в корзину");
    }

    //раздел с холодильниками
    private static void fridgesShop() throws InterruptedException {
        boolean flag = true;
        System.out.println("На сегодняшний день в нашем магазине представлены следующие холодильники: ");
        shopWindow.printFridgeList();
        while (flag) {
            System.out.println("""
                    \nВыберите дальнейшее действие:
                    0 - вернуться в предыдущее меню
                    1 - отсортировать холодильники по рейтингу
                    2 - отсортировать холодильники по цене
                    3 - добавить товар в корзину
                    4 - удалить товар из корзины
                    5 - перейти в корзину""");

            int input = sc.nextInt();
            switch (input) {
                case 0 -> flag = false;
                case 1 -> {
                    shopWindow.sortByRating();
                    shopWindow.printFridgeList();
                }
                case 2 -> {
                    shopWindow.sortByPrice();
                    shopWindow.printFridgeList();
                }
                case 3 -> {
                    addItem();
                }
                case 4 -> {
                    removeItem();
                }
                case 5 -> cart();
                default -> {
                    System.out.println("Вы ввели некорректное значение!\n");
                    fridgesShop();
                }
            }
        }
    }

    //заполняем склад магазина товарами
    public static void shopInit(ShopWindow shopWindow) {
        Product dishwasher = new Dishwasher("Bosch", 55000, 4.7, 121,
                "white", 60);
        Product dishwasher1 = new Dishwasher("Gorenje", 49000, 4.9, 122,
                "white", 45);
        Product dishwasher2 = new Dishwasher("Siemens", 65200, 4.9, 123,
                "white", 60);
        Product dishwasher3 = new Dishwasher("Haier", 45900, 4.8, 124,
                "white", 45);
        Product dishwasher4 = new Dishwasher("Hansa", 35000, 4.2, 125,
                "white", 45);


        Product fridge = new Fridge("Холодильник Bosch", 80000, 4.9, 221,
                "white", "да");
        Product fridge1 = new Fridge("Холодильник Gorenje", 65000, 4.7, 222,
                "white", "нет");
        Product fridge2 = new Fridge("Холодильник Siemens", 90000, 4.2, 223,
                "white", "да");
        Product fridge3 = new Fridge("Холодильник Haier", 115000, 5.0, 224,
                "white", "нет");
        Product fridge4 = new Fridge("Холодильник Hansa", 67000, 4.5, 225,
                "white", "да");

        shopWindow.addProduct(dishwasher);
        shopWindow.addProduct(fridge);
        shopWindow.addProduct(dishwasher1);
        shopWindow.addProduct(fridge1);
        shopWindow.addProduct(dishwasher2);

        shopWindow.addProduct(fridge2);
        shopWindow.addProduct(dishwasher3);
        shopWindow.addProduct(fridge3);
        shopWindow.addProduct(dishwasher4);
        shopWindow.addProduct(fridge4);
    }

}
