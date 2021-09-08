import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

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
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));

    }

    @BeforeEach
    public void getNewPage() {
        methodName = Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName();
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("./videos/video - "+methodName+".mp4")));
        sve = context.newPage();
    }

    public void loginWithToken() {
        sve.navigate(SVE_URL);
        sve.type("//input[@id='InputUserName']", "user1su17281");
        sve.type("//input[@id='InputUserPassword']", "Prueba.4");
        sve.click("//div/button[not(@disabled) and @id='ContinueButton']");
        sve.type("//input[@id='b20-ActivationTokenStep1SerialNumberInput']", "111111111");
        sve.keyboard().press("Tab");
        sve.type("//input[@id='b20-ActivationTokenStep1SerialConfirmationInput']", "111111111 ");
        sve.click("//div/button[not(@disabled) and @id='b20-TokenActivationStep1ModalContinueButton']");
        sve.click("//div/button[@id='b22-TokenActivationStep3ModalContinueButton']");
        sve.keyboard().type("111111", new Keyboard.TypeOptions().setDelay(100));
        sve.click("//span[not(@disabled) and @id='b19-ContinueButton']");
    }

    public String getAvaiableMenus() {
        return sve.innerText("//div[@class='display-flex justify-space-between']");

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