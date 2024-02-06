package Fragment;

import Page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FragmentFirstOrderPage extends BasePage {


    private final By nameField = By.xpath(".//input[@placeholder=\'* Имя\']");
    private final By surnameField = By.xpath(".//input[@placeholder=\'* Фамилия\']");
    private final By adressField = By.xpath(".//input[@placeholder=\'* Адрес: куда привезти заказ\']");
    private final By metroStationField = By.xpath(".//input[@placeholder=\'* Станция метро\']");
    private final By metroStationArray = By.xpath(".//li[@class='select-search__row' and @data-value='1']");
    private final By phoneNumberField = By.xpath(".//input[@placeholder=\'* Телефон: на него позвонит курьер\']");
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public FragmentFirstOrderPage(WebDriver driver) {
        super(driver);

    }


    public void name(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void surname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void adress(String adress) {
        driver.findElement(adressField).sendKeys(adress);
    }

    public void clickMetroStation() {
        driver.findElement(metroStationField).click();
    }

    public void chooseMetroStation() {
        clickMetroStation();
        wait.until(ExpectedConditions.elementToBeClickable(metroStationArray));
        driver.findElement(metroStationArray).click();
    }

    public void textNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
