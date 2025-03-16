package com.bellintegrator;


import helpers.Properties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.AnimePage;
import pages.ShikimoriHomePage;


public class AppTest extends BaseTest
{
    @Test
    @DisplayName("Проверка тайтла страницы")
    public void shikimoriTestTitle() {
        chromeDriver.get(Properties.testsProperties.shikimoriUrl());

        ShikimoriHomePage shikimoriHomePage = PageFactory.initElements(chromeDriver, ShikimoriHomePage.class);
        System.out.println(shikimoriHomePage.getTitle());

        Assertions.assertEquals("Шикимори", shikimoriHomePage.getTitle(), "Ожидался Шикимори, а пришёл " +
                shikimoriHomePage.getTitle());
    }

    @Test
    @DisplayName("Проверка каталога сайта")
    public void shikimoriTestCatalog() {
        chromeDriver.get(Properties.testsProperties.shikimoriUrl());

        ShikimoriHomePage shikimoriHomePage = PageFactory.initElements(chromeDriver, ShikimoriHomePage.class);
        shikimoriHomePage.clickCatalogBtn();
        System.out.println(shikimoriHomePage.getListCatalog());
        Assertions.assertEquals(13, shikimoriHomePage.checkSizeCatalog(), "Ожидалось 14 элементов, а пришло " +
                shikimoriHomePage.checkSizeCatalog());
    }

    @Test
    @DisplayName("Проверка страницы Онгоинга")
    public void shikimoriTestOngoing() {
        chromeDriver.get(Properties.testsProperties.shikimoriUrl());
        AnimePage animePage = PageFactory.initElements(chromeDriver, AnimePage.class);
        animePage.clickOngoing();
        Assertions.assertEquals("На данной странице отображены онгоинги аниме, отсортированные по рейтингу", animePage.getOngoingPage(),
                "Ожидалось, что откроется страница с Онгоинами");
        Assertions.assertTrue(animePage.checkboxOngoing(), "Ожидалось, что чекбокс на странице онгоинга будет включен");
    }
}
