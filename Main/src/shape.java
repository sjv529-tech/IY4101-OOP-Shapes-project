/**
 * shape is an abstract class - it's a template for all shapes
 * You cannot create a "shape" directly, only specific shapes like circle
 */
public abstract class shape {
    // All shapes have these basic things
    private coordinates position;  // where is the shape located?
    private int sides;             // how many sides?
    
    /**
     * Constructor for shape
     * @param noOfSides how many sides this shape has
     * @param coord the position
     */
    public shape(int noOfSides, coordinates coord) {
        this.sides = noOfSides;
        this.position = coord;
    }
    
    // ===== GETTERS AND SETTERS =====
    
    /**
     * Get the shape's position
     */
    public coordinates getCoordinates() {
        return position;
    }
    
    /**
     * Get number of sides
     */
    public int getSides() {
        return sides;
    }
    
    /**
     * Change the shape's position
     */
    public void setCoordinates(coordinates newcoord) {
        this.position = newcoord;
    }
    
    // ===== METHODS THAT ALL SHAPES SHARE =====
    
    /**
     * Move the shape
     */
    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }
    
    // ===== ABSTRACT METHODS =====
    // Each shape MUST implement these in its own way
    
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void scale(int factor, boolean sign);
    public abstract String display();
}