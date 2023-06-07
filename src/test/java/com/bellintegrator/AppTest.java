package com.bellintegrator;


import helpers.Properties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ShikomoriHomePage;


public class AppTest extends BaseTest
{
    @Test
    public void shikimoriTestTitle() {
        chromeDriver.get(Properties.testsProperties.shikimoriUrl());

        ShikomoriHomePage shikomoriHomePage = PageFactory.initElements(chromeDriver, ShikomoriHomePage.class);
        shikomoriHomePage.getTitle();
        Assertions.assertEquals("Шикимори", shikomoriHomePage.getTitle(), "Ожидался Шикимори, а пришёл " +
                shikomoriHomePage.getTitle());
    }
}
