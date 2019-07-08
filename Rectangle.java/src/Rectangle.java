	/** An instance maintains the length and width of a rectangle. */
	public class Rectangle {
		/** If this rectangle is square, length is its length and width and width is null. */
		private Double length;
		/** If this rectangle is not square, length is its length and width is its width.*/
		private Double width;
		
	    /** Constructor: a rectangle with length l and width w.
	      * Throw an exception l or w if negative. */
		public Rectangle(double l, double w) {
			length= l;
			width= w;
			assert(l>0);
			assert(w>0);
		}

	    /** Constructor: a l x l square.
	      * Throw an exception if l negative. */
		public Rectangle(double l) {
			length= l;
			assert(l>0);
		}
		
		/** = the length of the rectangle */
		public double getLength() {
			return length;
		}
		
		/** = the width of the rectangle */
		public double getWidth() { 
			return width;
		}
		
		/** Set the length of the rectangle to length */
		public void setLength(double length) { 
			this.length= length;
			assert (length>0);
		}
		
		/** Set the width of the rectangle to width */
		public void setWidth(double width) { 
			this.width= width;
			assert (width>0);
		}
		
		/** = the area of the rectangle */
		public Double getArea() { 
			return length * width;
		}

		/** = the perimeter of the rectangle */
		public Double getPerimeter(){
			if (width != null) {
				return 2*(length + width);
			} 
			return 4 * length;
		}
	}
