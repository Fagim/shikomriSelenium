package com.bellintegrator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    /**
     * Объект WebDriver, представляющий браузер Chrome
     */
    protected WebDriver chromeDriver;

    /**
     * Метод открывает бразуер и устанавливет для него свойства перед каждым тестом
     */
    @BeforeEach
    public void before() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

//        chromeDriver = new ChromeDriver(options);
        chromeDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    /**
     * Метод закрывает браузер после завершения тестов
     */
    @AfterEach
    public void closeYandexTest() {
        chromeDriver.quit();
    }
}
