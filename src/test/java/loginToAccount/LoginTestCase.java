package loginToAccount;

import Executor.TestRunner;
import org.junit.Test;
import ua.kovalnohov.libs.TestData;

public class LoginTestCase extends TestRunner {

    @Test
    public void testThatUserIsAbleToLogin() {
        homePage.openCustomerLoginPage()
                .signInWithCreds(TestData.LOGIN, TestData.PASSWORD);

    }
}
