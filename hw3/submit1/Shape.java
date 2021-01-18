/**
 * Shape class definition.
 * @author Prerna Singh
 * andrew id - prernasi
 */
public class Shape {
    /**
     * Instance variables for area.
     */
    private double area;
    /**
     * Instance variables for perimeter.
     */
    private double perimeter;
    /**
     * Constructor with area and perimeter parameter.
     * @param newArea area
     * @param newPerimeter perimeter
     */
    public Shape(double newArea, double newPerimeter) {
        area = newArea;
        perimeter = newPerimeter;
    }
    /**
     * Return area value of Shape object.
     * @return area value in double
     */
    public double getArea() {
        return area;
    }
    /**
     * Return perimeter of Shape object.
     * @return perimeter value in double
     */
    public double getPerimeter() {
        return perimeter;
    }
    /**
     * Return String representation of Shape object.
     * @return String representation of Shape object
     */
    @Override
    public String toString() {
        return "Shape " + String.format("%.3f", area) + " " + String.format("%.3f", perimeter);
    }
}
