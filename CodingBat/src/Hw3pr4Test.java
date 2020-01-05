
	import junit.framework.TestCase;

	public class Hw3pr4Test extends TestCase {

		/*
		 * Testing notString
		 */
		public void testNotString0() {
			assertTrue(Hw3pr4.notString("candy").equals("not candy"));
		}
		public void testNotString1() {
			assertTrue(Hw3pr4.notString("x").equals("not x"));
		}
		public void testNotString2() {
			assertTrue(Hw3pr4.notString("not bad").equals("not bad"));
		}
		public void testNotString3() {
			assertTrue(Hw3pr4.notString("bad").equals("not bad"));
		}
		public void testNotString4() {
			assertTrue(Hw3pr4.notString("not").equals("not"));
		}
		public void testNotString5() {
			assertTrue(Hw3pr4.notString("is not").equals("not is not"));
		}
		public void testNotString6() {
			assertTrue(Hw3pr4.notString("no").equals("not no"));
		}

		/*
		 * Testing missingChar
		 */
		public void testMissingChar0() {
			assertTrue(Hw3pr4.missingChar("kitten", 1).equals("ktten"));
		}
		public void testMissingChar1() {
			assertTrue(Hw3pr4.missingChar("kitten", 0).equals("itten"));
		}
		public void testMissingChar2() {
			assertTrue(Hw3pr4.missingChar("kitten", 4).equals("kittn"));
		}
		public void testMissingChar3() {
			assertTrue(Hw3pr4.missingChar("Hi", 0).equals("i"));
		}
		public void testMissingChar4() {
			assertTrue(Hw3pr4.missingChar("Hi", 1).equals("H"));
		}
		public void testMissingChar5() {
			assertTrue(Hw3pr4.missingChar("code", 0).equals("ode"));
		}
		public void testMissingChar6() {
			assertTrue(Hw3pr4.missingChar("code", 1).equals("cde"));
		}
		public void testMissingChar7() {
			assertTrue(Hw3pr4.missingChar("code", 2).equals("coe"));
		}
		public void testMissingChar8() {
			assertTrue(Hw3pr4.missingChar("code", 3).equals("cod"));
		}
		public void testMissingChar9() {
			assertTrue(Hw3pr4.missingChar("chocolate", 8).equals("chocolat"));
		}
		/*
		 * Testing FrontBack
		 */
		public void testfrontBack0() {
			assertTrue(Hw3pr4.frontBack("code").equals("eodc"));
		}
		public void testfrontBack1() {
			assertTrue(Hw3pr4.frontBack("a").equals("a"));
		}
		public void testfrontBack2() {
			assertTrue(Hw3pr4.frontBack("ab").equals("ba"));
		}
		public void testfrontBack3() {
			assertTrue(Hw3pr4.frontBack("abc").equals("cba"));
		}
		public void testfrontBack4() {
			assertTrue(Hw3pr4.frontBack("").equals(""));
		}
		public void testfrontBack5() {
			assertTrue(Hw3pr4.frontBack("Chocolate").equals("ehocolatC"));
		}
		public void testfrontBack6() {
			assertTrue(Hw3pr4.frontBack("aavJ").equals("Java"));
		}
		public void testfrontBack7() {
			assertTrue(Hw3pr4.frontBack("hello").equals("oellh"));
		}

		/*
		 * Testing front3
		 */
		public void testfront3_0() {
			assertTrue(Hw3pr4.front3("Java").equals("JavJavJav"));
		}
		public void testfront3_1() {
			assertTrue(Hw3pr4.front3("Chocolate").equals("ChoChoCho"));
		}
		public void testfront3_2() {
			assertTrue(Hw3pr4.front3("abc").equals("abcabcabc"));
		}
		public void testfront3_3() {
			assertTrue(Hw3pr4.front3("abcXYZ").equals("abcabcabc"));
		}
		public void testfront3_4() {
			assertTrue(Hw3pr4.front3("ab").equals("ababab"));
		}
		public void testfront3_5() {
			assertTrue(Hw3pr4.front3("a").equals("aaa"));
		}
		public void testfront3_6() {
			assertTrue(Hw3pr4.front3("").equals(""));
		}
		
		/*
		 * Testing backAround
		 */
		public void testBackAround0() {
			assertTrue(Hw3pr4.backAround("cat").equals("tcatt"));
		}
		public void testBackAround1() {
			assertTrue(Hw3pr4.backAround("Hello").equals("oHelloo"));
		}
		public void testBackAround2() {
			assertTrue(Hw3pr4.backAround("a").equals("aaa"));
		}
		public void testBackAround3() {
			assertTrue(Hw3pr4.backAround("abc").equals("cabcc"));
		}
		public void testBackAround4() {
			assertTrue(Hw3pr4.backAround("read").equals("dreadd"));
		}
		public void testBackAround5() {
			assertTrue(Hw3pr4.backAround("boo").equals("obooo"));
		}
		/*
		 * Testing front22
		 */
		public void testfront22_0() {
			assertTrue(Hw3pr4.front22("kitten").equals("kikittenki"));
		}
		public void testfront22_1() {
			assertTrue(Hw3pr4.front22("Ha").equals("HaHaHa"));
		}
		public void testfront22_2() {
			assertTrue(Hw3pr4.front22("abc").equals("ababcab"));
		}
		public void testfront22_3() {
			assertTrue(Hw3pr4.front22("ab").equals("ababab"));
		}
		public void testfront22_4() {
			assertTrue(Hw3pr4.front22("a").equals("aaa"));
		}
		public void testfront22_5() {
			assertTrue(Hw3pr4.front22("").equals(""));
		}
		public void testfront22_6() {
			assertTrue(Hw3pr4.front22("Logic").equals("LoLogicLo"));
		}
		
		/*
		 * Testing startHi
		 */

		public void testStartHi0() {
			assertTrue(Hw3pr4.startHi("hi there"));
		}
		public void testStartHi1() {
			assertTrue(Hw3pr4.startHi("hi"));
		}
		public void testStartHi2() {
			assertTrue(Hw3pr4.startHi("hi ho"));
		}
		public void testStartHi3() {
			assertFalse(Hw3pr4.startHi("hello hi"));
		}
		public void testStartHi4() {
			assertFalse(Hw3pr4.startHi("he"));
		}
		public void testStartHi5() {
			assertFalse(Hw3pr4.startHi("h"));
		}
		public void testStartHi6() {
			assertFalse(Hw3pr4.startHi(""));
		}
		public void testStartHi7() {
			assertFalse(Hw3pr4.startHi("ho hi"));
		}
		
		/*
		 * Testing startOz
		 */
		public void testStartOz0() {
			assertTrue(Hw3pr4.startOz("ozymandias").equals("oz"));
		}
		public void testStartOz1() {
			assertTrue(Hw3pr4.startOz("bzoo").equals("z"));
		}
		public void testStartOz2() {
			assertTrue(Hw3pr4.startOz("oxx").equals("o"));
		}
		public void testStartOz3() {
			assertTrue(Hw3pr4.startOz("oz").equals("oz"));
		}
		public void testStartOz4() {
			assertTrue(Hw3pr4.startOz("ounce").equals("o"));
		}
		public void testStartOz5() {
			assertTrue(Hw3pr4.startOz("o").equals("o"));
		}
		public void testStartOz6() {
			assertTrue(Hw3pr4.startOz("abc").equals(""));
		}
		public void testStartOz7() {
			assertTrue(Hw3pr4.startOz("").equals(""));
		}
		public void testStartOz8() {
			assertTrue(Hw3pr4.startOz("zoo").equals(""));
		}
		public void testStartOz9() {
			assertTrue(Hw3pr4.startOz("aztec").equals("z"));
		}
		public void testStartOz10() {
			assertTrue(Hw3pr4.startOz("zzzz").equals("z"));
		}
		public void testStartOz11() {
			assertTrue(Hw3pr4.startOz("oznic").equals("oz"));
		}
		
	}

