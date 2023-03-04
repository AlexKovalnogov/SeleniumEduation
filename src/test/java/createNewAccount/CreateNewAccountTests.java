package createNewAccount;

import Executor.TestRunner;
import org.junit.After;
import org.junit.Test;

public class CreateNewAccountTests extends TestRunner {
    private static final String NAME = "Name";
    private static final String LASTNAME = "LastName";

    @Test
    public void checkThatUserIsAbleToCreateNewAccount() {
        homePage.clickCreateAccount()
                .checkIsRedorectToCreateAccountPage()
                .typeFirstName(NAME)
                .typeLastName(LASTNAME)
                .typeEmail(System.currentTimeMillis() + "@test.com")
                .typePassword("Qwerty123456")
                .typeConfirmPassword("Qwerty123456")
                .clickCreateAccountButton()
                .checkThatUserRedirectedOnAccountPage(NAME, LASTNAME)
                .checkThatSuccessMessageDisplayed();

        //also need to check user in DB but I don;t have access there

    }

    @After
    public void deleteUser() {

        // this method should  delete created user in case access to DB
    }
}
