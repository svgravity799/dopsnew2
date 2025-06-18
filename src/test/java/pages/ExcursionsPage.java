package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ExcursionsPage {



    public void  searchExcursions () {
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
    }



    public void excursionsCards () {
        ElementsCollection cards_of_vidacha = $$("div.excursion-card__content").shouldHave(CollectionCondition.sizeGreaterThan(1));  // Ждём, пока появятся карточки
        cards_of_vidacha.get(1).$("button").click();

    }



    public void closingBanner () {
        if ($$("div.popmechanic-close").size() > 0) {
            $("div.popmechanic-close").click();
        }
    }



    public void calendarDates () {
            $("div[data-v-26c18107].calendar__field-dates").click();
            $$("[data-v-26c18107].calendar-popup__text").findBy(Condition.text("9")).click();
        }



    public void addToBag () {
        $("button[class=excursion-modal-main__buttons-btn]").shouldHave(Condition.visible).click();
    }



    public void authInBag() {
        $("div[data-v-17ed79cc].v-btn-yellow").click();
        $("[type=email]").setValue("testfsJavaTest@yandex.ru"); // Вводим логин
        $("[type=password]").setValue("Abonent13!");
        $("[type=submit]").click();
}


public void addToristinfo () {
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


}