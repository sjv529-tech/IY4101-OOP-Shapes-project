public class coordinates {
    private int x; 
    private int y;  
    
    public coordinates(int x, int y) {
        this.x = x;
        this.y = y;  
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public double distance(coordinates p) {
        int xDiff = this.x - p.getX(); 
        int yDiff = this.y - p.getY();
        
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

    public void translate(int dx, int dy) {
        this.x = this.x + dx;  // Add dx to current x
        this.y = this.y + dy;  // Add dy to current y
    }  

        public void scale(int factor, boolean sign) {
        if (sign == true) {
            // Multiply
            this.x = this.x * factor;
            this.y = this.y * factor;
        } else {
            // Divide (make sure we don't divide by zero!)
            if (factor != 0) {
                this.x = this.x / factor;
                this.y = this.y / factor;
            }
        }
    }

    public String display() {
        return "X = " + x + " Y = " + y;
    }


}