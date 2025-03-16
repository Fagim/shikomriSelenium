package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AnimePage extends ShikimoriHomePage {

    public AnimePage(WebDriver chromeDriver) {
        super(chromeDriver);
    }

    /**
     * Инициализация блока Онгоинг
     */
    @FindBy(how = How.XPATH, using = "//div[@class='subheadline linkheadline']")
    WebElement ongoingBtn;

    /**
     * Инициализация Описания страницы
     */
    @FindBy(how = How.XPATH, using = "//div[@class='notice']")
    WebElement descriptionPage;

    /**
     * Инициализация Фильтра по статусу выхода
     */
    @FindBy(how = How.XPATH, using = "//ul[@class='b-block_list statuses anime-params']//li[@data-value='ongoing']//input[@type='checkbox']")
    WebElement ongoingCheckBox;


    public void clickOngoing() {
        wait.until(ExpectedConditions.elementToBeClickable(ongoingBtn));
        ongoingBtn.click();
    }

    public String getOngoingPage() {
        wait.until(ExpectedConditions.visibilityOf(descriptionPage));
        return descriptionPage.getText();
    }

    public boolean checkboxOngoing() {
        wait.until(ExpectedConditions.elementToBeClickable(ongoingCheckBox));
        return ongoingCheckBox.isSelected();
    }


}
