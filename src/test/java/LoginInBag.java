import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import pages.ExcursionsPage;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;


public class LoginInBag {
    @Test
    void ExcursionsBron_LoginInBag () {

        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        Selenide.open("https://fstravel.com/searchexcursions");





        ExcursionsPage excursionsPage = new ExcursionsPage();
        excursionsPage.searchExcursions();
        excursionsPage.excursionsCards();




        excursionsPage.closingBanner();
        sleep(2000);
        excursionsPage.closingBanner();




        excursionsPage.calendarDates();

        excursionsPage.closingBanner();

        sleep(1000);

        excursionsPage.closingBanner();


        excursionsPage.addToBag();
        sleep(10000);

        switchTo().window(1);


        excursionsPage.closingBanner();

        sleep(3000);

        excursionsPage.closingBanner();


        System.out.println("Переход в новую вкладку выполнен, экскурсия добавлена в корзину");

        excursionsPage.authInBag();

        sleep(1000);

        System.out.println("Авторизация в корзине выполнена");


        excursionsPage.addToristinfo();


        System.out.println("Данные о туристах в корзине заполнены");


    }
}




