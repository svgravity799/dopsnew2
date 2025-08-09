import com.codeborne.selenide.*;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ExcursionsPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginInBag {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = true; // для GitHub Actions
        Configuration.timeout = 8000;
    }

    @Test
    @DisplayName("Бронирование экскурсии с авторизацией в корзине")
    void excursionsBookingLoginInBag() {
        open("https://fstravel.com/searchexcursions");

        ExcursionsPage excursionsPage = new ExcursionsPage();

        excursionsPage.searchExcursions();
        excursionsPage.excursionsCards();
        excursionsPage.closingBanner();

        excursionsPage.calendarDates();
        excursionsPage.closingBanner();

        excursionsPage.addToBag();

        switchTo().window(1);
        excursionsPage.closingBanner();

        excursionsPage.authInBag();
        excursionsPage.addTouristInfo();
    }

    @AfterEach
    void afterTest() {
        attachScreenshot("Скриншот после теста");
    }

    @Attachment(value = "{name}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
