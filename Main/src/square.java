/**
 * square class - represents a square shape
 * All sides are equal
 */
public class square extends shape {
    private double side;  // length of one side
    
    /**
     * Create a new square
     * @param pos the top-left corner position
     * @param s length of one side
     */
    public square(coordinates pos, double s) {
        super(4, pos);  // squares have 4 sides
        this.side = s;
    }
    
    /**
     * Calculate area: side × side
     */
    @Override
    public double getArea() {
        return side * side;
    }
    
    /**
     * Calculate perimeter: 4 × side
     */
    @Override
    public double getPerimeter() {
        return 4 * side;
    }
    
    /**
     * Make the square bigger or smaller
     * @param factor multiply or divide by this
     * @param sign true = multiply, false = divide
     */
    @Override
    public void scale(int factor, boolean sign) {
        if (sign == true) {
            this.side = this.side * factor;
        } else {
            if (factor != 0) {
                this.side = this.side / factor;
            }
        }
        // Also scale the position
        getCoordinates().scale(factor, sign);
    }
    
    /**
     * Display square information
     */
    @Override
    public String display() {
        return "SQUARE: Top-Left " + getCoordinates().display() + 
               ", Side = " + side +
               ", Area = " + getArea() + 
               ", Perimeter = " + getPerimeter();
    }
    
    /**
     * Get the side length
     */
    public double getSide() {
        return side;
    }
}