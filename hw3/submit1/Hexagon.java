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
     * Constructor for Hexagon object with side parameter.
     * @param newSide side
     */
    public Hexagon(double newSide) {
        super((3 * Math.sqrt(3) * newSide * newSide) / 2, 6 * newSide);
        side = newSide;
    }
    /**
     * Return side of Square object.
     * @return side in double
     */
    public double getSide() {
        return side;
    }
    /**
     * Return String representation for Hexagon object.
     * @return String representation of Hexagon object
     */
    @Override
    public String toString() {
        return  "Hexagon " + String.format("%.3f", super.getArea()) + " " + String.format("%.3f", super.getPerimeter());
    }
}
