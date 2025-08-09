import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ExcursionsPage;
import io.qameta.allure.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Epic("Бронирование экскурсий")
@Feature("Авторизация в корзину")
public class LoginInBag {

    @Test
    @Story("Бронирование экскурсий с авторизацией в корзине")
    @Owner("Pavel Yatmanov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Бронирование экскурсий с авторизацией в корзине")
    void ExcursionsBronLoginInBag() {

        // Подтягиваем правильный ChromeDriver под Chrome на CI
        WebDriverManager.chromedriver().setup();

        // Конфигурация Selenide
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;

        // Если тест бежит на CI — работаем в headless
        if (System.getenv("CI") != null) {
            Configuration.headless = true;
        }

        // Открытие страницы
        Selenide.open("https://fstravel.com/searchexcursions");

        ExcursionsPage excursionsPage = new ExcursionsPage();

        excursionsPage.searchExcursions();
        Selenide.sleep(5000);
        excursionsPage.datesExcursions();
        excursionsPage.excursionsCards();
        excursionsPage.closingBanner();
        Selenide.sleep(2000);
        excursionsPage.closingBanner();
        excursionsPage.calendarDates();
        excursionsPage.closingBanner();
        Selenide.sleep(1000);
        excursionsPage.closingBanner();
        excursionsPage.addToBag();
        Selenide.sleep(10000);
        Selenide.switchTo().window(1);
        excursionsPage.closingBanner();
        Selenide.sleep(3000);
        excursionsPage.closingBanner();
        excursionsPage.authInBag();
        Selenide.sleep(1000);
        excursionsPage.addToristinfo();
        excursionsPage.booking();
        Selenide.sleep(10000);
        excursionsPage.telegramSend();
    }

    @Attachment(value = "{name}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
