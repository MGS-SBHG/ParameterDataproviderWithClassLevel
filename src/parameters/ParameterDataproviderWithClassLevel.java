
package parameters;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ParameterDataproviderWithClassLevel {

	WebDriver driver;
	
	@BeforeTest
	 public void setup(){
		 driver = new FirefoxDriver();
	    driver.get("http://www.google.com");                 
   	 	driver.manage().window().maximize();
	 }		
		                         
        /* DataProvider resides Dataprovider class   
         in test method, attribute dataProviderClass is in @Test annotation.
        */     
        
        @Test
        (dataProvider="SearchProvider",dataProviderClass=DataproviderClass.class)
 
        public void testMethod(String verse,String verseKey) throws InterruptedException {
            {        
            	           	
             WebElement searchText = driver.findElement(By.name("q"));
              
             //WebElement searchText = driver.findElement(By.id("lst-ib"));             
                          
             //Search text in google text box and click to send
                searchText.sendKeys(verseKey);   
                searchText.submit();
                         
             System.out.println("Bible verse:"+verse+" search key is->"+verseKey);
                                            
             WebDriverWait wait = new WebDriverWait(driver, 10);
                        
             //WebElement urlofverse = driver.findElement(By.xpath("//ol[@id='rso']/div[1]/div[1]/div/h3/a"));                
                
              wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(verseKey)));
                                    
              WebElement urlofverse = driver.findElement(By.partialLinkText(verseKey));
              
              System.out.println("Search key: " + verseKey);                                	

              System.out.println("Text in first link: " + urlofverse.getText());                                	          
              
          	  Assert.assertTrue(urlofverse.getText().contains(verseKey));
          	
              searchText.clear();                      
           
        }
     }
}
