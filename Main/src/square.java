public class square extends shape {
    private double side;

    public square(coordinates pos, double s) {
        super(4, pos); 
        this.side = s;
    }

    @Override
    public double getArea() {
        return side * side;
    }
 
    @Override
    public double getPerimeter() {
        return 4 * side;
    }
 
    @Override
    public void scale(int factor, boolean sign) {
        if (sign == true) {
            this.side = this.side * factor;
        } else {
            if (factor != 0) {
                this.side = this.side / factor;
            }
        }
        getCoordinates().scale(factor, sign);
    }

    @Override
    public String display() {
        return "SQUARE: Top-Left " + getCoordinates().display() + 
               ", Side = " + side +
               ", Area = " + getArea() + 
               ", Perimeter = " + getPerimeter();
    }

    public double getSide() {
        return side;
    }
}
