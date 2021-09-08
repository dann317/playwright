import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MenusTest extends NavigateSVE {
    protected static final String CONSOLIDATED_BALANCES = "Saldos consolidados";
    protected static final String DEP_ACCOUNT_BALANCES = "Cuentas de depósitos";

    @Test
    public void isAbleToGetConsolidatedBalances() {
        getNewPage();
        loginWithToken();
        MatcherAssert.assertThat(getAvaiableMenus(), CoreMatchers.containsString(CONSOLIDATED_BALANCES));
    }

    @Test
    public void isAbleToGetDepositsAccountBalances() {
        getNewPage();
        loginWithToken();
        MatcherAssert.assertThat(getAvaiableMenus(), CoreMatchers.containsString(DEP_ACCOUNT_BALANCES));
        //assertEquals(DEP_ACCOUNT_BALANCES, getAvaiableMenus());
    }
}
