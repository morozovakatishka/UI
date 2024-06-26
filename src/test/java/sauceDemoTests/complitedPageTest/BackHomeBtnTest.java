package sauceDemoTests.complitedPageTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on 'Back home' button on the completed page")
public class BackHomeBtnTest extends BaseTest {

    @DisplayName("Check 'Back home' button on the completed page")
    @Test
    public void checkClickOnBackHomeBtn() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("Pasha", "Morev", "45646")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnFinishBtnCompletePage()
                .checkStaticElemsOnCheckoutCompletePage()
                .clickOnBackHomePage();
    }
}
