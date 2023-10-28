
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

    @BeforeAll
    static void beforeAll() {
         Configuration.browserSize = "1920x1080";
         Configuration.baseUrl = "https://demoqa.com";
         Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void TableTestTrue() {

        open("/automation-practice-form");
        $("#firstName").setValue("Dmitrii");
        $("#lastName").setValue("Elizarov");
        $("#userEmail").setValue("airplay1x6@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8888888888");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byValue("1999")).click();
        $(".react-datepicker__month-select").selectOption("December");
        $("[aria-label='Choose Wednesday, December 29th, 1999']").click();
        $("#subjectsInput").val("Computer Science").pressEnter();
        $("#subjectsInput").val("English").pressEnter();
        $("#subjectsInput").val("Physics").pressEnter();
        $("#subjectsInput").val("Arts").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/picture/testimage.png"));
        $("#currentAddress").setValue("Valentine 15 str.");
        $("#react-select-3-input").val("Rajasthan").pressEnter();
        $("#react-select-4-input").val("Jaiselmer").pressEnter();
        $("#submit").pressEnter();

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







