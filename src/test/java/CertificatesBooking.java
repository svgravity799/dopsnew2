import com.codeborne.selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ExcursionsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;
import io.qameta.allure.*;

import static com.codeborne.selenide.Selectors.byText;




public class CertificatesBooking {
    @Test
    public void certificatesBooking() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        open("https://fstravel.com/certificates");

        $("div#price-select").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        $(byText("7000 ₽")).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

        SelenideElement senderName = $$("h3").findBy(text("Ваши данные"))  // ищем заголовок блока
                .closest("div")                                                     // поднимаемся к контейнеру
                .$("input[name='name']")
                .setValue("Автотест");



    }
}
