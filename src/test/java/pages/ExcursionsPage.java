package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ExcursionsPage {

    public void searchExcursions() {
        $(By.name("search"))
                .shouldBe(Condition.visible)
                .setValue("Турция")
                .pressEnter();
    }

    public void excursionsCards() {
        $$(".excursion-card")
                .first()
                .shouldBe(Condition.visible)
                .click();
    }

    public void closingBanner() {
        if ($(".banner-close").is(Condition.visible)) {
            $(".banner-close").click();
        }
    }

    public void calendarDates() {
        $(By.xpath("//button[contains(text(),'Выбрать дату')]"))
                .shouldBe(Condition.visible)
                .click();
        $$(".date-picker-day").first().click();
    }

    public void addToBag() {
        $(By.xpath("//button[contains(text(),'В корзину')]"))
                .shouldBe(Condition.visible)
                .click();
    }

    public void authInBag() {
        $(By.name("email")).shouldBe(Condition.visible).setValue("test@example.com");
        $(By.name("password")).setValue("password");
        $(By.xpath("//button[contains(text(),'Войти')]")).click();
    }

    public void addTouristInfo() {
        $(By.name("firstName")).shouldBe(Condition.visible).setValue("Иван");
        $(By.name("lastName")).setValue("Иванов");
        $(By.xpath("//button[contains(text(),'Продолжить')]")).click();
    }
}
