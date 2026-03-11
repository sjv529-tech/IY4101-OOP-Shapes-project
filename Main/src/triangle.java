/**
 * triangle class - represents a triangle shape
 * Triangles are defined by THREE points (vertices)
 */
public class triangle extends shape {
    // A triangle has three corners
    private coordinates vertex1;
    private coordinates vertex2;
    private coordinates vertex3;
    
    /**
     * Create a new triangle
     * @param v1 first corner
     * @param v2 second corner
     * @param v3 third corner
     */
    public triangle(coordinates v1, coordinates v2, coordinates v3) {
        super(3, v1);  // triangles have 3 sides, use v1 as reference position
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.vertex3 = v3;
    }
    
    /**
     * Calculate length of side between vertex1 and vertex2
     */
    private double sideA() {
        return vertex1.distance(vertex2);
    }
    
    /**
     * Calculate length of side between vertex2 and vertex3
     */
    private double sideB() {
        return vertex2.distance(vertex3);
    }
    
    /**
     * Calculate length of side between vertex3 and vertex1
     */
    private double sideC() {
        return vertex3.distance(vertex1);
    }
    
    /**
     * Calculate perimeter: add all three sides
     */
    @Override
    public double getPerimeter() {
        return sideA() + sideB() + sideC();
    }
    
    /**
     * Calculate area using Heron's formula
     * Area = √[s(s-a)(s-b)(s-c)] where s = (a+b+c)/2
     */
    @Override
    public double getArea() {
        double a = sideA();
        double b = sideB();
        double c = sideC();
        double s = getPerimeter() / 2;  // semiperimeter
        
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    /**
     * Move the entire triangle
     */
    @Override
    public void translate(int dx, int dy) {
        // Move ALL three vertices
        vertex1.translate(dx, dy);
        vertex2.translate(dx, dy);
        vertex3.translate(dx, dy);
    }
    
    /**
     * Make the triangle bigger or smaller
     */
    @Override
    public void scale(int factor, boolean sign) {
        // Scale all three vertices
        vertex1.scale(factor, sign);
        vertex2.scale(factor, sign);
        vertex3.scale(factor, sign);
    }
    
    /**
     * Display triangle information
     */
    @Override
    public String display() {
        return "TRIANGLE: Vertices: [" + vertex1.display() + "], [" + 
               vertex2.display() + "], [" + vertex3.display() + "]" +
               ", Area = " + getArea() + 
               ", Perimeter = " + getPerimeter();
    }
    
    /**
     * Get the vertices (for testing)
     */
    public coordinates getVertex1() { return vertex1; }
    public coordinates getVertex2() { return vertex2; }
    public coordinates getVertex3() { return vertex3; }
}