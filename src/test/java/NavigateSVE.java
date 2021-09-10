import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pages.HomePage;
import pages.LoginPage;

import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigateSVE {
    protected Page sve;
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    public static final String SVE_URL = "https://apolo-osp-qa-ui.todo-1.com/BC_SVE_User/Login";
    protected String methodName;

    public NavigateSVE() {

    }

    @BeforeAll
    public void openBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        methodName = Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName();
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("./videos/video - " + methodName + ".mp4")));
        sve = context.newPage();
    }

    @BeforeEach
    public void getNewPage() {
        LoginPage loginPage = new LoginPage(sve);
        loginPage.loginInSVEWithToken("user1su17281", "Prueba.4", "111111111", "111111");
    }

    /*public void loginWithToken() {
        sve.navigate(SVE_URL);
        Locator username = sve.locator("//input[@id='InputUserName']");
        Locator password = sve.locator("//input[@id='InputUserPassword']");
        Locator continueButton = sve.locator("//div/button[not(@disabled) and @id='ContinueButton']");
        username.type("user1su17281");
        password.type("Prueba.4");
        continueButton.click();
        ----sve.type("//input[@id='InputUserName']", "user1su17281");
        sve.type("//input[@id='InputUserPassword']", "Prueba.4");
        sve.click("//div/button[not(@disabled) and @id='ContinueButton']");------
        sve.type("//input[@id='b20-ActivationTokenStep1SerialNumberInput']", "111111111");
        sve.keyboard().press("Tab");
        sve.type("//input[@id='b20-ActivationTokenStep1SerialConfirmationInput']", "111111111 ");
        sve.click("//div/button[not(@disabled) and @id='b20-TokenActivationStep1ModalContinueButton']");
        sve.click("//div/button[@id='b22-TokenActivationStep3ModalContinueButton']");
        sve.keyboard().type("111111", new Keyboard.TypeOptions().setDelay(100));
        sve.click("//span[not(@disabled) and @id='b19-ContinueButton']");
    }*/

    public String getAvaiableMenus() {
       // return sve.innerText("//div[@class='display-flex justify-space-between']");
        HomePage homePage = new HomePage(sve);
        return homePage.getAvaiableMenu();
    }

    @AfterEach
    void closeContext() {
        sve.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshots/" + sve.title() + " - " + methodName + ".png")));
        context.close();
    }

    @AfterAll
    public void closePlaywright() {
        playwright.close();
    }


}