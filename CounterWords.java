import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class CounterWords {

	private static final boolean FALSE = false;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("//Users//rsalecha//Downloads//jate_test//Jalpaan_Menu.txt"));
		
		List<String> list = new ArrayList<String>();
		
		while (s.hasNext()){
		    list.add(s.useDelimiter(",").next());
		}
		s.close();
		
		//int count = countWord("Tamater Shorba","//Users//rsalecha//Downloads//jate_test//jalpaan_text.txt");
		//System.out.println(" Count:" + count);
		
		Iterator<String> MenuListIterator = list.iterator();
		while (MenuListIterator.hasNext()) {
			//System.out.println(MenuListIterator.next());
			int count = countWord(MenuListIterator.next(),"//Users//rsalecha//Downloads//jate_test//jalpaan_text.txt");
			//System.out.println("count:" + count);
		}
		
		/*
		for (ListIterator<String> iter = list.listIterator(); iter.hasNext(); ) {
			int count = countWord(iter.next(),"//Users//rsalecha//Downloads//jate_test//littleItalyReview.rtf");
		}
		*/

	}
	
	public static int countWord(String word, String file_name) throws FileNotFoundException {
		int count = 0;
		Scanner scanner = new Scanner(new File(file_name));
		boolean found = false;
		
		
		while (scanner.hasNextLine()) {
		    String nextToken = scanner.nextLine();
		   
		    if(found){
		    	found = false;
		    }
		    if (containsIgnoreCase(nextToken,word))
		    {
		    	found = true;
		    	count++;
		    }
		    
		    
		}
		if(count > 0){
		System.out.println(word + "," + count);
		}
		return count;
	}
	
	public static boolean containsIgnoreCase(final String str, final String searchStr) {
	    if (str == null || searchStr == null) {
	        return false;
	    }
	    final int len = searchStr.length();
	    final int max = str.length() - len;
	    for (int i = 0; i <= max; i++) {
	        if (str.regionMatches(true, i, searchStr, 0, len)) {
	            return true;
	        }
	    }
	    return false;
	}
	

}

