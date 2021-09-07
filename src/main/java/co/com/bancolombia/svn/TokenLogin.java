package co.com.bancolombia.svn;

import com.microsoft.playwright.*;

public class TokenLogin {
    public static Page sve;
    public static final String SVE_URL = "https://apolo-osp-qa-ui.todo-1.com/BC_SVE_User/Login";

    public TokenLogin() {

    }

    public void goToSVE() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        sve = browser.newPage();
        sve.navigate(SVE_URL);
    }

    public void loginWithToken() {
        sve.type("//input[@id='InputUserName']", "user1su17281");
        sve.type("//input[@id='InputUserPassword']", "Prueba.4");
        sve.click("//div/button[not(@disabled) and @id='ContinueButton']");
        sve.type("//input[@id='b20-ActivationTokenStep1SerialNumberInput']", "111111111");
        sve.keyboard().press("Tab");
        sve.type("//input[@id='b20-ActivationTokenStep1SerialConfirmationInput']", "111111111 ");
        sve.click("//div/button[not(@disabled) and @id='b20-TokenActivationStep1ModalContinueButton']");
        sve.click("//div/button[@id='b22-TokenActivationStep3ModalContinueButton']");
        sve.click("//div[@id='b19-b5-b2-Column1']");
        sve.keyboard().type("111111", new Keyboard.TypeOptions().setDelay(100));
        sve.click("//span[not(@disabled) and @id='b19-ContinueButton']");
    }

    public String getAvaiableMenus() {
        return sve.textContent("//span[@class ='padding-left-base font-btns-dash text-cbi-bold']");
    }
}