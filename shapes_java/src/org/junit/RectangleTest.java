package org.junit;

import static org.junit.Assert.*;

public class RectangleTest {
	@Test
	public void testgetWidth(){
		Rectangle X = new Rectangle();
		int testwidth = X.getWidth();//width always starts at 2
		assertEquals(testwidth,10);
		
	}
	@Test
	public void testgetHeight(){
		Rectangle X = new Rectangle();
		int testheight = X.getHeight();//height always starts at 2
		assertEquals(testheight,5);
	}
	@Test
	public void testgetXcord(){
		Rectangle X = new Rectangle();
		int testxcord = X.getxcord();//X coordinate always starts at "0"
		assertEquals(testxcord,0);
	}
	@Test
	public void testgetYcord(){
		Rectangle X = new Rectangle();
		int testycord = X.getycord();//X coordinate always starts at "0"
		assertEquals(testycord,5);
	}
	
	
	
	
	
	@Test
	public void testgetarea(){
		Rectangle X = new Rectangle();
		int testarea = X.getArea();
		assertEquals(testarea,50);
	}
	@Test
	public void testgetperimeter(){
	Rectangle X = new Rectangle();
	int testperim = X.getPerimeter();
	assertEquals(testperim, 30);
	}
	
	
	@Test
	public void testsetWidth(){
		Rectangle X = new Rectangle();
		X.setWidth(20);
		int newwidth = X.getWidth();
		assertEquals(newwidth, 20);
	}
	@Test
	public void testsetHeight(){
	Rectangle X = new Rectangle();
	X.setHeight(500);
	int newheight = X.getHeight();
	assertEquals(newheight, 500);
	}


	@Test
	public void testsetArea(){
		Rectangle X = new Rectangle();
		X.setArea(10, 10);
		int newarea = X.getHeight() * X.getWidth();
		assertEquals(newarea,100);
	}
	
	@Test
	public void testsetPerim(){
		Rectangle X = new Rectangle();
		X.setPerim(15, 10);
		int newperim = 2*X.getHeight() + 2*X.getWidth();
		assertEquals(newperim, 50);
		
	}
	
	@Test
	public void testcheckoverlap(Rectangle r){
		r.blxcord = 6;
		r.blycord = 7;
		r.height = 5;
		r.width = 4;
		boolean X = r.checkoverlap(r);
		assertEquals(true,X);

	}
	
}










