package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Screenshots;
import pages.TelegramBotSender;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ExcursionsPage {


    @Step("Поиск выполнен")
    public void searchExcursions() {
        $("div[class=v-departure__pinput]").shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        $$("[data-v-7cc930c8].v-departure__elem").findBy(Condition.text("Турция")).click();
        sleep(1000);
        $("[data-v-08a2bd6c].calendar__field-title").click();
        $("[class=calendar-popup__arrow-right]").click();
        $("[class=calendar-popup__arrow-right]").click();
        $("[class=calendar-popup__arrow-right]").click();
        $("[class=calendar-popup__arrow-right]").click();
        $(byText("2")).click();
        $(byText("10")).click();
        $("[data-v-4fdad086].v-tourists__pinput").click();
        $("[data-v-4fdad086].v-icon-minus_square").click();
        $("button.v-search-button").click();
        attachScreenshot("Поиск");

    }


    @Step("Картока из выдачи открыта")
    public void excursionsCards() {
        ElementsCollection cards_of_vidacha = $$("div.excursion-card__content").shouldHave(CollectionCondition.sizeGreaterThan(1));  // Ждём, пока появятся карточки
        cards_of_vidacha.get(1).$("button").click();

    }


    public void closingBanner() {
        if ($$("div.popmechanic-close").size() > 0) {
            $("div.popmechanic-close").click();
        }
    }


    @Step("Даты экскурсии выбраны в календаре")
    public void calendarDates() {
        $("div[data-v-26c18107].calendar__field-dates").shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
        $$("[data-v-26c18107].calendar-popup__text").findBy(Condition.text("9")).shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
    }


    @Step("Добавление в корзину выполнено")
    public void addToBag() {
        $("button[class=excursion-modal-main__buttons-btn]").shouldHave(Condition.visible).click();
    }


    @Step("Авторизация в корзине выполнена")
    public void authInBag() {
        $("div.v-btn-yellow").shouldHave(Condition.text("Войти или зарегистрироваться")).click();
        $("[type=email]").setValue("testfsJavaTest@yandex.ru"); // Вводим логин
        $("[type=password]").setValue("Abonent13!");
        $("[type=submit]").click();
    }

    @Step("Данные о туристах заполнены")
    public void addToristinfo() {
        $("input[id=place][name=place]").shouldBe(Condition.visible).setValue("Автотесты улица");
        sleep(1000);
        $("#lastName").shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("АвтоИванов");
        sleep(1000);
        $("#firstName").shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("АвтоСергей");
        sleep(1000);
        $("#middleName").shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("АвтоИванович");
        sleep(1000);
        $("#lastName").shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("АвтоИванов");
        $(byText("Номер документа")).parent().$("input").setValue("124416");
        $(byText("Cерия документа")).parent().$("input").setValue("1234");

    }


    @Step("Бронирование выполнено")
    public void booking() {
        $("div.theme-yellow-booking")
                .shouldHave(Condition.visible, Duration.ofSeconds(10))
                .click();
    }

    public void telegramSend() {





// Шаг получения номера брони
        String bookingText = $("h4.bookingPay__header-text")
                .shouldBe(Condition.exist, Duration.ofSeconds(20))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .getText();

        String bookingNumber = bookingText.replaceAll("\\D+", "");
        System.out.println("Номер бронирования: " + bookingNumber);

// Готовим текст для Telegram
        String message = """
Бронирование экскурсий выполнено успешно!
1. Параметры поиска выставлены.
2. Карточка экскурсии из выдачи раскрыта.
3. Даты в карточке экскурсии выбраны.
4. Экскурсия добавлена в корзину.
5. Переключение на новую вкладку выполнено.
6. Авторизация в корзине выполнена.
7. Данные о туристах заполнены.
8. Номер бронирования: %s
""".formatted(bookingNumber);

// Снимаем скриншот и отправляем всё вместе
        try {
            File screenshotFile = Screenshots.takeScreenShotAsFile();
            byte[] screenshot = Files.readAllBytes(screenshotFile.toPath());
            TelegramBotSender.sendMessageWithScreenshot(message, screenshot);
        } catch (Exception e) {
            e.printStackTrace(); // на случай ошибок со скриншотом
        }


    }

    @Attachment(value = "{name}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

