/**
 * Octagon class definition.
 * @author Prerna Singh
 * andrew id - prernasi
 */
public class Octagon extends Shape {
    /**
     * Instance variable for side of Octagon object.
     */
    private double side;
    /**
     * Instance variable for area of Octagon object.
     */
    private double area;
    /**
     * Instance variable for perimeter of Octagon object.
     */
    private double perimeter;
    /**
     * Constructor for Octagon object with side parameter.
     * @param newSide side
     */
    public Octagon(double newSide) {
        //super(2 * (1 + Math.sqrt(2)) * newSide * newSide, 8 * newSide);
        side = newSide;
        area = 2 * (1 + Math.sqrt(2)) * side * side;
        perimeter = 8 * side;
    }
    /**
     * Return side of Square object.
     * @return side in double
     */
    public double getSide() {
        return side;
    }
    /**
     * Return area of octagon.
     * @return area in double
     */
    public double getArea() {
        return area;
    }
    /**
     * Return perimeter of octagon.
     * @return perimeter in double
     */
    public double getPerimeter() {
        return perimeter;
    }
    /**
     * Return String representation for Hexagon object.
     * @return String representation of Hexagon object
     */
    @Override
    public String toString() {
        return "Octagon " + String.format("%.3f", area) + " " + String.format("%.3f", perimeter);
    }

}
