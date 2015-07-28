import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public class RemoveComments {
    public static void main(String... args) {
    	Document doc;
        
		try {
			 doc = Jsoup.connect("https://www.zomato.com/bangalore/abs-absolute-barbecues-marathahalli").get();
			 List<Comment> comments = getComments(doc);		        
		        print(doc.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    private static List<Comment> getComments(Node node) {
        List<Comment> comments = new ArrayList<Comment>();
        int i = 0;
        while (i < node.childNodes().size()) {
            Node child = node.childNode(i);
            if (child.nodeName().equals("#res-review-tab-content"))
                comments.add((Comment) child);
            else {
                comments.addAll(getComments(child));
            }
            i++;
        }
        return comments;
    }
    
    private static void removeComments(Node node) {
        // as we are removing child nodes while iterating, we cannot use a normal foreach over children,
        // or will get a concurrent list modification error.
        int i = 0;
        while (i < node.childNodes().size()) {
            Node child = node.childNode(i);
            if (child.nodeName().equals("#comment"))
                child.remove();
            else {
                removeComments(child);
                i++;
            }
        }
    }
    
    private static void print(String msg) {
        System.out.println(msg);
    }
}