import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {


	@Test
	public void testdifferentnames(){
		
		Person Zelda = new Person("Zelda", 70);
		
		Person Patrick = new Person("Patrick",80);
		
		int winner = Patrick.compareTo(Zelda);
		
		assertEquals(1,winner);
		
	}
	
	@Test 
	public void testdifferentages(){
		
		Person X = new Person("Zelda", 70);
		
		Person Y  = new Person("Zelda",80);
		
		int winner = X.compareTo(Y);
		
		assertEquals(winner,1);
		
	}
	@Test
	public void testsamefirstletter(){
		
		Person X = new Person("John", 15);
		
		Person Y  = new Person("James",20);
		
		int winner = X.compareTo(Y);
		
		assertEquals(winner,2);
	}
	@Test
	public void testsamedata(){
		
		Person X = new Person("James", 15);
		
		Person Y  = new Person("James",15);
		
		int winner = X.compareTo(Y);
		
		assertEquals(winner,3);
	}
	@Test
	public void testotherconstructor(){
		
		Person X = new Person();
		Person Y = new Person("Matt",81);
		
		int winner = X.compareTo(Y);
		assertEquals(winner,2);
	}
	@Test
	public void teststaticrefs(){
		
		Comparable X = new Person("John", 15);
		
		Comparable Y  = new Person("James",15);
		
		int winner = X.compareTo(Y);
		
		assertEquals(winner,2);
	}
	@Test
	public void testmorestaticrefs(){
		
		Comparable X = new Person("James", 15);
		
		Comparable Y  = new Person("James",15);
		
		int winner = X.compareTo(Y);
		
		assertEquals(winner,3);		
		
	}
	@Test
	public void testagesum(){
		Person one = new Person("Matt",10);
		Person two = new Person("Sera", 20);
		Person three = new Person("Anant" ,50);
		String winners = one.juggle(two,three);
		assertEquals("Sera and Anant",winners);
		
	}
	@Test
	public void testequalages(){
		Person one = new Person("Matt",10);
		Person two = new Person("Sera", 10);
		Person three = new Person("Anant" ,10);
		String winners = one.juggle(two,three);
		assertEquals(null,winners);
	}
	@Test 
	public void teststaticrefs1(){
		Juggler one = new Person("Matt",10);
		Juggler two = new Person("Sera", 10);
		Juggler three = new Person("Anant" ,10);
		String winners = one.juggle(two,three);
		assertEquals(null,winners);
	}
	
	@Test
	public void testjugglerecord(){
		Person one = new Person("Matt",10);
		Person two = new Person("Sera", 20);
		Person three = new Person("Anant" ,50);
		int winners = one.juggleRecord(two,three);
		assertEquals(70,winners);
	}
	@Test
	public void testjugglerrecord(){
		Person one = new Person("Matt",10);
		Person two = new Person("Sera", 10);
		Person three = new Person("Anant" ,10);
		int winners = one.juggleRecord(two,three);
		assertEquals(0,winners);
	}
	@Test
	public void teststaticrefjugrec(){
		Juggler one = new Person("Matt",10);
		Juggler two = new Person("Sera", 10);
		Juggler three = new Person("Anant" ,10);
		int winners = one.juggleRecord(two,three);
		assertEquals(0,winners);
	}
	@Test
	public void teststaticrefjugrec1(){
		Juggler one = new Person("Matt",10);
		Juggler two = new Person("Sera", 20);
		Juggler three = new Person("Anant" ,50);
		int winners = one.juggleRecord(two,three);
		assertEquals(70,winners);
	}
}

	
	
	

		
	
	


