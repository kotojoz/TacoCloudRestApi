package com.home.tacocloud.pages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageBrowserTest {

    @LocalServerPort
    private int port;
    private static HtmlUnitDriver browser;

    @BeforeAll
    public static void setUp() {
        browser = new HtmlUnitDriver();

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
   public static void tearDown() {
        browser.quit();
    }

    @Test
    public void testHomePage() {
        String homePage = "http://localhost:" + port;
        browser.get(homePage);

        String titleText = browser.getTitle();
        Assertions.assertEquals("Taco Cloud", titleText);

        String h1Text = browser.findElementByTagName("h1").getText();
        Assertions.assertEquals("Welcome to...", h1Text);

        String imgSrc = browser.findElementByTagName("img").getAttribute("src");
        Assertions.assertEquals(homePage + "/images/TacoCloud.png", imgSrc);
    }
}
