import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

public class Main {

public static void main(String[] args) {
      Document doc;
	try {
		doc = Jsoup.connect("http://www.zomato.com/mumbai/starbucks-coffee-fort").get();
		Elements div = doc.select("div.res-text > div > p");
		for (Element paragraph : div) {
		    System.out.println(paragraph.text());
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
}

}