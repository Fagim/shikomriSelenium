package com.bellintegrator;

import helpers.Properties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.ShikomoriHomePage;

public class TestCatalog extends BaseTest {
    @Test
    @DisplayName("Проверка каталога сайта")
    public void shikimoriTestCatalog() {
        chromeDriver.get(Properties.testsProperties.shikimoriUrl());

        ShikomoriHomePage shikomoriHomePage = PageFactory.initElements(chromeDriver, ShikomoriHomePage.class);
        shikomoriHomePage.clickCatalogBtn();
        System.out.println(shikomoriHomePage.getListCatalog());
        Assertions.assertEquals(13, shikomoriHomePage.checkSizeCatalog(), "Ожидалось 14 элементов, а пришло " +
                shikomoriHomePage.checkSizeCatalog());
    }
}
