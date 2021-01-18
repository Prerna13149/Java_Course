/**
 * Shape class definition.
 * @author Prerna Singh
 * andrew id - prernasi
 */
public abstract class Shape {
    /**
     * Instance variables for area.
     */
    private double area;
    /**
     * Instance variables for perimeter.
     */
    private double perimeter;
    /**
     * Return area value of Shape object.
     * @return area value in double
     */
    public abstract double getArea();
    /**
     * Return perimeter of Shape object.
     * @return perimeter value in double
     */
    public abstract double getPerimeter();
    /**
     * Return String representation of Shape object.
     * @return String representation of Shape object
     */
    @Override
    public String toString() {
        return "Shape " + String.format("%.3f", area) + " " + String.format("%.3f", perimeter);
    }
}
