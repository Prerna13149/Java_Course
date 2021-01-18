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
     * Constructor for Octagon object with side parameter.
     * @param newSide side
     */
    public Octagon(double newSide) {
        super(2 * (1 + Math.sqrt(2)) * newSide * newSide, 8 * newSide);
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
        return "Octagon " + String.format("%.3f", super.getArea()) + " " + String.format("%.3f", super.getPerimeter());
    }

}
