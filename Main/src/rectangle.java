public class rectangle extends shape {
    // Additional attributes specific to rectangles
    private double width;   // How wide is the rectangle?
    private double length; 

        public rectangle(coordinates pos, double width, double length) {
        super(4, pos);  // Call the parent constructor: rectangles have 4 sides
        this.width = width;
        this.length = length;
    }
    
    @Override
    public double getArea() {
        return width * length;
    }

        @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign == true) {
            // Multiply
            this.width = this.width * factor;
            this.length = this.length * factor;
        } else {
            // Divide (check for zero)
            if (factor != 0) {
                this.width = this.width / factor;
                this.length = this.length / factor;
            }
        }
        // Also scale the position (the center point)
        getCoordinates().scale(factor, sign);
    }

    @Override
    public String display() {
        return "RECTANGLE: Position " + getCoordinates().display() + 
               ", Width = " + width + ", Length = " + length +
               ", Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }

}