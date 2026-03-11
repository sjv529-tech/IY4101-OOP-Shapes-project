import java.util.Scanner;

/**
 * shapemanager class - the main program with the menu
 * This is what the user interacts with
 */
public class shapeManage {
    private shapeList shapelist;
    private Scanner scanner;
    
    /**
     * Set up the program
     */
    public void shapeManager() {
        shapelist = new shapeList();
        scanner = new Scanner(System.in);
    }
    
    /**
     * Show the menu options
     */
    private void displayMenu() {
        System.out.println("\n═══════════════════════════════");
        System.out.println("     SHAPE MANAGEMENT MENU");
        System.out.println("═══════════════════════════════");
        System.out.println("1. ➕ Add a shape");
        System.out.println("2. ❌ Remove a shape");
        System.out.println("3. 🔍 Get shape information");
        System.out.println("4. 📐 Show area & perimeter");
        System.out.println("5. 📋 Display all shapes");
        System.out.println("6. 🚚 Translate all shapes");
        System.out.println("7. 🔄 Scale all shapes");
        System.out.println("0. 👋 Quit");
        System.out.print("Enter your choice: ");
    }
    
    /**
     * Add a new shape (option 1)
     */
    private void addShape() {
        System.out.println("\n--- ADD A SHAPE ---");
        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.println("4. Triangle");
        System.out.print("Choose shape type (1-4): ");
        
        int type = scanner.nextInt();
        
        switch(type) {
            case 1: // Rectangle
                System.out.print("Enter X position: ");
                int x = scanner.nextInt();
                System.out.print("Enter Y position: ");
                int y = scanner.nextInt();
                System.out.print("Enter width: ");
                double w = scanner.nextDouble();
                System.out.print("Enter length: ");
                double l = scanner.nextDouble();
                
                rectangle r = new rectangle(new coordinates(x, y), w, l);
                shapelist.addShape(r);
                break;
                
            case 2: // Square
                System.out.print("Enter X position: ");
                x = scanner.nextInt();
                System.out.print("Enter Y position: ");
                y = scanner.nextInt();
                System.out.print("Enter side length: ");
                double side = scanner.nextDouble();
                
                square sq = new square(new coordinates(x, y), side);
                shapelist.addShape(sq);
                break;
                
            case 3: // Circle
                System.out.print("Enter X position (center): ");
                x = scanner.nextInt();
                System.out.print("Enter Y position (center): ");
                y = scanner.nextInt();
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                
                circle c = new circle(new coordinates(x, y), radius);
                shapelist.addShape(c);
                break;
                
            case 4: // Triangle
                System.out.println("Enter coordinates for 3 vertices:");
                
                System.out.print("Vertex 1 - X: ");
                int x1 = scanner.nextInt();
                System.out.print("Vertex 1 - Y: ");
                int y1 = scanner.nextInt();
                
                System.out.print("Vertex 2 - X: ");
                int x2 = scanner.nextInt();
                System.out.print("Vertex 2 - Y: ");
                int y2 = scanner.nextInt();
                
                System.out.print("Vertex 3 - X: ");
                int x3 = scanner.nextInt();
                System.out.print("Vertex 3 - Y: ");
                int y3 = scanner.nextInt();
                
                triangle t = new triangle(
                    new coordinates(x1, y1),
                    new coordinates(x2, y2),
                    new coordinates(x3, y3)
                );
                shapelist.addShape(t);
                break;
                
            default:
                System.out.println("❌ Invalid shape type!");
        }
    }
    
    /**
     * Remove a shape (option 2)
     */
    private void removeShape() {
        System.out.print("Enter position to remove: ");
        int pos = scanner.nextInt();
        shapelist.removeShape(pos);
    }
    
    /**
     * Get info about a specific shape (option 3)
     */
    private void getShapeInfo() {
        System.out.print("Enter position: ");
        int pos = scanner.nextInt();
        shape s = shapelist.getShape(pos);
        if (s != null) {
            System.out.println(s.display());
        }
    }
    
    /**
     * Get area and perimeter (option 4)
     */
    private void getAreaPerimeter() {
        System.out.print("Enter position: ");
        int pos = scanner.nextInt();
        double area = shapelist.area(pos);
        double perimeter = shapelist.perimeter(pos);
        
        if (area != -1 && perimeter != -1) {
            System.out.println("Shape at position " + pos + ":");
            System.out.println("  📏 Area = " + area);
            System.out.println("  📐 Perimeter = " + perimeter);
        }
    }
    
    /**
     * Move all shapes (option 6)
     */
    private void translateAll() {
        System.out.print("Enter dx (horizontal move): ");
        int dx = scanner.nextInt();
        System.out.print("Enter dy (vertical move): ");
        int dy = scanner.nextInt();
        
        shapelist.translateShapes(dx, dy);
    }
    
    /**
     * Resize all shapes (option 7)
     */
    private void scaleAll() {
        System.out.print("Enter factor: ");
        int factor = scanner.nextInt();
        System.out.print("Multiply (true) or Divide (false)? ");
        boolean sign = scanner.nextBoolean();
        
        shapelist.scaleShapes(factor, sign);
    }
    
    /**
     * Run the main program
     */
    public void run() {
        int choice;
        
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║   SHAPE MANAGEMENT SYSTEM    ║");
        System.out.println("╚══════════════════════════════╝");
        
        do {
            displayMenu();
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    addShape();
                    break;
                case 2:
                    removeShape();
                    break;
                case 3:
                    getShapeInfo();
                    break;
                case 4:
                    getAreaPerimeter();
                    break;
                case 5:
                    System.out.println(shapelist.display());
                    break;
                case 6:
                    translateAll();
                    break;
                case 7:
                    scaleAll();
                    break;
                case 0:
                    System.out.println("\n👋 Goodbye! Thanks for using Shape Manager!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }

}