import java.util.Scanner;

public class shapeManage {
    private shapeList shapeList;
    private Scanner scanner;

    public shapeManage() {
        shapeList = new shapeList();
        scanner = new Scanner(System.in);
    }

    private void displayMenu() {
        System.out.println("     SHAPE MANAGEMENT MENU");
        System.out.println("1.  Add a shape");
        System.out.println("2.  Remove a shape");
        System.out.println("3.  Get shape information");
        System.out.println("4.  Show area & perimeter");
        System.out.println("5.  Display all shapes");
        System.out.println("6.  Translate all shapes");
        System.out.println("7.  Scale all shapes");
        System.out.println("0.  Quit");
        System.out.print("Enter your choice: ");
    }

    // Handles user input to create and add different shape types
    private void addShape() {
        System.out.println("\n ADD A SHAPE ");
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
                shapeList.addShape(r);
                break;

            case 2: // Square
                System.out.print("Enter X position: ");
                x = scanner.nextInt();
                System.out.print("Enter Y position: ");
                y = scanner.nextInt();
                System.out.print("Enter side length: ");
                double side = scanner.nextDouble();

                square sq = new square(new coordinates(x, y), side);
                shapeList.addShape(sq);
                break;

            case 3: // Circle
                System.out.print("Enter X position (center): ");
                x = scanner.nextInt();
                System.out.print("Enter Y position (center): ");
                y = scanner.nextInt();
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();

                circle c = new circle(new coordinates(x, y), radius);
                shapeList.addShape(c);
                break;

            case 4: // Triangle - requires three vertices
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
                shapeList.addShape(t);
                break;

            default:
                System.out.println("Invalid shape type!");
        }
    }

    private void removeShape() {
        System.out.print("Enter position to remove: ");
        int pos = scanner.nextInt();
        shapeList.removeShape(pos);
    }

    private void getShapeInfo() {
        System.out.print("Enter position: ");
        int pos = scanner.nextInt();
        shape s = shapeList.getShape(pos);
        if (s != null) {
            System.out.println(s.display());
        }
    }

    private void getAreaPerimeter() {
        System.out.print("Enter position: ");
        int pos = scanner.nextInt();
        double area = shapeList.area(pos);
        double perimeter = shapeList.perimeter(pos);

        if (area != -1 && perimeter != -1) {
            System.out.println("Shape at position " + pos + ":");
            System.out.println("  Area = " + area);
            System.out.println("  Perimeter = " + perimeter);
        }
    }

    private void translateAll() {
        System.out.print("Enter dx (horizontal move): ");
        int dx = scanner.nextInt();
        System.out.print("Enter dy (vertical move): ");
        int dy = scanner.nextInt();

        shapeList.translateShapes(dx, dy);
    }

    private void scaleAll() {
        System.out.print("Enter factor: ");
        int factor = scanner.nextInt();
        System.out.print("Multiply (true) or Divide (false)? ");
        boolean sign = scanner.nextBoolean();

        shapeList.scaleShapes(factor, sign);
    }

    // Main program loop - displays menu and processes user choices until quit
    public void run() {
        int choice;

        System.out.println("SHAPE MANAGEMENT SYSTEM");

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
                    System.out.println(shapeList.display());
                    break;
                case 6:
                    translateAll();
                    break;
                case 7:
                    scaleAll();
                    break;
                case 0:
                    System.out.println("\n Goodbye! Thanks for using Shape Manager!");
                    break;
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
