import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.nio.channels.Selector.open;


public class loginInBag {
    @Test
    void loginInBag() {

Configuration.browser = "chrome";
Configuration.pageLoadStrategy = "eager";
Configuration.browserSize = "1920x1080";
Configuration.holdBrowserOpen = true;

Selenide.open("https://fstravel.com/searchexcursions");

$("div[class=v-departure__pinput]").click();
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

        //Закрытие всплывающего Попап
        if ($$("div.popmechanic-close").size() > 0) {
            $("div.popmechanic-close").click();
        }


sleep(2000);

        //Закрытие всплывающего Попап
        if ($$("div.popmechanic-close").size() > 0) {
            $("div.popmechanic-close").click();
        }


        ElementsCollection cards_of_vidacha = $$("div.excursion-card__content").shouldHave(CollectionCondition.sizeGreaterThan(1));  // Ждём, пока появятся карточки
cards_of_vidacha.get(1).$("button").click();

$("div[data-v-26c18107].calendar__field-dates").click();
$$("[data-v-26c18107].calendar-popup__text").findBy(Condition.text("9")).click();

        //Закрытие всплывающего Попап
        if ($$("div.popmechanic-close").size() > 0) {
            $("div.popmechanic-close").click();
        }


   sleep(1000);

        //Закрытие всплывающего Попап
        if ($$("div.popmechanic-close").size() > 0) {
            $("div.popmechanic-close").click();
        }


        $("button[class=excursion-modal-main__buttons-btn]").shouldHave(Condition.visible).click();
   //sleep(1000);
sleep(10000);

switchTo().window(1);



//Закрытие всплывающего Попап
        if ($$("div.popmechanic-close").size() > 0) {
            $("div.popmechanic-close").click();
        }





sleep(3000);

        //Закрытие всплывающего Попап
        if ($$("div.popmechanic-close").size() > 0) {
            $("div.popmechanic-close").click();
        }



$("div[data-v-17ed79cc].v-btn-yellow").click();
$("[type=email]").setValue("testfsJavaTest@yandex.ru"); // Вводим логин
$("[type=password]").setValue("Abonent13!");
$("[type=submit]").click();  // Вводим пароль

        sleep(1000);

        $("input[id=place][name=place]").shouldBe(Condition.visible).setValue("Автотесты улица");

        sleep(1000);


        $("#lastName").shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("АвтоИванов");
        sleep(1000);
        $("#firstName").shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("АвтоСергей");
        sleep(1000);
        $("#middleName").shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("АвтоИванович");
        sleep(1000);
        $("#lastName").shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("АвтоИванов");


        $(byText("Номер документа")).parent().$("input").setValue("1244");
        $(byText("Cерия документа")).parent().$("input").setValue("123422");






        // $(byText("Cерия документа")).setValue("5723");


      //  $("input[name='id']").setValue("1234");


        //  $("[data-v-1f43af2e].form__label").shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("25").click();

       // $$("[data-v-1f43af2e].form__field_active").setValue("5235");



      //  $(byText("Серия документа")).shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("5412");


        //  $$("input[name='id']").get(1).setValue("567890"); // выбирает второй input с name="id"


        // $("input[placeholder='Серия документа']").setValue("1234");
     //   $("input[place=holder='Номер документа']").setValue("881177");





        // $("[data-v-1f43af2e.form__label]").setValue("Тест");


      //  $("input[id=lastName][name=lastName]").shouldBe(Condition.visible).setValue("ТестАвтотесты");
     //   $("input[id=lastName][name=firstName]").shouldBe(Condition.visible).setValue("Петров");
    //    $("input[id=lastName][name=middleName]").shouldBe(Condition.visible).setValue("Артем");
      $(byText("Серия документа")).shouldBe(Condition.visible).setValue("22");


    }

}
