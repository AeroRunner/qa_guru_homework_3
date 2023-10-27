import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormFullTestHomework {

    @BeforeAll // Общие условия для тестов
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {  // Заполнение нужных полей
        open("/automation-practice-form");
        $("#firstName").setValue("Dmitrii");
        $("#lastName").setValue("Elizarov");
        $("#userEmail").setValue("airplay1x6@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("+7 7777777777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byValue("12")).click();
        $(".react-datepicker__year-select").click();
        $(byValue("1999")).click();
        $(".react-datepicker__day--029").click();
        /*$("#currentAddress").setValue("Some street ");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Some name"));
       $("#output #email").shouldHave(text("airplay.com"));
        $("#output #currentAddress").shouldHave(text("Some street "));
        $("#output #permanentAddress").shouldHave(text("Another street "));*/
    }
}







