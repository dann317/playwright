package Menu;

import co.com.bancolombia.svn.TokenLogin;
import org.junit.Test;
import org.testng.Assert;

public class MenusTest {
    protected static final String CONSOLIDATED_BALANCES = "Saldos consolidados";
    TokenLogin tokenLogin = new TokenLogin();
    @Test
    public void isAbleToGetConsolidatedBalances(){
        tokenLogin.goToSVE();
        tokenLogin.loginWithToken();
        Assert.assertEquals(tokenLogin.getAvaiableMenus(), CONSOLIDATED_BALANCES);
    }
}
