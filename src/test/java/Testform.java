import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.io.File;


public class Testform {

    @Test
    void SuccessFieldTextBox(){

                //"открываем сайт https://demoqa.com/automation-practice-form
        open ("https://demoqa.com/automation-practice-form");

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

        //$("#subjectsContainer").click();
        $("#subjectsContainer").setValue("Chemistry").pressEnter();



        //$("#subjectsInput").setValue("Physics").pressEnter(); //, "Chemistry"
        //$("#subjectsContainer").setValue("Arts").pressEnter();
        //$("[id=\"subjectsContainer\"]").setValue("Physics").pressEnter();
        //subjects-auto-complete__control css-yk16xz-control
        //$("#subjects-auto-complete__control css-yk16xz-control").setValue("Arts").pressEnter();
        sleep(10000);


        //$("[id=])
       // $("[id=dateOfBirth]").setValue("17 12 1990");



    }
}



