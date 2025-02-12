// Custom exception for illegal triangles
class IllegalTriangleException extends Exception {
    private double side1, side2, side3;

    public IllegalTriangleException(double side1, double side2, double side3) {
        super("Invalid triangle: The sum of any two sides must be greater than the third side.");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
}

// Triangle class that enforces the triangle inequality theorem
class TriangleWithException {
    private double side1, side2, side3;

    public TriangleWithException(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException(side1, side2, side3);
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

public class Lab10_03 {

    public static void main(String[] args) {
        try {
            TriangleWithException t1 = new TriangleWithException(1.5, 2, 3);
            // Invalid Triangle
            System.out.println("Perimeter for t1: " + t1.getPerimeter());
            System.out.println("Area for t1: " + t1.getArea());

            TriangleWithException t2 = new TriangleWithException(1, 2, 3);
            // Valid Triangle
            System.out.println("Perimeter for t2: " + t2.getPerimeter());
            System.out.println("Area for t2: " + t2.getArea());
        } catch (IllegalTriangleException ex) {
            System.out.println("Illegal triangle");
            System.out.println("Side1: " + ex.getSide1());
            System.out.println("Side2: " + ex.getSide2());
            System.out.println("Side3: " + ex.getSide3());
        }
    }
}
