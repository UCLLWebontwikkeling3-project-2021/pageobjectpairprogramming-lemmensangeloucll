import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IndexPage extends Page{
    @FindBy(id="submitSearch")
    private WebElement submitSearchButton;

    //TODO change the dom name below to the corresponding dom name that contains the welcome message on your index/home page
    @FindBy(css = "h1")
    private WebElement h1;

    //TODO change the class name below to a class name that is included in every menu item you have in your menu header
    @FindBy(className = "nav-link")
    private List<WebElement> menuItems;

    public IndexPage(WebDriver driver) {
        super(driver);
        //TODO change the command below to the correct command according to your controller
        this.driver.get(getPath()+"?command=Home");
    }

    public String getH1(){
        return h1.getText();
    }

    public int getNumberOfMenuItems(){
        return menuItems.size();
    }

}
