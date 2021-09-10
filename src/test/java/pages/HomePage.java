package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page sve;

    public HomePage(Page page) {
        this.sve = page;
    }

    public String getAvaiableMenu(){
        Locator menus = this.sve.locator("//div[@class='display-flex justify-space-between']");
        return menus.innerText();
    }
}
