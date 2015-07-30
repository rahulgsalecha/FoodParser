
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.DynamicGraph.Status;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.ThreadedRefreshHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SeleniumParse {
	
	
    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) throws IOException, InterruptedException {
    	
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.zomato.com/bangalore/new-modern-hotel-basavanagudi");
        
        //Code to load Popular Reviews
        /*
        if(driver.findElement(By.xpath("//div[@class = 'load-more']")) != null) {
        	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'load-more']")));
        	//System.out.println("load-more is not null");
        	try{
        	while(driver.findElement(By.xpath("//div[@class = 'load-more']")) != null){
        		//System.out.println("load-more : "+i);
        		i++;
        		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'load-more']")));
        		driver.findElement(By.xpath("//div[@class = 'load-more']")).click();
        	}
        	i = 0;
        	} catch (NoSuchElementException e) {
            	System.out.println("load-more button doesn't exist :NoSuchElementException ");
            } catch (TimeoutException e) {
            	System.out.println("load-more button doesn't exist: TimeoutException");
            } catch (StaleElementReferenceException e) {
            	System.out.println("load-more button doesn't exist: StaleElementReferenceException");
            }	
        } else {
        	//System.out.println("load-more is null");
        }
        */
        
        //Code to click on Reviews tab
        driver.findElement(By.xpath("//a[contains(@class,'default-section-title everyone empty')]")).click();
        
        //currentURL = driver.getCurrentUrl();
        
        Thread.sleep(1000);
        
        //Code to click load-more button for all Reviews
        if(driver.findElement(By.xpath("//div[@class = 'load-more']")) != null) {
        	try{
        		while(driver.findElement(By.xpath("//div[@class = 'load-more']")) != null){
        			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'load-more']")));
        			driver.findElement(By.xpath("//div[@class = 'load-more']")).click();
        			}
        		} catch (NoSuchElementException e) {
        	System.out.println("load-more button doesn't exist :NoSuchElementException ");
        } catch (TimeoutException e) {
        	System.out.println("load-more button doesn't exist: TimeoutException");
        } catch (StaleElementReferenceException e) {
        	System.out.println("load-more button doesn't exist: StaleElementReferenceException");
        }
        } else {
        	System.out.println("load-more is null");
        }
        
        //System.out.println(driver.getPageSource());
        /*
         * driver.findElements(By.xpath("//div[contains(@class,'res-review-body clearfix') and " +
        		"contains(@class, 'rev-text hidden') and " +
        		"contains(@class, 'left') and " +
        		"contains(@class, 'ttupper')]")
         */
        Thread.sleep(1000);
        
        WebElement alleles = driver.findElement(By.xpath("//div[contains(@class,'zs-following-list pbot')]"));
        System.out.println("alleles:"+alleles.getText().length());
        List<WebElement> elements = alleles.findElements(By.xpath("//div[@itemprop='review']"));
    
        System.out.println(elements.size());
        for(WebElement element:elements) {
        	System.out.println("========================================");
            System.out.println(element.getText());
        }
        
        
    
        
    }
        
}

