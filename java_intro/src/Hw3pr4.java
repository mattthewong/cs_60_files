
	/*
	 * Fill in the body of the methods below based upon the specification
	 * provided. It may be helpful to look at the test cases provided in
	 * Hw2pr2Test.java to understand the intended behavior of the method.
	 * 
	 * All content is based upon problems at CodingBat.com
	 */

	public class Hw3pr4 {

		// Source: http://codingbat.com/prob/p191914
		/*
		 * Given a string, return a new string where "not " has been added to the
		 * front. However, if the string already begins with "not", return the
		 * string unchanged. Note: use .equals() to compare 2 strings.
		 */
		public static String notString(String str) {
			if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
			    return str;
			  }
			  
			  return "not " + str;
		}

		// Source: http://codingbat.com/prob/p190570
		/*
		 * Given a non-empty string and an int n, return a new string where the char
		 * at index n has been removed. The value of n will be a valid index of a
		 * char in the original string (i.e. n will be in the range
		 * 0..str.length()-1 inclusive).
		 */
		public static String missingChar(String str, int n) {
			return str.substring(0,n) + str.substring(n+1, str.length());
		}

		// Source: http://codingbat.com/prob/p123384
		/*
		 * 
		 * Given a string, return a new string where the first and last chars have
		 * been exchanged.
		 */
		public static String frontBack(String str) {
			return str.charAt(str.length()-1) + str.substring(1,str.length()-1) + str.charAt(0);
			
		
					
		}

		// Source: http://codingbat.com/prob/p136351
		/*
		 * Given a string, we'll say that the front is the first 3 chars of the
		 * string. If the string length is less than 3, the front is whatever is
		 * there. Return a new string which is 3 copies of the front.
		 */
		public static String front3(String str){
			String beginning;
			if (str.length() >= 3){
			
			beginning = str.substring(0,3);
			}
			else{
			beginning = str;
			}
			return beginning + beginning + beginning;
		
		}

		// Source: http://codingbat.com/prob/p161642
		/*
		 * Given a string, take the last char and return a new string with the last
		 * char added at the front and back, so "cat" yields "tcatt". The original
		 * string will be length 1 or more.
		 */
		public static String backAround(String str) {
			char end = str.charAt(str.length()-1);
			return end + str + end;
		}

		// Source: http://codingbat.com/prob/p183592
		/*
		 * Given a string, take the first 2 chars and return the string with the 2
		 * chars added at both the front and back, so "kitten" yields"kikittenki".
		 * If the string length is less than 2, use whatever chars are there.
		 */
		public static String front22(String str) {
			 String start = str.substring(0,2);
			 return start + str + start;
			 
		}

		// Source: http://codingbat.com/prob/p191022
		/*
		 * Given a string, return true if the string starts with "hi" and false
		 * otherwise.
		 */
		public static boolean startHi(String str) {
			if (str.length() < 2){
			return false;
			}
			if (str.substring(0,2).equals("hi")){
				return true;
			}
			return false;
		}

		// Source: http://codingbat.com/prob/p199720
		/*
		 * Given a string, return a string made of the first 2 chars (if present),
		 * however include first char only if it is 'o' and include the second only
		 * if it is 'z', so "ozymandias" yields "oz".
		 */
		public static String startOz(String str) {
			String output = "";
			  
			  if (str.length() >= 1 && str.charAt(0)=='o') {
			    output = output + str.charAt(0);
			  }
			  
			  if (str.length() >= 2 && str.charAt(1)=='z') {
			    output = output + str.charAt(1);
			  }
			  
			  return output;
			}
		
			

		public static void main(String[] args) {
			System.out.println("Run the file Hw3pr4Test.java not Hw3pr4.java");
		}

	}

