import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.text.Normalizer;

public class MenusTest extends NavigateSVE {
    protected static final String CONSOLIDATED_BALANCES = "Saldos consolidados";
    protected static final String DEP_ACCOUNT_BALANCES = "Cuentas de depositos";

    @Test
    public void isAbleToGetDepositsAccountBalances() {
        getNewPage();
        loginWithToken();
        MatcherAssert.assertThat(Normalizer.normalize(getAvaiableMenus(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""), CoreMatchers.containsString(DEP_ACCOUNT_BALANCES));
    }

    @Test
    public void isAbleToGetConsolidatedBalances() {
        getNewPage();
        loginWithToken();
        MatcherAssert.assertThat(getAvaiableMenus(), CoreMatchers.containsString(CONSOLIDATED_BALANCES));
    }
}
