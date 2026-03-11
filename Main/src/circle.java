/**
 * circle class - represents a circle shape
 * A circle has a radius and a center point
 */
public class circle extends shape {
    private double radius;  // how big the circle is
    
    /**
     * Create a new circle
     * @param pos the center point
     * @param r the radius
     */
    public circle(coordinates pos, double r) {
        super(0, pos);  // circles have 0 sides
        this.radius = r;
    }
    
    /**
     * Calculate area: π × r²
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    /**
     * Calculate circumference (perimeter): 2 × π × r
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    /**
     * Make the circle bigger or smaller
     * @param factor multiply or divide by this
     * @param sign true = multiply, false = divide
     */
    @Override
    public void scale(int factor, boolean sign) {
        if (sign == true) {
            this.radius = this.radius * factor;
        } else {
            if (factor != 0) {
                this.radius = this.radius / factor;
            }
        }
        // Also scale the center point
        getCoordinates().scale(factor, sign);
    }
    
    /**
     * Display circle information
     */
    @Override
    public String display() {
        return "CIRCLE: Center " + getCoordinates().display() + 
               ", Radius = " + radius +
               ", Area = " + getArea() + 
               ", Circumference = " + getPerimeter();
    }
    
    /**
     * Get the radius (useful for testing)
     */
    public double getRadius() {
        return radius;
    }
}