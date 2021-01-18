/**
 * Circle class definition.
 * @author Prerna Singh
 * andrew id - prernasi
 */
public class Circle extends Shape {
    /**
     * Instance variable for radius.
     */
    private double radius;
    /**
     * Instance variable for area.
     */
    private double area;
    /**
     * Instance variable for perimeter.
     */
    private double perimeter;
    /**
     * Constructor for Circle object with radius parameter.
     * @param newRadius radius
     */
    public Circle(double newRadius) {
        //super(Math.PI * newRadius * newRadius, 2 * Math.PI * newRadius);
        radius = newRadius;
        area = Math.PI * radius * radius;
        perimeter = 2 * Math.PI * radius;
    }
    /**
     * Return radius of the Circle object.
     * @return radius in double
     */
    public double getRadius() {
        return radius;
    }
    /**
     * Return area of circle.
     * @return area in double
     */
    public double getArea() {
        return area;
    }
    /**
     * Return perimeter of circle.
     * @return perimeter in double
     */
    public double getPerimeter() {
        return perimeter;
    }
    /**
     * Return String representation of Circle object.
     * @return String represenation of Circle object
     */
    @Override
    public String toString() {
        return "Circle " + String.format("%.3f", area) + " " + String.format("%.3f", perimeter);
    }
}
