package sauceDemoTests.loginTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.stepsPackage.LoginPageSteps;

public class LoginStandardOrVisualUserTest {
    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "problem_user",
            "error_user",
            "performance_glitch_user"})
    public void testStandardOrVisualUser(String username) {
        LoginPageSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(username,"secret_sauce")
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnProductPage();
    }
}