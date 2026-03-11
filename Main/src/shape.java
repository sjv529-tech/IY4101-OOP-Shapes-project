public abstract class shape {
    private coordinates position;  
    private int sides; 
    
    public shape(int noOfSides, coordinates coord) {
        this.sides = noOfSides;
        this.position = coord;
    }
    
    // These are "abstract" because each shape calculates differently
    public abstract double getArea();      // Circle calculates differently than Square
    public abstract double getPerimeter(); // Each shape has its own formula
}
