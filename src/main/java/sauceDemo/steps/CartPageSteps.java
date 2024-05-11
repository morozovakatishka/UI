package sauceDemo.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.elements.CartPageElements;

import static com.codeborne.selenide.Condition.exist;

public class CartPageSteps<P> extends BaseSteps<CartPageSteps<P>> {
    P parent;
    CartPageElements cartPage = new CartPageElements();

    public CartPageSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check static elements on the page")
    public CartPageSteps<P> checkStaticElementsOnCartPage() {
        Assertions.assertEquals("Swag Labs", cartPage.appLogo.getText());
        Assertions.assertEquals("Your Cart", cartPage.pageTitle.getText());
        Assertions.assertEquals("QTY", cartPage.QTYText.getText());
        Assertions.assertEquals("Description", cartPage.descriptionText.getText());
        cartPage.menuBtn.should(exist);
        Assertions.assertEquals("Continue Shopping", cartPage.continueShoppingBtn.getText());
        Assertions.assertEquals("Checkout", cartPage.checkoutBtn.getText());
        cartPage.shoppingCartLink.should(exist);
        return this;
    }

    @Step("Click on 'continue shopping' button")
    public ProductsPageSteps clickOnContinueShoppingBtn() {
        cartPage.continueShoppingBtn.should(exist).click();
        return new ProductsPageSteps();
    }

    @Step("Click on 'Checkout' button")
    public CheckoutOneStepPageSteps<CartPageSteps<P>> clickOnCheckoutBtn() {
        cartPage.checkoutBtn.should(exist).click();
        return new CheckoutOneStepPageSteps<>(this);
    }
}