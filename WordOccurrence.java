/*
 * WordOccurrence.java
 *
 * $Id$
 *
 * $Log$
 */

/*
 * A utility class for sorting words by frequency.
 *
 * @author: Sean Strout
 */

import java.util.*;

public class WordOccurrence implements Comparable<WordOccurrence> {

	private String word;
	private int count;

	/**
	 * Construct the object
	 *
	 * @param	word	the word
	 * @param	count	the frequency count for the word
	 */
	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}

	/**
	 * Compare one object to another by descending frequency
	 *
	 * @param	other	the other object
	 */
	public int compareTo(WordOccurrence other) {
		if (other.count > count) {
			return 1;
		} else if (count == other.count) {
			return word.compareTo(other.word);
		} else {
			return -1;
		}
	} // compareTo

	/**
	 * Print a string representation of the object
	 */
	public String toString() {
		return word + " = " + count;
	}

} // WordOccurrence
