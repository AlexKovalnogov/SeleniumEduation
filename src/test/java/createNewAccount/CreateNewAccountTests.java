package createNewAccount;

import Executor.TestRunner;
import org.junit.Test;

public class CreateNewAccountTests extends TestRunner {

    @Test
    public void checkThatUserIsAbleToCreateNewAccount() {
        homePage.clickCreateAccount()
                .checkIsRedorectToCreateAccountPage()
                .typeFirstName("Name")
                .typeLastName("LastName")
                .typeEmail(System.currentTimeMillis()+"@test.com")
                .typePassword("Qwerty123456")
                .typeConfirmPassword("Qwerty123456")
                .clickCreateAccountButton();
        homePage.clickCreateAccount();
    }
}
