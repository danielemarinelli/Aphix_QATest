package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class AphixHomePage extends TestBase {

    @FindBy(xpath =".//input[@placeholder='Contact']")
    private WebElement fieldName;

    @FindBy(xpath =".//input[@placeholder='Phone Number']")
    private WebElement fieldPhoneNumber;

    @FindBy(xpath =".//input[@placeholder='Address Line 1']")
    private WebElement fieldAddressOne;

    @FindBy(xpath =".//input[@placeholder='Address Line 2']")
    private WebElement fieldAddressTwo;

    @FindBy(xpath =".//input[@placeholder='Email Address']")
    private WebElement fieldEmailAddress;

    @FindBy(xpath =".//input[@placeholder='Country']")
    private WebElement fieldCountry;

    @FindBy(xpath =".//input[@placeholder='Postcode']")
    private WebElement fieldPostCode;

    @FindBy(xpath =".//textarea[@class='form__input']")
    private WebElement fieldOrderNotes;

    @FindBy(xpath ="(.//input[@id='newsletter'])[1]")
    private WebElement yesCheckBox;

    @FindBy(xpath =".//input[@id='terms']")
    private WebElement termsCheckBox;

    @FindBy(xpath =".//input[@name='date']")
    private WebElement fieldDeliveryDate;

    @FindBy(xpath =".//button[@id='submit-btn']")
    private WebElement btnSubmit;

    @FindBy(xpath =".//p[@id='newsletter-signup']")
    private WebElement resultSubmit;


    private WebDriver driver;
    public AphixHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void compileAllFormFields() throws InterruptedException {
        driver.manage().window().maximize();
        fieldName.sendKeys("John Paul Connor");
        fieldPhoneNumber.sendKeys("+38990879451");
        fieldAddressOne.sendKeys("Street St.Mary,Paul #77");
        fieldAddressTwo.sendKeys("Central Park NY,NJ  #78");
        Thread.sleep(2000);
        fieldEmailAddress.sendKeys("john_paul-qa@testqa.com");
        fieldOrderNotes.sendKeys("Order Notes for Test QA Aphix");
        fieldCountry.sendKeys("UK");
        fieldPostCode.sendKeys("00152");
        fieldDeliveryDate.sendKeys("11/18/2020");
        yesCheckBox.click();
        termsCheckBox.click();
        Thread.sleep(2000);
        btnSubmit.click();
    }

    public String resultFormSubmit(){
        resultSubmit.click();
        String message = resultSubmit.getText();
        return message;
    }

}
