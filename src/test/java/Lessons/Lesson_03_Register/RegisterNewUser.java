package Lessons.Lesson_03_Register;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterNewUser {
  @Test
  public void registerNewUser() {
      Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      Page page = browser.newPage();
      page.navigate("https://freelance-learn-automation.vercel.app/login");
      page.getByText("New user? Signup").click();
      PlaywrightAssertions.assertThat(page.getByText("Sign Up").first()).containsText("Sign Up");
      page.getByPlaceholder("Name").fill("John Doe");
     // page.getByPlaceholder("Email").fill("admin"+ new Random().nextInt(1000)+"@email.com");
      page.getByPlaceholder("Email").fill("admin"+ System.currentTimeMillis()+"@email.com");
      page.getByPlaceholder("Password").fill("admin@123");
      page.locator("xpath=//input[@id='6645751e07bdedf17a8769cc']").click();
      Assert.assertTrue(page.locator("xpath=//input[@id='6645751e07bdedf17a8769cc']").isChecked());
      page.locator("xpath=//input[@id='670ffb6f62eaf664c3c0f189']").click();
      Assert.assertTrue(page.locator("xpath=//input[@id='670ffb6f62eaf664c3c0f189']").isChecked());
      page.locator("xpath=//input[@id='67215c7c62eaf664c3c193db']").click();
      Assert.assertTrue(page.locator("xpath=//input[@id='67215c7c62eaf664c3c193db']").isChecked());
      Assert.assertTrue(page.locator("#gender1").isChecked()); // you can use # for id
      Assert.assertFalse(page.locator("#gender2").isChecked());

      page.locator("#state").selectOption("Gujarat");
      String hobbies []= {"Swimming", "Playing"} ;
      page.locator("#hobbies").selectOption(hobbies);
      Assert.assertTrue(page.locator(".submit-btn").isEnabled()); //you can use . before for class input
      page.locator(".submit-btn").click();
      page.waitForTimeout(3000);


  }
}
