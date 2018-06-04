	import org.testng.annotations.*;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class TestAmazon {

	    // = new iPad2Case[5];
	    public static void main(String args[]) throws InterruptedException{
	    	

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("http://amazon.com");

	        HomePage homePage = new HomePage(driver);
	        homePage.searchItem("ipad air 2 case");

	        ResultPage resultsPage = new ResultPage(driver);
	        resultsPage.selectCaseMaterial(CaseMaterial.PLASTIC);
	        Thread.sleep(5000);
	        resultsPage.setPriceRange("20", "100");

	        iPad2Case cases[] = new iPad2Case[5];
	        for (int i = 0; i < 5; i++){
	            cases[i] = new iPad2Case();
	        }

	         cases = resultsPage.getProperties();

	        for (int i = 0; i < 5; i++){
	            System.out.println("Product Name: " + cases[i].name);
	            System.out.println("Price: $" + cases[i].price + "\n");
	        }

	        Thread.sleep(10000);
	        driver.quit();
	    }


	}
