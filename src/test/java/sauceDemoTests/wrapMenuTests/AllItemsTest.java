package sauceDemoTests.wrapMenuTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.SauceDemoMainSteps;

public class AllItemsTest {
    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "problem_user",
            "error_user",
            "performance_glitch_user"})
    public void checkAllItemsBtn(String username) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        Configuration.browserCapabilities = chromeOptions;
        SauceDemoMainSteps.open("https://www.saucedemo.com")
                .checkStaticElements()
                .clickOnUsernameArea()
                .setUsername(username)
                .clickOnPasswordArea()
                .setPassword("secret_sauce")
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnProductPage()
                .clickOnWrapMenu()
                //.checkAllPositionsInWrapMenu()
                .clickOnAllItemsBtn(0)
                .checkURL("https://www.saucedemo.com/inventory.html");
    }
}
