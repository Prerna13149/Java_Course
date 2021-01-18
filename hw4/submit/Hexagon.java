/**
 * Hexagon class definition.
 * @author Prerna Singh
 * andrew id - prernasi
 */
public class Hexagon extends Shape {
    /**
     * Instance variable for side of Square object.
     */
    private double side;
    /**
     * Instance variable for area of Square object.
     */
    private double area;
    /**
     * Instance variable for perimeter of Square object.
     */
    private double perimeter;
    /**
     * Constructor for Hexagon object with side parameter.
     * @param newSide side
     */
    public Hexagon(double newSide) {
        //super((3 * Math.sqrt(3) * newSide * newSide) / 2, 6 * newSide);
        side = newSide;
        area = (3 * Math.sqrt(3) * side * side) / 2;
        perimeter = 6 * side;
    }
    /**
     * Return side of Square object.
     * @return side in double
     */
    public double getSide() {
        return side;
    }
    /**
     * Return area of hexagon.
     * @return area in double
     */
    public double getArea() {
        return area;
    }
    /**
     * Return perimeter of hexagon.
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
        return  "Hexagon " + String.format("%.3f", area) + " " + String.format("%.3f", perimeter);
    }
}
