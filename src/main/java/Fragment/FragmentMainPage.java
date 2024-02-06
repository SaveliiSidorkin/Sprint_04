package Fragment;

import Page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FragmentMainPage extends BasePage {
    private final By firstOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");//Кнопка закзать в хедере
    private final By secondOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");//кнопка внизу
    private final By questionButtons = By.className("accordion__item");//блок с вопросами
    private final By questionText = By.className("accordion__button");//тексты вопросов
    private final By answersText = By.className("accordion__panel");//тексты ответов

    public FragmentMainPage(WebDriver driver) {
        super(driver);
    }

    //метод клика по вопросу по индексу
    public void clickQuestionByIndex(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(questionButtons));
        driver.findElements(questionButtons).get(index).click();
    }

    //метод получения текста вопроса по индексу
    public String getQuestionTextByIndex(int index) {
        return driver.findElements(questionText).get(index).getText();
    }

    //метод получения текста ответа по индексу
    public String getAnswerTextByIndex(int index) {
        return driver.findElements(answersText).get(index).getText();
    }

    //метод для клика на первую кнопку заказать
    public void clickFirstOrderButton() {
        driver.findElement(firstOrderButton).click();
    }

    //метод для клика на вторую кнопку заказать
    public void clickSecondOrderButton() {
        driver.findElement(secondOrderButton).click();
    }

    //скролл до второй кнопки заказать
    public void scrollToSecondOrderButton() {
        WebElement element = driver.findElement(secondOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //метод клика на кнопку заказать через параметр
    public void clickOrderButton(String orderButton) {
        switch (orderButton){
            case "firstOrderButton":
                clickFirstOrderButton();
            case "secondOrderButton":
                scrollToSecondOrderButton();
                clickSecondOrderButton();
        }
    }

    //скролл до блока с вопросами
    public void scrollToAnswers() {
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FAQ__3uVm4']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }


}
