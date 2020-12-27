import org.openqa.selenium.WebDriver;

public abstract class Page {
    WebDriver driver;
    //TODO change the path below if necessary
    String path = "http://localhost:8081/Controller";

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle () {
        return driver.getTitle();
    }

}
