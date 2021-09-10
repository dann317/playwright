import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

public class MenusTest extends NavigateSVE {
    protected static final String CONSOLIDATED_BALANCES = "Saldos consolidados";
    protected static final String DEP_ACCOUNT_BALANCES = "Cuentas de depósitos";

/*/    @Test
    void isAbleToGetDepositsAccountBalances() {
        getNewPage();
        loginWithToken();
        MatcherAssert.assertThat(getAvaiableMenus(), CoreMatchers.containsString(DEP_ACCOUNT_BALANCES));
    }

    @Test
    void isAbleToGetConsolidatedBalances() {
        getNewPage();
        loginWithToken();
        MatcherAssert.assertThat(getAvaiableMenus(), CoreMatchers.containsString(CONSOLIDATED_BALANCES));
    }*/

    @Test
    void ejemplo() {
        assert getAvaiableMenus().contains(CONSOLIDATED_BALANCES);

    }
}
