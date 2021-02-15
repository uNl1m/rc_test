package tests.web;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import helper.WebDriverHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeClass
    void initAllureLogger(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = WebDriverHelper.class.getName();
        Configuration.baseUrl = "https://demo.realworld.io";
    }

    @AfterClass
    void stopListener(){
        SelenideLogger.removeListener("allure");
    }
}
