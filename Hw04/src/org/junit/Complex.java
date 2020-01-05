package org.junit;

	/**
	 * Complex class
	 * 
	 * This class creates Objects that can represent Complex #s.
	 * 
	 * It uses two data members, real and imag, bouth doubles
	 * 
	 * @author 
	 * 
	 * Comments/notes:
	 */
	public class Complex {
		
		private double real;
		private double imag;
		

		/****************
		 * Constructors
		 *****************/
		
		/**
		 * two-input constructor
		 * @param x
		 * @param y
		 */
		public Complex(double real_in, double imag_in) {
			this.real = real_in;
			this.imag = imag_in;
		}
		
		/**
		 * zero-input constructor
		 */
		public Complex() {
			this(0.0,0.0);
		}

		/**************************
		 * Setters and getters 
		 **************************/
		
		
		
		/**
		 * @return the real
		 */
		public double getReal() {
			return this.real; // here, "this" is optional
		}
		
		/**
		 * @param real the real to set
		 */
		public void setReal(double real) {
			this.real = real;
		}

		/**
		 * @return the imag
		 */
		public double getImag() {
			return imag;
		}

		/**
		 * @param imag the imag to set
		 */
		public void setImag(double imag) {
			this.imag = imag;
		}
		

		/***************************************
		 * capabilities (methods/functions)
		 ***************************************/
		
		/**
		 * checks if this is "close enough" to the input ob
		 * to be considered equal
		 * @return whether this and ob are considered equal
		 */
		public boolean equals( Object ob )
		{
			if (ob.getClass() != this.getClass()) return false;
			Complex c = (Complex)ob; // CAST to a Complex object
			double EPSILON = 0.000001; 
			if (Math.abs( c.getReal()-this.getReal() ) < EPSILON &&
				Math.abs( c.getImag()-this.getImag() ) < EPSILON)
				return true;
			else
				return false;
		}
		// Java police - yes - hashCode should be here, too



		/** auto-generated toString method
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Complex [real=" + real + ", imag=" + imag + "]";
		}
		

		/**
		 * add computes a new Complex obj that is the sum of this and c
		 * @param c the second added
		 * @return the new Complex object
		 */
		public Complex add( Complex c ) {
			double real = (this.getReal() + c.getReal());
			double imag = (this.getImag() + c.getImag());
			return new Complex(real,imag);
			
			
		}
		
		
		/**
		 * addDest is a _destructive_ addition of c into this
		 * this object gets changed; the input, c, does not change
		 * @param c another Complex number
		 */
		public void addDest( Complex c ) {
			this.real = (this.getReal() + c.getReal());
			this.imag = (this.getImag() + c.getImag());
			
		}
		
		
		/**
		 * negate returns a new Complex, the additive inverse of this
		 * @return the additive inverse of this (a new object)
		 */
		public Complex negate( ) {
			this.real = (this.real *-1);
			this.imag = (this.imag *-1);
			return new Complex(this.real, this.imag);
			
		}
		
		/**
		 * negateDest does *not* create a new Complex, but simply changes the
		 * fields of this object (this.real and this.imag)
		 */
		public void negateDest() {
			this.real = (this.real *-1);
			this.imag = (this.imag *-1);
			
		}
		
		/**
		 * conjugate creates a new Complex object holding this's conjugate
		 * @return the conjugate of this
		 */
		public Complex conjugate( ) {
			return new Complex(this.real, this.imag*-1);
		}
		
		/**
		 * conjugateDest does *not* create a new Complex, but simply changes the
		 * fields of this object (this.real and this.imag)
		 */
		public void conjugateDest( ) {
			this.real = (this.real);
			this.imag = (this.imag *-1);
		}
		
		
		/**
		 * returns the product of this and c
		 * @param c another Complex object
		 * @return their product
		 */
		public Complex multiply( Complex c ) {
			return new Complex((this.real*c.real),(this.imag*c.imag));
			
			
		}
		
		/**
		 * compute the distance of this from the origin
		 * @return the magnitude of this
		 */
		public double magnitude() {
			
			double mag = Math.sqrt((this.real * this.real) + (this.imag * this.imag));
			return mag;
			
			
		}
		
		/**
		 * returns the quotient:  this/c (null if c == 0.0)
		 * @param c the divisor
		 * @return the quotient
		 */
		public Complex divide( Complex c ) {
			if (c.real == 0.0){
				return null;
			}
			if (c.imag == 0.0){
				return null;
			}
			else return new Complex((this.real / c.real),(this.imag/c.imag));
		
		}
	

		
		/**
		 * main is where things begin...
		 * @param args the input String array
		 */
		public static void main(String[] args) {
			System.out.println("Where the Complex...  isn't!");
			Complex c = new Complex();
			Complex c2 = new Complex(42,60);
			System.out.println("c is " + c);
			System.out.println("c2 is " + c2);
		}
		

	}


