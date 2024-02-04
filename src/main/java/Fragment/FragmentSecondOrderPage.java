package Fragment;

import Page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FragmentSecondOrderPage extends BasePage {

    private final By samokatArrivingTime = By.className("react-datepicker__input-container");//поле когда привезти самокат
    private final By orderDate = By.xpath(".//div[@aria-label='Choose воскресенье, 4-е февраля 2024 г.']");//календарь выбора даты заказа самоката
    private final By rentalPeriodField = By.className("Dropdown-root");//поле срока аренды
    private final By rentalTime = By.xpath(".//div[@class='Dropdown-option' and text()='четверо суток']");//кнопка выбора срока аренды
    private final By blackSamokat = By.xpath(".//label[@for='black']");//чекбокс черный самокат
    private final By greySamokat = By.xpath(".//label[@for='grey']");//чекбокс серый самокат
    private final By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");//поле ввода комментария для курьера
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");//кнопка закзать
    private final By approveButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");//кнопка подтверждения на модальном окне
    private final By orderPlaced = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(),'Заказ оформлен')]");//заголовок модального окна

    public FragmentSecondOrderPage(WebDriver driver) {
        super(driver);
    }

    //клик в поле выбора даты заказа
    public void clickArrivingTimeField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Про аренду']")));
        driver.findElement(samokatArrivingTime).click();
    }

    //клик в календаре
    public void chooseArrivingTime() {
        driver.findElement(orderDate).click();
    }

    //клик в поле срока аренды
    public void clickRentalField() {
        driver.findElement(rentalPeriodField).click();
    }

    //клик в drop-down меню выбора срока аренды
    public void chooseRentalPeriod() {
        driver.findElement(rentalTime).click();
    }

    //клик по чекбоксу цвета самоката
    public void chooseSamokatColor() {
        driver.findElement(blackSamokat).click();
        driver.findElement(greySamokat).click();
    }

    //ввод комментария для курьера
    public void writeComment(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    //клик по кнопке заказать
    public void clickOrderButton() {

        driver.findElement(orderButton).click();
    }

    //клик по кнопке подтверждения заказа в модальном окне
    public void clickApproveButton() {
        driver.findElement(approveButton).click();
    }

    //проверка текста в заголовке модального окна
    public void checkOrderPlacedText() {
        driver.findElement(orderPlaced).isDisplayed();
    }
}
