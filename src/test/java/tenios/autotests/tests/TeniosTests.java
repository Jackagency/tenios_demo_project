package tenios.autotests.tests;

import com.codeborne.selenide.Condition;
import tenios.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class TeniosTests extends TestBase {
    @Test
    @Description("Search test with different values")
    @DisplayName("Search test with 'Routing' value")
    void searchTestRouting() {
        step("Open https://www.tenios.de/", () -> {
            open("https://www.tenios.de/");
        });

        step("Click 'Kontakt'", () -> {
            $("#menu-item-1843").hover();
        });

        step("Click 'Hilfeseiten'", () -> {
            $("#menu-item-7932").click();
        });

        step("Set 'Routing' in the search field", () -> {
            $(".kb-search__input").setValue("Routing").pressEnter();
        });

        step("Check search Results", () -> {
            $(".mkb-entry-header").shouldHave(Condition.text("Routing"));
        });
    }

    @Test
    @Description("Search test with different values")
    @DisplayName("Search test with 'API' value")
    void searchTestApi() {
        step("Open https://www.tenios.de/", () -> {
            open("https://www.tenios.de/");
        });

        step("Click 'Kontakt'", () -> {
            $("#menu-item-1843").hover();
        });

        step("Click 'Hilfeseiten'", () -> {
            $("#menu-item-7932").click();
        });

        step("Set 'API' in the search field", () -> {
            $(".kb-search__input").setValue("API").pressEnter();
        });

        step("Check search Results", () -> {
            $(".mkb-entry-header").shouldHave(Condition.text("API"));
        });
    }

    @Test
    @Description("Search test with different values")
    @DisplayName("Search test with 'SMS' value")
    void searchTestSms() {
        step("Open https://www.tenios.de/", () -> {
            open("https://www.tenios.de/");
        });

        step("Click 'Kontakt'", () -> {
            $("#menu-item-1843").hover();
        });

        step("Click 'Hilfeseiten'", () -> {
            $("#menu-item-7932").click();
        });

        step("Set 'SMS' in the search field", () -> {
            $(".kb-search__input").setValue("SMS").pressEnter();
        });

        step("Check search Results", () -> {
            $(".mkb-entry-header").shouldHave(Condition.text("SMS"));
        });
    }

    @Test
    @Description("Page titles checks")
    @DisplayName("Voice API title check")
    void titleTestsVoice() {
        step("Open https://www.tenios.de/", () -> {
            open("https://www.tenios.de/");
        });

        step("Click 'Voice API'", () -> {
            $("#menu-item-1616").click();
        });

        step("Check the title", () -> {
            $(".kl-slideshow-safepadding").shouldHave(Condition.text("TENIOS Voice-API"));
        });
    }

    @Test
    @Description("Page titles checks")
    @DisplayName("SMS API title check")
    void titleTestsSms() {
        step("Open https://www.tenios.de/", () -> {
            open("https://www.tenios.de/");
        });

        step("Click 'SMS API'", () -> {
            $("#menu-item-27555").click();
        });

        step("Check the title", () -> {
            $(".static-content").shouldHave(Condition.text("SMS senden &\n" + "empfangen via API\n" + "mit der SMS-API von TENIOS"));
        });
    }

    @Test
    @Description("Page titles checks")
    @DisplayName("Telefonie title check")
    void titleTestsTelefonie() {
        step("Open https://www.tenios.de/", () -> {
            open("https://www.tenios.de/");
        });

        step("Click 'Telefonie'", () -> {
            $("#menu-item-1656").click();
        });

        step("Check the title", () -> {
            $(".static-content__title").shouldHave(Condition.text("0800-Nummern"));
        });
    }

    @Test
    @Description("Page titles checks")
    @DisplayName("Unternehmen title check")
    void titleTestsUnternehmen() {
        step("Open https://www.tenios.de/", () -> {
            open("https://www.tenios.de/");
        });

        step("Click 'Unternehmen'", () -> {
            $("#menu-item-1617").click();
        });

        step("Check the title", () -> {
            $(".static-content__title").shouldHave(Condition.text("Wer wir sind"));
        });
    }

    @Test
    @Description("Search test with different values")
    @DisplayName("Search test with 'Voice' value")
    void searchTestVoice() {
        step("Open https://www.tenios.de/", () -> {
            open("https://www.tenios.de/");
        });

        step("Click 'Kontakt'", () -> {
            $("#menu-item-1843").hover();
        });

        step("Click 'Hilfeseiten'", () -> {
            $("#menu-item-7932").click();
        });

        step("Set 'Voice' in the search field", () -> {
            $(".kb-search__input").setValue("Voice").pressEnter();
        });

        step("Check search Results", () -> {
            $(".mkb-entry-header").shouldHave(Condition.text("Voice"));
        });
    }

    @Test
    @Description("Page title test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.tenios.de/'", () ->
            open("https://www.tenios.de/"));

        step("Page title should have text 'TENIOS | 0800 & Geo-Rufnummern, IVR, Voice-API, Sprachbots, ACD'", () -> {
            String expectedTitle = "TENIOS | 0800 & Geo-Rufnummern, IVR, Voice-API, Sprachbots, ACD";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Page console test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.tenios.de/'", () ->
            open("https://www.tenios.de/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}