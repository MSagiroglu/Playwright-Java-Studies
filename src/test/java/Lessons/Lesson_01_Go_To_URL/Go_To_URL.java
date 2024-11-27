package Lessons.Lesson_01_Go_To_URL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Go_To_URL {
    static Playwright pw;
    static Browser browser;
    static Page page;

    public static void main(String[] args) {
        Playwright pw = Playwright.create();
        BrowserType browserType = pw.chromium();
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        //Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
        // Localdeki web browser ile çalıştırmak için yukarıdaki kod ile çalıştırmalısın.
        //chrome, msedge, chrome-beta, msedge-beta, chrome-dev, msedge-dev, chrome-canary, msedge-canary
        Page page = browser.newPage();
        page.navigate("https://google.com");
        String title = page.title();
        System.out.println("Page title: " + title);
        page.close();
        browser.close();
        pw.close();
        //  goToPage("https://google.com");
        //  close();

    }


    public static void goToPage(String pageUrl) { // Go to the page Method
        pw = Playwright.create();
        BrowserType browserType = pw.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate(pageUrl);
        // Go to the page methodu, linki alıp browsera göndermek için kullanılır.
    }

    public static void close() {
        page.close();
        browser.close();
        pw.close();
        // Close the browser and Playwright methodu, browser ve Playwright'u kapatmak için kullanılır.'

    }
}