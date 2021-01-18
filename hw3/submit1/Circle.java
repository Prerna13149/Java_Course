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
     * Constructor for Circle object with radius parameter.
     * @param newRadius radius
     */
    public Circle(double newRadius) {
        super(Math.PI * newRadius * newRadius, 2 * Math.PI * newRadius);
        radius = newRadius;
    }
    /**
     * Return radius of the Circle object.
     * @return radius in double
     */
    public double getRadius() {
        return radius;
    }
    /**
     * Return String representation of Circle object.
     * @return String represenation of Circle object
     */
    @Override
    public String toString() {
        return "Circle " + String.format("%.3f", super.getArea()) + " " + String.format("%.3f", super.getPerimeter());
    }
}
