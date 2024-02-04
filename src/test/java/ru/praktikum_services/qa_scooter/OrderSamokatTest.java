package ru.praktikum_services.qa_scooter;

import Fragment.FragmentFirstOrderPage;
import Fragment.FragmentMainPage;
import Fragment.FragmentSecondOrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum_services.qa_scooter.BaseTest;

@RunWith(Parameterized.class)
public class OrderSamokatTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String adress;
    private final String phoneNumber;
    private final String comment;

    public OrderSamokatTest(String name, String surname, String adress, String phoneNumber, String comment) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Савелий", "Сидоркин", "Невский проспект", "89952106370", "Тестовый комментарий"},
                {"Андрей", "Акимочкин", "Ленинградский проспект", "+79999999999", "Текстовый комментарий"},

        };
    }

    @Test
    public void CheckOrder() {
        FragmentMainPage mainPage = new FragmentMainPage(driver);
        mainPage.clickFirstOrderButton();
        mainPage.backToMainPage();
        mainPage.scrollToSecondOrderButton();
        mainPage.clickSecondOrderButton();
        FragmentFirstOrderPage firstPage = new FragmentFirstOrderPage(driver);
        firstPage.name(name);
        firstPage.surname(surname);
        firstPage.adress(adress);
        firstPage.chooseMetroStation();
        firstPage.textNumber(phoneNumber);
        firstPage.clickNextButton();

        FragmentSecondOrderPage secondPage = new FragmentSecondOrderPage(driver);
        secondPage.clickArrivingTimeField();
        secondPage.chooseArrivingTime();
        secondPage.clickRentalField();
        secondPage.chooseRentalPeriod();
        secondPage.chooseSamokatColor();
        secondPage.writeComment(comment);
        secondPage.clickOrderButton();
        secondPage.clickApproveButton();
        secondPage.checkOrderPlacedText();
    }
}



