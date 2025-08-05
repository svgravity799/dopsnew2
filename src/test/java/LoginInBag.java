import io.qameta.allure.Attachment;





import com.codeborne.selenide.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ExcursionsPage;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;
import io.qameta.allure.*;
import pages.TelegramBotSender;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@Epic("Бронирование экскурсий")
@Feature("Авторизация в корзину")
public class
LoginInBag {
    

    @Test
    @Story("Бронирование экскурсий с авторизацией в корзине")
    @Owner("Pavel Yatmanov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Бронирование экскурсий с авторизацией в корзине")


    void ExcursionsBronLoginInBag () {

        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;




        Selenide.open("https://fstravel.com/searchexcursions");





        ExcursionsPage excursionsPage = new ExcursionsPage();

       // @Step("Параметры поиска выставлены)
        excursionsPage.searchExcursions();

        excursionsPage.excursionsCards();




        excursionsPage.closingBanner();
        sleep(2000);
        excursionsPage.closingBanner();



//@Step("Даты в карточки экскурсии выбраны")
        excursionsPage.calendarDates();

        excursionsPage.closingBanner();

        sleep(1000);

        excursionsPage.closingBanner();

//@Step("Экскурсия добавляется в корзину")
        excursionsPage.addToBag();
        sleep(10000);
//@Step("Переключение на новую вкладку выполнено")
        switchTo().window(1);


        excursionsPage.closingBanner();

        sleep(3000);

        excursionsPage.closingBanner();


      //  System.out.println("Переход в новую вкладку выполнен, экскурсия добавлена в корзину");

      ///  @Step("Авторизация в корзине выполнена")
        excursionsPage.authInBag();

        sleep(1000);


        excursionsPage.addToristinfo();

   /*  excursionsPage.booking();

        sleep(10000);

        excursionsPage.telegramSend();

     */




    }

    @Attachment(value = "{name}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}




