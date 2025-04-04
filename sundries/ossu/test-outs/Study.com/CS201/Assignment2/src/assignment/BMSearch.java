package assignment;

/*
 * BMSearch.java: An implementation of the "BMSearch"
 *   BMSearch is a class that contains the functionality
 *   needed to perform a Boyer-Moore Search. 
 *   
 *   This kind of search is smarter than a simple brute force 
 *   algorithm, and the "BMSearch" class is a group of Java methods
 *   that I have implemented, while citing "GeeksForGeeks", to
 *   demonstrate a product that makes use of the Boyer-Moore
 *   search to identify indices where pattern-matches have a
 *   positive match.
 *   
 * 
 * @author Alexander Ahmann <alexander.ahmann@snhu.edu>
 */
public class BMSearch {
	
	private int BC_BUFFER_SIZE;
	
	/*
	 * The constructor takes in an integer called the "BC_BUFFER_SIZE",
	 *   which is how big the "bad character" array will be. I recommend
	 *   setting this to the size of the text corpus being searched.
	 */
	public BMSearch(int BC_BUFFER_SIZE) {
		this.BC_BUFFER_SIZE = BC_BUFFER_SIZE;
	}
	
	/*
	 * Public method that embodies the main logic of the
	 *   Boyer-Moore Search Algorithm. I referenced "Geeks-
	 *   -forGeeks" (Mar. 11, 2024) when writing this method,
	 *   and I wrote it in accordance with the requirements
	 *   outlined in "Study.com" (n.d.).
	 *   
	 * @param input      the text corpus to search
	 * @param pattern    the pattern to identify
	 */
	public void BoyerMooreIndex(String input, String pattern) {
		// Begin by expressing strings as character arrays
		char[] inputArray = input.toCharArray();
		char[] patternArray = pattern.toCharArray(); /* Note that for the
		  char[] variables of inputArray and patternArray, I referenced
		  "GeeksForGeeks" (Jan. 4, 2025) when implementing them */
		
		// Also, calculate the length of the "inputArray", and the "patternArray"
		int slen = inputArray.length; // length of "input" as a character array.
		int plen = patternArray.length; // length of "pattern" as a character array.
		
		/* Declare a BAD_CHARACTERS integer array and populate it with "anti-
		 * -pattern" characters for the algorithm to avoid ... */
		int[] BAD_CHARACTERS = this.BadCharacterRule(patternArray);
		
		/* This is the main logic of the Boyer-Moore search: it works by putting a 
		 *   "bad character heuristic" to identify characters to avoid, and to enum-
		 *   -erates the text to be searched, and then prints out the index at where
		 *   pattern shifts occur, as outlined by the "Study.com" (n.d.) constraints.
		 *   
		 * Variables:
		 *   shiftPos = the shift at where a pattern match is found
		 *   slen, plen = the number of characters in the text corpus and
		 *     pattern search, respectively.
		 *   minFactor = an integer that stands for a condition used by the
		 *     algorithm as a basis for determining whether a shift is detected
		 *     in the current position.
		 */
		
		int shiftPos = 0;
		while (shiftPos <= (slen - plen)) {
			int minFactor = plen - 1;
			while (minFactor >= 0 && patternArray[minFactor] == inputArray[shiftPos + minFactor])
				minFactor--;
			if (minFactor < 0) {
				System.out.printf("Pattern occured at shift: %d\n", shiftPos);
				if (shiftPos + plen < slen)
					shiftPos += plen - BAD_CHARACTERS[inputArray[shiftPos + plen]];
				else
					shiftPos += 1;
			} else
				shiftPos += this.BiggerInt(1, minFactor - BAD_CHARACTERS[inputArray[shiftPos + minFactor]]);
		}
		
	} /* Note that this method references 
	  "GeeksForGeeks" (Mar. 11, 2024) */
	
	/*
	 * Private method that implements the "bad character
	 *   rule" employed by the Boyer-Moore Search. The
	 *   procedure adds identified "bad characters" to
	 *   the private integer array of BAD_CHARACTERS.
	 * @param str    the search pattern
	 * @returns an integer array of "bad characters".
	 */
	private int[] BadCharacterRule(char[] pattern) {
		/* First, initialize a populate the BAD_CHARACTERS array 
		 * with a buffer size defined by BC_BUFFER_SIZE ... */
		int[] BAD_CHARACTERS = new int[this.BC_BUFFER_SIZE];
		
		for (int i = 0; i < this.BC_BUFFER_SIZE; i++)
			BAD_CHARACTERS[i] = -1;
		
		/* Then proceed to populate the BAD_CHARACTERS array
		 with "anti characters" to be processed by the Boyer-Moore
		 search procedure .... */
		for (int i = 0; i < pattern.length; i++)
			BAD_CHARACTERS[(int)pattern[i]] = i;
		
		return BAD_CHARACTERS; /* Finally, return the bad 
		  characters identified by this method */
	} /* Note that this method references 
	   "GeeksForGeeks" (Mar. 11, 2024) */
	
	/*
	 * Private method that returns the greater
	 *   integer given two integers
	 * 
	 * @param a    an integer
	 * @param b    another integer
	 * @returns the greater integer between 
	 *   a and b
	 */
	private int BiggerInt(int a, int b) {
		if (a > b)
			return a;
		return b;
	} /* Note that this method references
	   "GeeksForGeeks" (Mar. 11, 2024) */
}

/*
 * References
 * 1. Study.com (n.d.). Computer Science 201 - Assignment 2: Searching Text & String Data. Retrieved on Mar. 12, 2025 
 *   from: https://study.com/academy/lesson/computer-science-201-assignment-2-searching-text-string-data.html
 * 2. Wikipedia (c.a. Mar. 11, 2025). List of states and territories of the United States. Retrieved on Mar. 12, 2025
 *   from: https://en.wikipedia.org/w/index.php?title=List_of_states_and_territories_of_the_United_States&oldid=1279977691
 * 3. Google AI (2025) (Mar. 12, 2025 version). Large Language Model. https://google.com/
 * 4. w3schools (n.d.). Java Read Files. Retrieved on Mar. 12, 2025 from:
 *     http://w3schools.com/java/java_files_read.asp
 * 5. "Geeks4Geeks" (Mar. 11, 2024). Boyer Moore Algorithm for Pattern Searching. Retrieved on Mar. 25, 2025 from:
 *    https://www.geeksforgeeks.org/boyer-moore-algorithm-for-pattern-searching/
 * 6. "Geeks4Geeks" (Jan. 4, 2025). Convert a String to Character Array in Java. Retrieved on Mar. 25, 2025 from:
 *    https://www.geeksforgeeks.org/convert-a-string-to-character-array-in-java/
 */