package org.junit;

	import static org.junit.Assert.*;

	import org.junit.Test;


	public class ComplexTest {
		
		double EPSILON = 0.0001;

		@Test
		public void test_Complex2Args() {
			Complex c = new Complex(42.0, 60.0);
			assertEquals( c.getReal(), 42.0, EPSILON );
			assertEquals( c.getImag(), 60.0, EPSILON );
		}
		
		@Test
		public void test_Complex0Args() {
			Complex c = new Complex();
			assertEquals( c.getReal(), 0.0, EPSILON );
			assertEquals( c.getImag(), 0.0, EPSILON );
		}
		
		@Test
		public void test_add_1() {
			Complex c1 = new Complex(2.0,3.0);
			Complex c2 = new Complex(1.0,1.0);
			Complex c = c1.add(c2);
			assertEquals( c.getReal(), 3.0, EPSILON );
			assertEquals( c.getImag(), 4.0, EPSILON );
			assertEquals( c1, new Complex(2.0,3.0) );
			assertEquals( c2, new Complex(1.0,1.0) );
		}
		
		@Test
		public void test_addDest_1() {
			Complex c1 = new Complex(2.0,3.0);
			Complex c2 = new Complex(1.0,1.0);
			c1.addDest(c2);
			assertEquals( c1, new Complex(3.0, 4.0) );
			assertEquals( c1.getReal(), 3.0, EPSILON );
			assertEquals( c1.getImag(), 4.0, EPSILON );
			assertEquals( c2, new Complex(1.0,1.0) );
		}
		
		@Test
		public void test_negate_1() {
			Complex c1 = new Complex(2.0,3.0);
			Complex c2 = new Complex(-2.0,-3.0);
			assertEquals( c2, c1.negate() ); // uses c2.equals(...)
		}
		
		@Test
		public void test_negateDest_1() {
			Complex c1 = new Complex(2.0,3.0);
			Complex c2 = new Complex(-2.0,-3.0);
			c1.negateDest();
			assertEquals( c2, c1 ); // uses c2.equals(...)
		}
		
		@Test
		public void test_conjugate_1() {
			Complex c1 = new Complex(2.0,3.0);
			Complex c2 = new Complex(2.0,-3.0);
			assertEquals( c2, c1.conjugate() ); // uses c2.equals(...)
		}
		
		@Test
		public void test_conjugateDest_1() {
			Complex c1 = new Complex(2.0,3.0);
			Complex c2 = new Complex(2.0,-3.0);
			c1.conjugateDest();
			assertEquals( c2, c1 ); // uses c2.equals(...)
		}
		
		@Test
		public void test_multiply_1() {
			Complex c1 = new Complex(14.0,15.0);
			Complex c2 = new Complex(3.0,4.0);
			Complex c3 = new Complex(42.0,60.0);
			assertEquals( c3, c1.multiply(c2) ); // uses c3.equals(...)
		}

		@Test
		public void test_magnitude_1() {
			Complex c2 = new Complex(3.0,4.0);
			assertEquals( c2.magnitude(), 5.0, EPSILON );
		}
		
		@Test
		public void test_divide_1() {
			Complex c3 = new Complex(42.0,60.0);
			Complex c1 = new Complex(14.00,15.0);
			Complex c2 = new Complex(3.0,4.0);
			assertEquals( c2, c3.divide(c1) ); // uses c2.equals(...)
		}
	}

