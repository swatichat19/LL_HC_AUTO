

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class HomePage {

	    private WebDriver driver;
	    private By searchBar;
	    private By searchButton;

	    private static final String SEARCH_BAR_ID = "twotabsearchtextbox";
	    private static final String SEARCH_BUTTON_CLASS_NAME = "nav-input";

	    public HomePage(WebDriver driver){
	        this.driver = driver;
	        searchBar = By.id(SEARCH_BAR_ID);
	        searchButton = By.className(SEARCH_BUTTON_CLASS_NAME);
	    }

	    public void searchItem(String item){
	        driver.findElement(searchBar).sendKeys(item);
	        driver.findElement(searchButton).click();
	    }

	}
	

