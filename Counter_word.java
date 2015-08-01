/*
 * WordCount.java
 * 
 * $Id$
 *
 * $Log$
 */

/*
 * Count the occurence of words in a file and print them out
 * ordered by their word count.
 *
 * @author: Sean Strout
 */

import java.util.*;	// HashMap, HashMap
import java.io.*;	// BufferedReader, FileReader, IOException

public class Counter_word {
	public static void main(String args[]) throws IOException {
	
		/*if (args.length != 1) {
			System.err.println("Usage: java WordCount text-file");
			System.exit(-1);
		}*/

		//String filename = "//Users//rsalecha//Downloads//jate_test//littleItalyReview.rtf";
		BufferedReader input = new BufferedReader
			(new FileReader("//Users//rsalecha//Downloads//jate_test//littleItalyReview.rtf"));

		String line;
		HashMap<String, Integer> map = 
			new HashMap<String, Integer>();

		// read in all the lines from the file
		while ((line = input.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, " ,.-");

			// process each word wrt the map
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				if (map.get(word) != null) {
					// another occurence of an existing
					// word
					int count = map.get(word);
					count++;
					map.put(word, count);
				} else {
					// first occurence of this word
					map.put(word, 1);
				}
			}
		}

		System.out.println("Unsorted map: " + map);
		System.out.println();

		// Now that all the words/counts are in the map, sort them 
		// based on frequency.  To do this, use WordOccurence.

		// Create an array list to hold the WordOccurrence objects.
		ArrayList<WordOccurrence> list = 
			new ArrayList<WordOccurrence>(map.size());

		// Get the set of words from the map
		Set<String> words = map.keySet();

		// Loop over the words in the map
		Iterator<String> iter = words.iterator();
		while (iter.hasNext()) {
			String word = iter.next();
			// Create a WordOccurrence object for each word/count 
			// pair
			WordOccurrence pair = 
				new WordOccurrence(word, map.get(word));

			// Add it into the list
			list.add(pair);
		}

		// sort the list using the WordOccurrence (which implements
		// Comparable)
		Collections.sort(list);

		// Print out the elements in the list that are now ordered
		// by frequency. 
		System.out.println("Words sorted by frequency: " + list);
		
	} // main
} // WordCount
