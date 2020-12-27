import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends Page{
    //TODO change the id of the user id field below to the correct id of your user id field
    @FindBy(id="userid")
    private WebElement userIdField;

    //TODO change the id of the password field below to the correct id of your password field
    @FindBy(id="password")
    private WebElement passwordField;

    //TODO change the id of the sign in button below to the correct id of your sign in button
    @FindBy(id="login")
    private WebElement signInButton;

    //TODO change the class of the errors div below to the correct classname of your div
    @FindBy(css = ".alert")
    private WebElement singleError;

    //TODO change the class of the errors div below to the correct classname of your div
    @FindBy(css = ".alert ul")
    private List<WebElement> errors;

    public LoginPage(WebDriver driver) {
        super(driver);
        //TODO change the command below to the correct command according to your controller
        this.driver.get(getPath()+"?command=Index");
    }


    public void setUserIdField(String userid){
        userIdField.clear();
        userIdField.sendKeys(userid);
    }

    public void setPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public boolean errorExists(String errorMsg){
        return singleError.getText().equals(errorMsg);
    }

    public boolean errorsExists(String errorMsg){
        boolean found = false;
        for (WebElement listItem:errors) {
            if (listItem.getText().toLowerCase().contains(errorMsg)) {
                found = true;
            }
        }
        return found;
    }

    public WebElement getSingleError(){
        return singleError;
    }

    public List<WebElement> getErrors(){
        return errors;
    }

    public IndexPage submitValid(){
        signInButton.click();
        return PageFactory.initElements(driver, IndexPage.class);
    }

    public void submitInvalid(){
        signInButton.click();
    }

}
