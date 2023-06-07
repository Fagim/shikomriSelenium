package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShikomoriHomePage {
    WebDriver chromedriver;
    WebDriverWait wait;
    Actions actions;


    /**
     * Конструктор сохраняет переданный объект chromeDriver  и инициализирует переменные actions и wait.
     * @param chromeDriver объект интерфейса WebDriver
     */

    public ShikomoriHomePage(WebDriver chromeDriver) {
        this.chromedriver = chromeDriver;
        this.actions = new Actions(chromeDriver);
        this.wait = new WebDriverWait(chromeDriver, 30);
    }
    /**
     * Инициализация кнопки каталога
     */
    @FindBy(how = How.XPATH, using = "//div[@class='logo']/parent::a")
    WebElement title;

    /**
     * Метод возвращает название тайтла
     */
    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getAttribute("title");
    }

}
