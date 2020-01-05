import static org.junit.Assert.*;

	import org.junit.Test;

	public class PointTest {

		double EPSILON = 0.0001;

		@Test
		public void test_Point2Args() {
			Point p = new Point(42.0, 60.0);
			assertEquals(p.getX(), 42.0, EPSILON);
			assertEquals(p.getY(), 60.0, EPSILON);
		}

		@Test
		public void test_Point0Args() {
			Point p = new Point();
			assertEquals(p.getX(), 0.0, EPSILON);
			assertEquals(p.getY(), 0.0, EPSILON);
		}

		@Test
		public void test_equals() {
			Point c1 = new Point(2.0, 3.0);
			Point c2 = new Point(2, 3);
			assertEquals(c1, c2);
		}

		@Test
		public void test_add_1() {
			Point c1 = new Point(2.0, 3.0);
			Point c2 = new Point(1.0, 1.0);
			Point c = c1.add(c2);
			assertEquals(c.getX(), 3.0, EPSILON);
			assertEquals(c.getY(), 4.0, EPSILON);
		}

		@Test
		public void test_scale_1() {
			Point c1 = new Point(2.0, 3.0);
			double d = 10.0;
			Point c2 = c1.scale(d);
			Point c3 = new Point(20.0, 30.0);
			assertEquals(c2, c3); // uses c2.equals(...)
		}

		@Test
		public void test_isSmaller_1() {
			Point c1 = new Point(2.0, 3.0);
			Point c2 = new Point(20.0, 30.0);
			assertTrue(c1.isSmaller(c2));
			assertFalse(c2.isSmaller(c1));
		}

	
	}


