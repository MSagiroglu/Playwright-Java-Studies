package Lessons.Lesson_02;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import java.util.regex.Pattern;

public class Login_Logout {
    public static void main(String[] args) {
        Browser browser=null;
        Page page=null;
        try {
            browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            page = browser.newPage();
            page.navigate("https://freelance-learn-automation.vercel.app/login");
            ;
            String title = page.title();
            PlaywrightAssertions.assertThat(page).hasTitle(title);
            System.out.println("title = " + title);
           // page.locator("#email1").fill("admin@email.com");
            //page.locator("xpath=//input[@id='email1']").fill("admin@email.com");
            //page.locator("css=input[id='email1']").fill("admin@email.com");
            page.getByPlaceholder("Enter Email").fill("admin@email.com");
            page.getByPlaceholder("Enter Password").fill("admin@123");
//            page.locator("xpath=//button[normalize-space()='Sign in']").click();
            page.getByText("Sign in").nth(1).click();
            PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
            page.getByAltText("menu").click();
            page.getByText("Sign out").click();
            PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
            page.waitForTimeout(3000);

        } finally {
            page.close();
            browser.close();
        }


    }

}
