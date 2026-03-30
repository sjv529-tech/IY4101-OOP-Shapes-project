import java.util.ArrayList;

public class shapeList {
    private ArrayList<shape> listofShapes;  // Collection to store all shapes

    public shapeList() {
        listofShapes = new ArrayList<shape>();
    }

    // Adds a shape and displays confirmation with current count
    public void addShape(shape s) {
        listofShapes.add(s);
        System.out.println("✓ Shape added. Total shapes: " + listofShapes.size());
    }

    // Removes shape by 1-indexed position, returns null if invalid
    public shape removeShape(int pos) {
        int index = pos - 1;  // Convert to 0-indexed
        if (index >= 0 && index < listofShapes.size()) {
            shape removed = listofShapes.remove(index);
            System.out.println("Removed shape at position " + pos);
            return removed;
        } else {
            System.out.println("Error: No shape at position " + pos);
            return null;
        }
    }

    // Retrieves shape by 1-indexed position with error checking
    public shape getShape(int pos) {
        int index = pos - 1;
        if (index >= 0 && index < listofShapes.size()) {
            return listofShapes.get(index);
        } else {
            System.out.println("Error: No shape at position " + pos);
            return null;
        }
    }

    public double area(int pos) {
        shape s = getShape(pos);
        if (s != null) {
            return s.getArea();
        }
        return -1;
    }

    public double perimeter(int pos) {
        shape s = getShape(pos);
        if (s != null) {
            return s.getPerimeter();
        }
        return -1;
    }

    // Applies translation to every shape in the collection
    public void translateShapes(int dx, int dy) {
        for (shape s : listofShapes) {
            s.translate(dx, dy);
        }
        System.out.println("All shapes moved by (" + dx + ", " + dy + ")");
    }

    // Applies scaling to every shape (multiply or divide)
    public void scaleShapes(int factor, boolean sign) {
        for (shape s : listofShapes) {
            s.scale(factor, sign);
        }
        String operation = sign ? "multiplied" : "divided";
        System.out.println("All shapes " + operation + " by " + factor);
    }

    public int getNumberOfShapes() {
        return listofShapes.size();
    }

    // Builds formatted string displaying all shapes with their details
    public String display() {
        if (listofShapes.isEmpty()) {
            return "No shapes in the list.";
        }

        String result = "\n═════════ ALL SHAPES ═════════\n";
        for (int i = 0; i < listofShapes.size(); i++) {
            result += (i+1) + ". " + listofShapes.get(i).display() + "\n";
        }
        result += "═══════════════════════════════";
        return result;
    }
}
