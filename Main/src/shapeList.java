import java.util.ArrayList;

/**
 * shapelist class - manages a collection of shapes
 * Like a box that holds multiple shapes
 */
public class shapeList {
    // ArrayList is like a resizable array that can hold any shape
    private ArrayList<shape> listofShapes;
    
    /**
     * Create an empty list
     */
    public shapeList() {
        listofShapes = new ArrayList<shape>();
    }
    
    /**
     * Add a shape to the list
     * @param s the shape to add
     */
    public void addShape(shape s) {
        listofShapes.add(s);
        System.out.println("✓ Shape added. Total shapes: " + listofShapes.size());
    }
    
    /**
     * Remove a shape at a specific position
     * @param pos position (1-based, as shown in menu)
     * @return the removed shape, or null if position invalid
     */
    public shape removeShape(int pos) {
        // Convert to 0-based for ArrayList
        int index = pos - 1;
        
        // Check if position exists
        if (index >= 0 && index < listofShapes.size()) {
            shape removed = listofShapes.remove(index);
            System.out.println("✓ Removed shape at position " + pos);
            return removed;
        } else {
            System.out.println("❌ Error: No shape at position " + pos);
            return null;
        }
    }
    
    /**
     * Get a shape without removing it
     * @param pos position (1-based)
     * @return the shape, or null if position invalid
     */
    public shape getShape(int pos) {
        int index = pos - 1;
        if (index >= 0 && index < listofShapes.size()) {
            return listofShapes.get(index);
        } else {
            System.out.println("❌ Error: No shape at position " + pos);
            return null;
        }
    }
    
    /**
     * Get area of shape at given position
     * @param pos position (1-based)
     * @return area, or -1 if error
     */
    public double area(int pos) {
        shape s = getShape(pos);
        if (s != null) {
            return s.getArea();
        }
        return -1;
    }
    
    /**
     * Get perimeter of shape at given position
     * @param pos position (1-based)
     * @return perimeter, or -1 if error
     */
    public double perimeter(int pos) {
        shape s = getShape(pos);
        if (s != null) {
            return s.getPerimeter();
        }
        return -1;
    }
    
    /**
     * Move all shapes
     * @param dx horizontal move amount
     * @param dy vertical move amount
     */
    public void translateShapes(int dx, int dy) {
        for (shape s : listofShapes) {
            s.translate(dx, dy);
        }
        System.out.println("✓ All shapes moved by (" + dx + ", " + dy + ")");
    }
    
    /**
     * Resize all shapes
     * @param factor number to multiply/divide by
     * @param sign true = multiply, false = divide
     */
    public void scaleShapes(int factor, boolean sign) {
        for (shape s : listofShapes) {
            s.scale(factor, sign);
        }
        String operation = sign ? "multiplied" : "divided";
        System.out.println("✓ All shapes " + operation + " by " + factor);
    }
    
    /**
     * Get number of shapes in list
     */
    public int getNumberOfShapes() {
        return listofShapes.size();
    }
    
    /**
     * Display all shapes
     * @return string with all shapes' information
     */
    public String display() {
        if (listofShapes.isEmpty()) {
            return "📭 No shapes in the list.";
        }
        
        String result = "\n═════════ ALL SHAPES ═════════\n";
        for (int i = 0; i < listofShapes.size(); i++) {
            result += (i+1) + ". " + listofShapes.get(i).display() + "\n";
        }
        result += "═══════════════════════════════";
        return result;
    }
}