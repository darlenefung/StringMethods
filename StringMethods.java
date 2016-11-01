public class StringMethods
{
	public static void main(String[] args)
	{
		System.out.println("------ findString ------");
		System.out.println(findString("abcabcdabc", "abc", 2));
		System.out.println(findString("abcd", "ef", 1));

		System.out.println("----- countStrings -----");
		System.out.println(countStrings("abcabcdabc", "abc"));
		System.out.println(countStrings("abcd", "ef"));


	}
	
	
	/**
	 * Finds the first instance of s in line,
	 * starting at the position start
	 * @param o the orignal string 
	 * @param s the string to find 
	 * @param start the position to start searching.
	 * Guaranteed to be in the string line. (precondition)
	 * @return the index of the first single instance of
	 * s if the string is found OR -1 if it is not found.	 
	 */
	public static int findString(String o, String s, int start)
	{
		String truncated = o.substring(start);
		if (truncated.indexOf(s) == -1)
			return -1; 
		else 
			return truncated.indexOf(s) + start;
	}
	
	/**
	 * Count the number of times instances of s appear in
	 * the line.
	 * @param o the original string
	 * @param s the string to find.
	 * @return the number of times the string appears in the line
	 */
	public static int countStrings(String o, String s)
	{	
		int isFound = findString(o, s, 0);
		if ((o.length() >= 0) && (isFound >= 0))
			return 1 + countStrings(o.substring(isFound + 1), s);
		else
			return 0;
	}
}
