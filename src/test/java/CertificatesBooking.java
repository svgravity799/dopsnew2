import com.codeborne.selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ExcursionsPage;

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



    }
}
