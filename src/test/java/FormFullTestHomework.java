import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

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
    void fillFormTest() {

        // Заполнение нужных полей анкеты

        open("/automation-practice-form"); // Открытие нужной формы на сайте
        $("#firstName").setValue("Dmitrii"); // Имя
        $("#lastName").setValue("Elizarov"); // Фамилия
        $("#userEmail").setValue("airplay1x6@gmail.com"); // Почта
        $("[for='gender-radio-1']").click(); // Выбор гендера
        $("#userNumber").setValue("8888888888"); // Номер телефона
        $("#dateOfBirthInput").click(); // Клик по блоку с выбором дня рождения
        $(".react-datepicker__year-select").click();  // Выбор года в блоке
        $(byValue("1999")).click();

        //Вариант выбора месяца в списке, но есть проблема с нумерованием - список идет с 0 до 11, где 11 должно быть December.Но есть баг и выбирается November, про это было обсуждение в чате
        // $(".react-datepicker__month-select").click();
        // $(byValue("0")).click();

        $(".react-datepicker__month-select").selectOption("December"); // Другой вариант выбора месяца через options
        $(".react-datepicker__day--029").click(); // Выбор дня в блоке
        // Выбор предметов
        $("#subjectsInput").val("Computer Science").pressEnter(); //
        $("#subjectsInput").val("English").pressEnter();
        $("#subjectsInput").val("Computer Science").pressEnter();
        $("#subjectsInput").val("Machs").pressEnter();
        // Выбор хобби
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/picture/testimage.png"));
        $("#currentAddress").setValue("Some address");
        $("#state").scrollTo().click();
        $("#react-select-3-input").val("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Karnal").pressEnter().pressTab().pressEnter();




       /* $("#currentAddress").setValue("Some street ");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Some name"));
       $("#output #email").shouldHave(text("airplay.com"));
        $("#output #currentAddress").shouldHave(text("Some street "));
        $("#output #permanentAddress").shouldHave(text("Another street "));
        */
    }

}







