	/*
	 *
	 * a data structure that represents a 2d point
	 * 
	 * Note the similarity to Complex numbers :-)
	 *
	 */

	class Point {
		private double x;
		private double y;

		/**
		 * @return the x
		 */
		public double getX() {
			return x;
		}

		/**
		 * @param x
		 *            the x to set
		 */
		public void setX(double x) {
			this.x = x;
		}

		/**
		 * @return the y
		 */
		public double getY() {
			return y;
		}

		/**
		 * @param y
		 *            the y to set
		 */
		public void setY(double y) {
			this.y = y;
		}

		/**
		 * two-input constructor
		 * 
		 * @param x_in
		 *            input x value
		 * @param y_in
		 *            input y value
		 */
		public Point(double x_in, double y_in) {
			this.x = x_in;
			this.y = y_in;
		}

		/**
		 * zero-input constructor
		 */
		public Point() {
			this(0.0, 0.0); // calls the constructor above
		}

		/**
		 * deep equality ~ test for same Point location
		 * 
		 * @param obj
		 *            , the object being compared to this
		 * @return whether obj and this are (1) both Point objects and (2) at the
		 *         same location, up to the error margin, EPSILON
		 */
		public boolean equals(Object obj) {
			if (this.getClass() != obj.getClass())
				return false; // different class? false!

			// We know obj is a Point, ...
			Point p = (Point) obj; // so we cast it to one

			double EPSILON = 0.000001;
			if (Math.abs(this.x - p.x) < EPSILON
					&& Math.abs(this.y - p.y) < EPSILON)
				return true;
			else
				return false;
		}

		// yes, we should have hashCode here...

		/**
		 * auto-generated toString method
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		// method: add
		// in: a Point, p
		// out: a new Point that is the sum of this and p
		/**
		 * method to return the sum of this and p
		 * 
		 * @param p
		 *            another Point object
		 * @return a new Point, the sum of this and p
		 */
		public Point add(Point p) {
			return new Point(this.x + p.x, this.y + p.y);
		}

		/**
		 * scales this by the value of sc; returns a new pt.
		 * 
		 * @param sc
		 *            , the scaling factor
		 * @return a new Point that is a scaled version of this
		 */
		public Point scale(double d) {
			return new Point(d * this.x, d * this.y);
		}

		// method: isSmaller
		// in: a Point, p
		// out: whether or not this is closer to the origin than p
		/**
		 * returns true if the magnitude of this is smaller than the magnitude of
		 * the input, p
		 * 
		 * @param p
		 *            , another Point object
		 * @return true if this is closer to the origin than p, otherwise, false.
		 */
		public boolean isSmaller(Point p) {
			// could be more concise, but it's not bad to
			// see how to call Math functions
			// the Java API lists them all (Google for "Java 1.7 API")
			double magThis = Math.sqrt(this.x * this.x + this.y * this.y);
			double magOfp = Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2));
			return (magThis < magOfp);
		}

		/**
		 * main is the start of execution It's a good place for small tests and
		 * print statements.
		 */
		public static void main(String[] args) {
			Point p1 = new Point(30, 40);
			Point p2 = new Point(12, 2);
			Point p3 = p1.add(p2);

			System.out.println("p1 is " + p1);
			System.out.println("p2 is " + p2);
			System.out.println("p3 (sum) is " + p3);

			Point p4 = p1.scale(0.5);
			System.out.println("p4 is " + p4);

			if (p2.isSmaller(p1)) {
				System.out.println("p2 IS smaller than p1.");
			} else {
				System.out.println("p2 is NOT smaller than p1!");
				
			}

		}

	}

