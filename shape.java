public abstract class shape {
    private coordinates position;
    private int sides;

    public shape(int noOfSides, coordinates coord) {
        this.sides = noOfSides;
        this.position = coord;
    }

    public coordinates getCoordinates() {
        return position;
    }

    public int getSides() {
        return sides;
    }

    public void setCoordinates(coordinates newcoord) {
        this.position = newcoord;
    }

    // Delegates translation to the coordinates object
    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }

    // Abstract methods that all concrete shapes must implement
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void scale(int factor, boolean sign);
    public abstract String display();
}
