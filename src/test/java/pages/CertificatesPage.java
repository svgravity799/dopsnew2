import com.codeborne.selenide.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ExcursionsPage;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;
import io.qameta.allure.*;

import static com.codeborne.selenide.Selectors.byText;


public class CertificatesPage {
    @Test
    public void certificateValue() {

        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        
        open("https://fstravel.com/certificates");
        sleep(3000);
      $("div#price-select").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

      $(byText("7000 ₽")).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();










      //  $("div.v-select_option[data-value='5000']").click();  // Используй значение атрибута для уникальной идентификации






        //  $("div.v-select_option").scrollIntoView(true);

// Ожидаем, что элемент станет видимым и кликаем
      //  $("div.v-select_option")
          //      .shouldBe(Condition.visible)
         //       .shouldHave(Condition.text("5000"))
          //      .click();





     // $("div.v-select_option")
         //     .shouldHave(Condition.visible, Duration.ofSeconds(10))
          //    .shouldHave(Condition.text("5000 ₽")).click();

     // ElementsCollection CertificatesSumma = $$("div.v-select__option").shouldHave(CollectionCondition.sizeGreaterThan(1), Duration.ofSeconds(10));
// CertificatesSumma.get(3).shouldBe(Condition.visible).shouldBe(Condition.enabled).click();


    }
}
