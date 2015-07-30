import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.ThreadedRefreshHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
 
public class CrawlerDemo {
 
    final static WebClient webClient;
 
    static {
        webClient = new WebClient(BrowserVersion.FIREFOX_24);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(true);
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.waitForBackgroundJavaScriptStartingBefore(10000);
        webClient.setJavaScriptTimeout(2147483647);
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        webClient.waitForBackgroundJavaScript(5000);
        webClient.setRefreshHandler(new ThreadedRefreshHandler());
        webClient.getCookieManager().setCookiesEnabled(true);
    }
 
    public static void main(String[] args) throws Exception {
    	HtmlPage currentPage = webClient.getPage("https://www.zomato.com/bangalore/hotel-kadamba-veg-rajajinagar");
        System.out.println("Test 1 - page length="+currentPage.asText().length());
/*
        if (currentPage.getFirstByXPath("//div[@class='clearfix reviews-subhead-sort']/ul[@class='review-sorting text-tabs selectors left']/li[@class='text-tab-link']/a[@data-sort='reviews-dd']") != null) {
        	HtmlAnchor e = currentPage.getFirstByXPath("//div[@class='clearfix reviews-subhead-sort']/ul[@class='review-sorting text-tabs selectors left']/li[@class='text-tab-link']/a[@data-sort='reviews-dd']");
        	System.out.println("Test2 - e = "+e.asText());
        	//HtmlDivision target_div = currentPage.getFirstByXPath("//div[@class='clearfix reviews-subhead-sort']/ul[@class='review-sorting text-tabs selectors left']/li[@class='text-tab-link']/a[@class='default-section-title everyone empty']");
        	//System.out.println("Test 2.1 - target div " + target_div.asText());
        	if (currentPage.getFirstByXPath("//div[@class='clearfix reviews-subhead-sort']/ul[@class='review-sorting text-tabs selectors left']/li[@class='text-tab-link']/a[@data-sort='reviews-dd']") != null) {
                currentPage = e.click();
                _htmlpage = webClient.getPage(e.click().getUrl());
                System.out.println("e.click().getUrl(): "+e.click().getUrl());
               // currentPage = e.getHtmlPageOrNull();
                System.out.println("Test 3 - page length="+currentPage.asText().length());
                //System.out.println(currentPage.asText());
                
                
                
        	}
        }
*/       /* 
        if (_htmlpage.getFirstByXPath("//div[@class = 'load-more']") != null) {
            HtmlDivision target_div = _htmlpage.getFirstByXPath("//div[@class='load-more']");
            System.out.println("Test 4 - target div " + target_div.asText());
            while (_htmlpage.getFirstByXPath("//div[@class = 'load-more']") != null) {
            	_htmlpage = target_div.click();
                System.out.println("Test 5 - page length="+_htmlpage.asText().length());
                System.out.println(_htmlpage.asText());
            }
            
        } else {
        	System.out.println("IS NULL");
        }
        */
        //https://www.zomato.com/bangalore/the-bungalow-whitefield/reviews#tabtop
        /*
        if (_htmlpage.getFirstByXPath("//div[@class = 'load-more']") != null) {
            HtmlDivision target_div = _htmlpage.getFirstByXPath("//div[@class='load-more']");
            System.out.println("Test 4 - target div " + target_div.asText());
            while (_htmlpage.getFirstByXPath("//div[@class = 'load-more']") != null) {
            	_htmlpage = target_div.click();
                System.out.println("Test 5 - page length="+_htmlpage.asText().length());
                //System.out.println(currentPage.asText());
            }
            
        } else {
        	System.out.println("IS NULL");
        }
        */
        
        if (currentPage.getFirstByXPath("//div[@class = 'load-more']") != null) {
            HtmlDivision target_div = currentPage.getFirstByXPath("//div[@class='load-more']");
            System.out.println("Test 2 - target div " + target_div.asText());
            while (currentPage.getFirstByXPath("//div[@class = 'load-more']") != null) {
                currentPage = target_div.click();
                System.out.println("Test 3 - page length="+currentPage.asText().length());
                System.out.println(currentPage.asText());
            }
            
        }
        //System.out.println(currentPage.asText());
    }
}