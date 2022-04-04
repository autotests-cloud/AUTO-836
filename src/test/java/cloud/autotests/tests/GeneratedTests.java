package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {
    @Test
    @Description("Soon to be implemented by you (or QA.GURU engineers)")
    @DisplayName("Autotest_RSHB")
    void generatedTest() {

        step("- Зайти на сайт rshb.ru", () -> {
            open("https://rshb.ru");
        });

        step("- Кликнуть «Частным лицам»", () -> {
            $(".header__section-navigation").$(byText("Частным лицам")).click();
        });

        step("- Кликнуть «Кредиты»", () -> {
            $(".b-page-head").$(byText("Кредиты")).click();
        });

        step("- Кликнуть «Кредит на любые цели»", () -> {
            //$(".linkip").$(byText("Кредит на любые цели")).click();
            $(".container").$(byText("Кредит на любые цели")).click();
        });

        step("- Закрыть окно cookies", () -> {
            $(".cookie-consent__submit-button").click();
        });

        step("- тип платежа «Аннуитентный»", () -> {
            $(".menu-switch__item").click();
        });

        step("- сумма кредита 2 010 000 р", () -> {
            //$(".slider__input").setValue("2 500 000 ₽");
            //SelenideElement element;
            String attribyteName = "aria-valuenow";
            element = $(".ant-slider-handle");
            String s;   // переменная для хранения значения элемента slider
            s = element.getAttribute(attribyteName);
            System.out.println("Calculation of monthly payment");
            System.out.println(s);
            String s1;  // вспомогательная переменная для расчета
            s1 = determinePositionSlider(s);
            System.out.println(s1);
            int sm;
            sm = Integer.parseInt(s1);
            while (sm != 2010000) {
                if (sm < 2010000) {
                    element.sendKeys(Keys.ARROW_RIGHT);
                    //slider.sendKeys(Keys.ARROW_RIGHT);
                    s = element.getAttribute((attribyteName));
                    s1 = determinePositionSlider(s);
                    sm = Integer.parseInt(s1);
                } else {
                    element.sendKeys(Keys.ARROW_LEFT);
                    s = element.getAttribute((attribyteName));
                    s1 = determinePositionSlider(s);
                    sm = Integer.parseInt(s1);
                }
            }

        });

        step("- Срок кредита 60 м", () -> {
            element = $$("[inputmode='numeric']").get(1);
            element.clear();
            element.sendKeys("60");
        });

        step("- проверить что значение поля 'Предварительный расчет' составляет 55 400 ₽", () -> {
            String t;
            t = $(".loan-calculator-result__value").text();
            System.out.println(t);
            $(".loan-calculator-result__value").shouldHave(text("55 400 ₽"));
        });    
    }
    
    // выберем только цифры из поля убрав символы форматирования
    public String determinePositionSlider(String s) {
        String s1 = "";
        char sT;
        int j = 0, a;
        a = s.length();
        while (j < a) {
            sT = s.charAt(j);
            if (sT == '0' || sT == '1' || sT == '2' || sT == '3' || sT == '4' || sT == '5' || sT == '6' || sT == '7' ||
                    sT == '8' || sT == '9') {
                s1 = s1 + sT;
            }
            j++;
        }
        return s1;
    }
    
}
