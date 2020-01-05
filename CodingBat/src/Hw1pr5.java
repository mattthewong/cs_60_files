
	/*
	 * Fill in the body of the methods below based upon the specification
	 * provided. It may be helpful to look at the test cases provided in
	 * Hw1pr5Test.java to understand the intended behavior of the method.
	 * 
	 * All content is based upon problems at CodingBat.com
	 */

	public class Hw1pr5 {


		/*************************************************************
		*  STOP - if you haven't read the directions, do that first!
		**************************************************************/

		// Source: http://codingbat.com/prob/p187868
		/*
		 * The parameter weekday is true if it is a weekday, and the parameter
		 * vacation is true if we are on vacation. We sleep in if it is not a
		 * weekday or we're on vacation. Return true if we sleep in.
		 */
		/* I used part of the solution for this question. I did not know the "||"
		 * term to make the condition true. 
		 */
		public static boolean sleepIn1(boolean weekday, boolean vacation) {
			if (!weekday || vacation){
				return true;
		}
		return false;
	}

		// Source: http://codingbat.com/prob/p182873
		/*
		 * Given 2 ints, a and b, return true if one if them is 10 or if their sum
		 * is 10.
		 */
		public static boolean makes10(int a, int b) {
			return (a== 10 || b == 10 || a+b == 10);
			
		}

		// Source: http://codingbat.com/prob/p181646
		/*
		 * We have two monkeys, a and b, and the parameters aSmile and bSmile
		 * indicate if each is smiling. We are in trouble if they are both smiling
		 * or if neither of them is smiling. Return true if we are in trouble.
		 */
		public static boolean monkeyTrouble(boolean aSmile, boolean bSmile){
			if (aSmile == bSmile){
				return true;
			}
			return false;
			
		}

		// Source: http://codingbat.com/prob/p144535
		/*
		 * Given 2 int values, return true if either of them is in the range 10..20
		 * inclusive.
		 * Used the codingbat code here because I did not know how to use the and 
		 * conditional in Java.
		 */
		
		public static boolean in1020(int a, int b){
				  return ((10 <=a && a <=20) || (10<=b && b <=20));
		}

		// Source: http://codingbat.com/prob/p192082
		/*
		 * Given two temperatures, return true if one is less than 0 and the other
		 * is greater than 100.
		 */
		public static boolean icyHot(int temp1, int temp2) {
			return ((temp1 > 100 && temp2 < 0) || (temp2 > 100 && temp1 < 0));
		}

		// Source: http://codingbat.com/prob/p178986
		/*
		 * We'll say that a number is "teen" if it is in the range 13..19 inclusive.
		 * Given 3 int values, return true if 1 or more of them are teen.
		 */
		public static boolean hasTeen(int a, int b, int c) {
			return ((a>=13 && a<=19) ||(b>=13 && b<=19)||(c>=13 && c<=19));
		}

		// Source: http://codingbat.com/prob/p125339
		/*
		 * Given two non-negative int values, return true if they have the same last
		 * digit, such as with 27 and 57. Note that the % "mod" operator computes
		 * remainders, so 17 % 10 is 7.
		 */

		public static boolean lastDigit(int a, int b) {
			 return(a % 10 == b % 10);
		}

		private static Object mod(int a) {
			// TODO Auto-generated method stub
			return null;
		}

		// Source: http://codingbat.com/prob/p159227
		/*
		 * Given 2 int values, return true if one is negative and one is positive.
		 * Except if the parameter "negative" is true, then return true only if both
		 * are negative.
		 * Only used the "if(negative) statement, as I was unsure how to phrase the parameter
		 * as true.
		 */
		public static boolean posNeg(int a, int b, boolean negative) {
			if (negative) {
			    return (a < 0 && b < 0);
			  }
			  else {
			    return ((a < 0 && b > 0) ||(b < 0 && a > 0));
		}
}
		public static void main(String[] args) {
			System.out.println("Run the file Hw1pr5Test.java not Hw1pr5.java");
		}

	

	public static boolean sleepIn(boolean b, boolean c) {
		// TODO Auto-generated method stub
		return false;
	}
}
