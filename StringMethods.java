public class StringMethods
{
	public static void main(String[] args)
	{
		System.out.println("------ findString ------");
		System.out.println(findString("", "", 0));
		System.out.println(findString("aaa", "a", 0));
		System.out.println(findString("aaa", "a", 1));
		System.out.println(findString("aaa", "a", 2));
		System.out.println(findString("aaa", "a", 3));
		System.out.println(findString("aaa", "a", 4));
		System.out.println("-------1");

		System.out.println(findString("aaa", "aa", 0));
		System.out.println(findString("aaa", "aa", 1));
		System.out.println(findString("aaa", "aa", 2));
		System.out.println(findString("aaa", "aa", 3));
		System.out.println(findString("aaa", "a", -1));
		System.out.println("-------2");


		System.out.println(findString("aaa", "aaa", 0));
		System.out.println(findString("aaa", "aaaa", 0));
		System.out.println(findString("aaa", "a", 0));
		System.out.println(findString("aaa", "b", 0));
		System.out.println(findString("aaa", "b", 1));
		System.out.println("-------3");
		System.out.println(findString("aaaz", "z", 0));
		System.out.println(findString("aaaz", "z", 1));
		System.out.println(findString("aaaz", "z", 2));
		System.out.println(findString("aaaz", "z", 3));
		System.out.println(findString("aaaz", "z", 4));
		System.out.println(findString("aaaz", "z", 5));
		System.out.println("-------4");

		System.out.println(findString("abcabcdabc", "abc", 2));
		System.out.println(findString("abcabcda b c", "a b c", 2));
		System.out.println(findString(" abcabcdabc ", "abc ", 2));
		System.out.println(findString(" abcabcdabc ", " abc ", 2));
		System.out.println(findString("abcd", "ef", 1));

		System.out.println("----- countStrings -----");
		System.out.println(countStrings("", ""));
		System.out.println(countStrings("aaa", "a"));
		System.out.println(countStrings("aaa", "aa"));
		System.out.println("-------");

		System.out.println(countStrings("aaaaaaaaa", "e"));
		System.out.println(countStrings("aaaaaaaaa", "a"));
		System.out.println(countStrings("aaaaaaaaa", "aa"));
		System.out.println(countStrings("aaaaaaaaa", "aaa"));
		System.out.println(countStrings("aaaaaaaaa", "aaaa"));
		System.out.println(countStrings("aaaaaaaaa", "aaaaa"));
		System.out.println(countStrings("aaaaaaaaa", "aaaaaaaaa"));
		System.out.println(countStrings("aaaaaaaaa", "aaaaaaaaaa"));
		System.out.println("-------");

		System.out.println(countStrings("xaaaaeaaaay", "a"));
		System.out.println(countStrings("xaaaaeaaaay", "aa"));
		System.out.println(countStrings("xaaaaeaaaay", "aaa"));
		System.out.println(countStrings("xaaaaeaaaay", "aaaa"));
		System.out.println(countStrings("xaaaaeaaaay", "aaaaa"));
		System.out.println(countStrings("xaaaaeaaaay", "aaaaaaaaa"));
		System.out.println(countStrings("xaaaaeaaaay", "aaaaaaaaaa"));
		System.out.println(countStrings("xaaaaeaaaay", "x"));
		System.out.println(countStrings("xaaaaeaaaay", "y"));
		System.out.println(countStrings("xaaaaeaaaay", "e"));
		
		System.out.println("-------");
		System.out.println(countStrings("abcabcdabc", "abc"));
		System.out.println(countStrings("abcd", "ef"));
		

		System.out.println("----- convertItalics -----");
		System.out.println(convertItalics(""));
		System.out.println(convertItalics("abc 123"));
		System.out.println(convertItalics("___hello"));
		System.out.println(convertItalics("a_b_c_d_e"));
		System.out.println(convertItalics("______"));
		System.out.println(convertItalics("_hello how are you today?_"));
		System.out.println(convertItalics(""));
		System.out.println(convertItalics("_abc abc. _"));



		//System.out.println(convertItalics("abc _is_ right"));
		//System.out.println(convertItalics("__abc__"));
		//System.out.println(convertItalics("_abc_123_xyz_"));
		//System.out.println(convertItalics("_abc_123"));
	
	//	System.out.println(convertItalics("This is _very_ good."));
	//	System.out.println(convertItalics("_This_ is _very_ _good_."));
	//	System.out.println(convertItalics("This is _very good."));
	//	System.out.println(convertItalics("This is __very good."));




	//	System.out.println(convertItalics("_abc_"));
	//	System.out.println(convertItalics("_abc_ 123 _xyz_"));






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
		if ((o.length() == 0 || s.length() == 0 || start < 0 || start > o.length() - 1))
			return -1;
		String truncated = o.substring(start);
		int foundIndex = truncated.indexOf(s);
		if (foundIndex > -1)
			return foundIndex + start;
		return -1;
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
		if (o.length() <= 0 || s.length() <= 0)
			return 0;
		int foundIndex = findString(o, s, 0);
		if (foundIndex >= 0)
			return 1 + countStrings(o.substring(foundIndex + s.length()), s);
		else
			return 0;
	}
	
	/**
 	* Replace all instances of underscores in the line given by
 	* line with italics tags.  There must be an even number of underscores
 	* in the line, and they will be replaced by <I>, </I>, alternating.
 	* @param line a string with 0 or more underscores
 	* @return the line that has underscores replaced with <I> </I> tags or 
 	* the original line if there are not an even number of underscores.
 	*/
 	public static String convertItalics (String line)
 	{
 		if (countStrings(line, "_") % 2 == 0)
 		{
 			int start = 0;
 			int Found1 = -1;
 			int Found2 = -1;
 			int x = 0;
 			String newString = "";
 			while (start < line.length() && (x = findString(line, "_", start)) != -1)
 			{
 				if (Found1 > -1)
 				{
 					Found2 = x;
 					if ((Found2 - Found1) != 1)
 					{
 						newString += "<I>" + line.substring(Found1 + 1, Found2) + "</I>";
 					}
 					else
 					{
 						newString += line.substring(Found1, Found2 + 1);
 					}
 					Found1 = -1;
 					Found2 = -1;
 				}
 				else
 				{
 					Found1 = x;
 					if (Found1 - start > 0)
 					{
 						newString += line.substring(start, Found1);
 					}
 				}
 				start = x + 1;
 				
 			}
 			newString += line.substring(start);
 			return newString;	
 		}	
 		return line;
 	}
}


 //			int start = 0;
 	//		int index = findString(line, "_", start);
 //		if (index > 0)
 	//			int Found1 = index - 1;
 	//			
 			
 			
 			
 	//		int index = 0;
 	//		while (index < line.length())
 	//		{
 	//			int startPosition = findString(line, "_", index);
 	//			int endPosition = findString(line, "_", index + 1);
 	//			if (startPosition > 0)
 	//				String before = line.substring(startPosition - 1, startPosition);
 	//			String after = line.substring(startPosition + 1, startPosition + 2);
 	//			if ((before == " ")  && (after > 64 && after < 123))
 	//			{
 	//				// replace 
 	//			}
 	//			if (endPosition < line.length() -1)	
 	//				String before 
 	//			else 	
 	//			{
 	//				String 
 	//			}
 	//		}
 	//	}
 	//	else
 	//		return line; 
