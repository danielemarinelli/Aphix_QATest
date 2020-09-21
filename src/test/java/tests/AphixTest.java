package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AphixHomePage;

public class AphixTest extends TestBase{

    AphixHomePage home = null;

    @Test
    public void VerifyCorrectSubmitForm() throws InterruptedException {
        home = new AphixHomePage(driver());
        home.compileAllFormFields();
        Assert.assertEquals(home.resultFormSubmit(),"Thanks for signing up to our newsletter","Form submit failed");
    }
}
