
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;

	public class ResultPage {

	    private WebDriver driver;
	    private By checkBox;
	    private By textBoxMin;
	    private By textBoxMax;

	    public ResultPage(WebDriver driver){
	        this.driver = driver;
	        this.textBoxMin = By.id("low-price");
	        this.textBoxMax = By.id("high-price");
	    }

	    public void selectCaseMaterial(String caseMaterial){
	        this.checkBox = By.name(caseMaterial);
	        driver.findElement(checkBox).click();

	    }

	    public void setPriceRange(String min, String max)throws InterruptedException{
	        driver.findElement(textBoxMin).sendKeys(min);
	        driver.findElement(textBoxMax).sendKeys(max);
	        driver.findElement(textBoxMax).submit();

	    
	   }
	    public iPad2Case[] getProperties()throws InterruptedException{

	        iPad2Case cases[] = new iPad2Case[5];
	        String price;

	        for(int i=0; i < 5; i ++){
	            cases[i] = new iPad2Case();
	            price = driver.findElement(priceOfResult(i)).getText();

	            if(i != 4){
	                String parts[] = price.split(" ",3);
	                cases[i].price += Double.parseDouble(parts[1]) + Double.parseDouble(parts[2])/100;
	            }else{
	                String str = price.replace("$","");
	                cases[i].price += Double.parseDouble(str);
	            }
	            cases[i].name = driver.findElement(nameOfResult(i)).getText();

	        }

	        return cases;
	    }

	    private By priceOfResult(int n){
	        if (n == 4) {
	            return By.cssSelector("#result_4 > div > div:nth-child(5) > div > a > span.a-size-base.a-color-base");
	        }else {
	            return By.cssSelector("#result_"+ n +" > div > div:nth-child(4) > div:nth-child(1) > a > span.a-color-base.sx-zero-spacing");
	        }
	    }

	    private By nameOfResult(int n){
	        switch (n){
	            case 0:
	                return By.cssSelector("#result_0 > div > div:nth-child(3) > div.a-row.a-spacing-none.sx-line-clamp-4 > a > h2");
	            case 1:
	                return By.cssSelector("#result_1 > div > div:nth-child(3) > div.a-row.a-spacing-none.sx-line-clamp-4 > a > h2");
	            case 2:
	                return By.cssSelector("#result_2 > div > div:nth-child(3) > div.a-row.a-spacing-none.sx-line-clamp-4 > a > h2");
	            case 3:
	                return By.cssSelector("#result_3 > div > div:nth-child(3) > div:nth-child(1) > a > h2");
	            case 4:
	                return By.cssSelector("#result_4 > div > div:nth-child(3) > div.a-row.a-spacing-none.sx-line-clamp-4 > a > h2");
	        }
	        return By.cssSelector("#result_0 > div > div:nth-child(3) > div.a-row.a-spacing-none.sx-line-clamp-4 > a > h2");
	    }

	    //private String scoreOfResult(int n) throws InterruptedException{

	    //}
	}

