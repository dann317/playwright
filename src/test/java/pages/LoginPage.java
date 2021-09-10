package pages;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class LoginPage {
    private static final String SVE_URL = "https://apolo-osp-qa-ui.todo-1.com/BC_SVE_User/Login";
    private Page sve;

    public LoginPage(Page page) {
        this.sve = page;
    }

    public void loginInSVEWithToken(String usuario, String password, String tknSerial, String token) {
        this.sve.navigate(SVE_URL);
        Locator username = this.sve.locator("//input[@id='InputUserName']");
        Locator pwd = this.sve.locator("//input[@id='InputUserPassword']");
        Locator continueButton = this.sve.locator("//div/button[not(@disabled) and @id='ContinueButton']");
        Locator serialNumber = this.sve.locator("//input[@id='b20-ActivationTokenStep1SerialNumberInput']");
        Locator confirmSerialNumber = this.sve.locator("//input[@id='b20-ActivationTokenStep1SerialConfirmationInput']");
        Locator activateTokenButton = this.sve.locator("//div/button[not(@disabled) and @id='b20-TokenActivationStep1ModalContinueButton']");
        Locator continueTknActivatedButton = this.sve.locator("//div/button[@id='b22-TokenActivationStep3ModalContinueButton']");
        Locator tokenContinueButton = this.sve.locator("//span[not(@disabled) and @id='b19-ContinueButton']");

        username.type(usuario);
        pwd.type(password);
        continueButton.click();
        serialNumber.type(tknSerial);
        confirmSerialNumber.type(tknSerial);
        activateTokenButton.click();
        continueTknActivatedButton.click();
        this.sve.keyboard().type(token, new Keyboard.TypeOptions().setDelay(100));
        tokenContinueButton.click();
        /*sve.type("//input[@id='InputUserName']", "user1su17281");
        sve.type("//input[@id='InputUserPassword']", "Prueba.4");
        sve.click("//div/button[not(@disabled) and @id='ContinueButton']");
        sve.type("//input[@id='b20-ActivationTokenStep1SerialNumberInput']", "111111111");
        sve.keyboard().press("Tab");
        sve.type("//input[@id='b20-ActivationTokenStep1SerialConfirmationInput']", "111111111 ");
        sve.click("//div/button[not(@disabled) and @id='b20-TokenActivationStep1ModalContinueButton']");
        sve.click("//div/button[@id='b22-TokenActivationStep3ModalContinueButton']");
        sve.keyboard().type("111111", new Keyboard.TypeOptions().setDelay(100));
        sve.click("//span[not(@disabled) and @id='b19-ContinueButton']");*/
    }
}