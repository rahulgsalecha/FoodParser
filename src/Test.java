
 
import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class Test {
 
  public static void main(String[] args) {
 
	Document doc;
	try {
 /*
		// need http protocol
		doc = Jsoup.connect("https://www.zomato.com/bangalore/abs-absolute-barbecues-marathahalli").get();
 
		// get page title
		String title = doc.title();
		System.out.println("title : " + title);
 
		// get all links
		Elements links = doc.select("a[href]");
		for (Element link : links) {
 
			// get the value from href attribute
			System.out.println("\nlink : " + link.attr("href"));
			System.out.println("text : " + link.text());
 
		}
 */
		doc = Jsoup.connect("https://www.zomato.com/bangalore/abs-absolute-barbecues-marathahalli").get();
	    //String title = doc.title();
	    

	    //Element reviews = doc.getElementById("description");
	    //System.out.println(reviews);
		
		Elements div = doc.select("div.res-review-body > div > p");
        for (Element paragraph : div) {
           System.out.println(paragraph.text());
           }
	    
	} catch (IOException e) {
		e.printStackTrace();
	}
 
  }
 
}