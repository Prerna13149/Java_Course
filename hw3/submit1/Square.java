/**
 * Square class definition.
 * @author Prerna Singh
 * andrew id - prernasi
 *
 */
public class Square extends Rectangle {
    /**
     * Instance variable for side of Square.
     */
    private double side;
    /**
     * Constructor with side parameter.
     * @param newSide side
     */
    public Square(double newSide) {
        super(newSide, newSide);
        side = newSide;
    }
    /**
     * Return the side of Square object.
     * @return side in double
     */
    public double getSide() {
        return side;
    }
    /**
     * Return String representation of Rectangle object.
     * @return String representation of Rectangle Object
     */
    @Override
    public String toString() {
        return "Square " + String.format("%.3f", super.getArea()) + " " + String.format("%.3f", super.getPerimeter());
    }
}
