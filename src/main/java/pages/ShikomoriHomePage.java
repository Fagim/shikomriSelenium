package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    @FindBy(how = How.XPATH, using = "//div[@class='menu-dropdown main']")
    WebElement catalogBtn;

    /**
     * Метод кликает на кнопку каталога
     */
    public void clickCatalogBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogBtn));
        actions.moveToElement(catalogBtn).pause(Duration.ofSeconds(1)).perform();
    }

    @FindBy(how = How.XPATH, using = "//div[@class='menu-dropdown main active']//div[@class='submenu' and not(@hidden)]/descendant::a")
    List<WebElement> listSubElementCatalog;

    /**
     * Метод кликает получает список элементов каталога
     */
    public List<String> getListCatalog() {
        List<String> catalogElementList = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElements(listSubElementCatalog));
        for (WebElement element: listSubElementCatalog) {
            catalogElementList.add(element.getAttribute("title"));
        }
        return catalogElementList;
    }

    /**
     * Метод возвращает размер каталога
     */
    public int checkSizeCatalog() {
        return getListCatalog().size();
    }

}
