import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


public class SearchTests extends TestBase {


    @Tag("browserstack")
    @DisplayName("Поиск статьи про Java в Википедии")
    @Test
    void successfulSearchTestJava() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

@Tag("emulation")
    @DisplayName("Checking the onboarding screen")
    @Test
    void successfulSearchTestJava1() {
        step("Check onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("The Free Encyclopedia …in over 300 languages")));

        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check onboarding second screen", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("New ways to explore")));

        step("Continue onboarding second screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check onboarding third screen", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Reading lists with sync")));

        step("Continue onboarding third screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check onboarding fourth screen", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Send anonymous data")));

        step("Reject onboarding screen", () ->
                $(id("org.wikipedia.alpha:id/rejectButton")).click());
        step("Verify search field", () ->
                $(id("org.wikipedia.alpha:id/search_container"))
                        .isDisplayed());

    }
}