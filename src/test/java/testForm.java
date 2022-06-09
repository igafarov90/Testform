import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

public class testForm {

    @BeforeAll
    static void beforeAll() {
        //Запускал в firefox, в chrome не пашет, не видит кнопку Submit
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        //Configuration.browserSize = "1920x1080";
    }
    @Test
        void SuccessFieldTextBox(){

                //"открываю сайт
        //open ("https://demoqa.com/automation-practice-form");

                // Заполняю поля Name
        $("[id=firstName]").setValue("ilgiz");
        $("[id=lastName]").setValue("gafarov");

                // Заполняю поле Email
        $("[id=userEmail]").setValue("igafarov90@mail.ru");

                // Устанавливаю radio-button Male
        //$("#gender-radio-1").click(); Почему-то не пашет(
        $(byText("Male")).click();

                // Заполняю поле Mobile(10 Digits)
        $("[id=userNumber]").setValue("9371247471");

                // Заполняю поле Date of Birth
        $("[id=\"dateOfBirthInput\"]").click();
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__month-select").selectOptionByValue("11");
        $(".react-datepicker__day--017").click();

            //Заполняю поле Subjects
      /* $("#subjectsInput").setValue("Chemistry").pressEnter(); // Почему-то не пашет (Element not found {#subjectsInput}),
      хотя  $("#subjectsInput").click() - работает.

      сделал так ...  */
       $("#subjectsInput").sendKeys("Chemistry");
       $("#subjectsInput").pressEnter();

        //Заполняю  Hobbies
        $(byText("Music")).click();
        $(byText("Reading")).click();

            // Заполняю поле Adress
        $("#currentAddress").val("Russia, 46°23'45.0\"N 48°05'49.1\"E");

            //Заполняю State and city
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Delhi").pressEnter();

            //Загружаю пикчу
        File fl = new File("src/test/resources/monkey.png");
        $("#uploadPicture").uploadFile(fl);

                    // Нажимаю Submit
        $("#submit").click();

        sleep(10000);

                // Проверяю, открытие модального окна и заполненность полей
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("[class=\"table-responsive\"]").$("tbody")
                      .shouldHave(text("ilgiz gafarov"),
                text("Student Email"),
                text("igafarov90@mail.ru"),
                text("Gender"),
                text("Male"),
                text("Mobile"),
                text("9371247471"),
                text("Date of Birth"),
                text("17 December,1990"),
                text("Subjects"),
                text("Chemistry"),
                text("Hobbies"),
                text("Music, Reading"),
                text("Picture"),
                text("monkey.png"),
                text("Address"),
                text("Russia, 46°23'45.0\"N 48°05'49.1\"E"),
                text("State and City"),
                text("NCR Delhi")
        );
      }
}



