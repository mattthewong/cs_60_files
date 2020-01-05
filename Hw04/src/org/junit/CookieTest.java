package org.junit;

import static org.junit.Assert.*;
import junit.framework.TestCase;

public class CookieTest {
	@Test 
	public void testFileSetUp() {
		System.out.println("One test ran!");
		assertTrue(3<4);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void getType(){
		Cookie X = new Cookie("chocolate chip");
		assertEquals(X.getType(),("chocolate chip"));
		System.out.println("Test two ran!");
	}
	@Test
	public void getCalories(){
		Cookie X = new Cookie("chocolate chip");
		assertEquals(X.getCalories(),500);
		
	}
	
	@Test
	public void listIngredients(){
		Cookie X = new Cookie("chocolate chip");
		assertEquals(X.listIngredients(), "[chocolate chips, butter, sugar, eggs, flour]");
		
	}
	
	@Test 
	public void addIngredient(){
		Cookie X = new Cookie("chocolate chip");
		String total = "[chocolate chips, butter, sugar, eggs, flour, sugar]";
		X.addIngredient("sugar");
		
		assertEquals(total, X.listIngredients());
	}
	
	@Test
	public void testcookiecount(){
		int count = Cookie.cookieCount;
		assertEquals(count, 0);
		Cookie A = new Cookie();
		count = Cookie.cookieCount;
		assertEquals(count, 1);
		Cookie B = new Cookie();
		count = Cookie.cookieCount;
		assertEquals(count, 2);
		Cookie C = new Cookie();
		count = Cookie.cookieCount;
		assertEquals(count, 3);
		Cookie D = new Cookie();
		count = Cookie.cookieCount;
		assertEquals(count, 4);
		
	}
	
	@Test
	public void testRNOC(){
		
		int count  = Cookie.rightNumberOfCookies();
		assertEquals(count, 6);
		
		
	}

		
	@Test
	
	public void testisDelicious(){
		assertEquals(true,Cookie.isDeliciousCookieType("Chocolate"));
	}
	
	@Test
	public void testaddcookie(){
	Cookie X = new Cookie();
	CookieBox Y = new CookieBox();
	Y.addCookie(X);
	assertEquals(Cookie.cookieCount, 1);
	
	
	}
	
	@Test
	public void testtotalcals(){
		Cookie X = new Cookie("chocolate chip");
		CookieBox Y = new CookieBox();
		Y.addCookie(X);
		assertEquals(Y.totalCaloriesInBox(), 500);
	
	}
}
	
	

	


