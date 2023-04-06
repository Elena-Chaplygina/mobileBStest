package tests.local;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.browserstack.TestBase;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


public class SearchTests extends TestBase {

    @Tag("android")
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
    @Tag("android")
    @DisplayName("Поиск статьи про Марс в Википедии")
    @Test
    void successfulSearchTestMars() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Mars");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(itemWithText("Mars")));
    }
    @Tag("ios")
    @DisplayName("Проверка отображения введённого текста")
    @Test
    void successfulSearchIOS(){
        step("Entering text", () -> {
        $(accessibilityId("Text Button")).click();
        $(accessibilityId("Text Input")).sendKeys("hello@browserstack.com");
        });

        step("Text check", () -> {
        $(accessibilityId("Text Output")).shouldBe(visible);
            });

    }

}