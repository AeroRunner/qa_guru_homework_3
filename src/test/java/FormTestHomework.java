import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class FormTestHomework {

    @BeforeAll   // Общие условия для тестов
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";      //Разрешение
        Configuration.baseUrl = "https://demoqa.com"; //Сайт на котором будут происходить все тесты
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void TableTestTrue() {

        // Заполнение нужных полей анкеты

        open("/automation-practice-form");          // Открытие нужной формы на сайте
        $("#firstName").setValue("Dmitrii");               // Имя
        $("#lastName").setValue("Elizarov");               // Фамилия
        $("#userEmail").setValue("airplay1x6@gmail.com");  // Почта
        $("[for='gender-radio-1']").click();               // Выбор гендера
        $("#userNumber").setValue("8888888888");           // Номер телефона
        $("#dateOfBirthInput").click();                    // Клик по блоку с выбором дня рождения
        $(".react-datepicker__year-select").click();       // Выбор выпадающего списка с годами
        $(byValue("1999")).click();                                   // Выбор значения года
        $(".react-datepicker__month-select").selectOption("December");   // Выбор месяца
        $("[aria-label='Choose Wednesday, December 29th, 1999']").click();    // Выбор дня

        // Выбор предметов
        $("#subjectsInput").val("Computer Science").pressEnter();
        $("#subjectsInput").val("English").pressEnter();
        $("#subjectsInput").val("Physics").pressEnter();
        $("#subjectsInput").val("Arts").pressEnter();

        // Выбор хобби с 1-го по 3-й пункт
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();

        $("#uploadPicture").uploadFile(new File("src/test/picture/testimage.png"));  // Импорт изображения
        $("#currentAddress").setValue("Valentine 15 str.");                                   // Заполнение поля Current Address
        $("#react-select-3-input").val("Rajasthan").pressEnter();                        // Выбор страны
        $("#react-select-4-input").val("Jaiselmer").pressEnter();                        // Выбор города

        // Кнопка Submit закрыта рекламой на сайте и click() по ней невозможен, поэтому можно выбрать ее ID выполнить команду ENTER
        $("#submit").pressEnter();
        // Дальше открывается модальное окно со всеми введенными нами ранее данными

        // Проверка введенных значений в модальном окне Xpath, чтобы соотносить поле и данные в поле (на css пока не умею)
        $x("//td[text()='Student Name']/following::td[text()='Dmitrii Elizarov']").shouldBe(visible);

        $x("//td[text()='Student Email']/following::td[text()='airplay1x6@gmail.com']").shouldBe(visible);

        $x("//td[text()='Gender']/following::td[text()='Male']").shouldBe(visible);

        $x("//td[text()='Mobile']/following::td[text()='8888888888']").shouldBe(visible);

        $x("//td[text()='Date of Birth']/following::td[text()='29 December,1999']").shouldBe(visible);

        $x("//td[text()='Subjects']/following::td[text()='Computer Science, English, Physics, Arts']").shouldBe(visible);

        $x("//td[text()='Hobbies']/following::td[text()='Sports, Reading, Music']").shouldBe(visible);

        $x("//td[text()='Picture']/following::td[text()='testimage.png']").shouldBe(visible);

        $x("//td[text()='Address']/following::td[text()='Valentine 15 str.']").shouldBe(visible);

        $x("//td[text()='State and City']/following::td[text()='Rajasthan Jaiselmer']").shouldBe(visible);


        // Проверка введенных значений в модальном окне CSS
       $(".table-responsive").shouldHave(
                text("Dmitrii Elizarov"),
                text("airplay1x6@gmail.com"),
                text("Male"),
                text("8888888888"),
                text("29 December,1999"),
                text("Computer Science, English, Physics, Arts"),
                text("Sports, Reading, Music"),
                text("testimage.png"),
                text("Valentine 15 str."),
                text("Rajasthan Jaiselmer"));

    }

}







