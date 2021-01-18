/**
 * Rectangle class definition.
 * @author Prerna Singh
 * andrew id - prernasi
 *
 */
public class Rectangle extends Shape {
    /**
     * Instance variables for width.
     */
    private double width;
    /**
     * Instance variables for height.
     */
    private double height;
    /**
     * Instance variable for area.
     */
    private double area;
    /**
     * Instance variable for perimeter.
     */
    private double perimeter;
    /**
     * Constructor with width and height parameters.
     * @param newWidth width
     * @param newHeight height
     */
    public Rectangle(double newWidth, double newHeight) {
        //super(newWidth * newHeight, 2 * (newWidth + newHeight));
        width = newWidth;
        height = newHeight;
        area =  height * width;
        perimeter = 2 * (height + width);
    }
    /**
     * Return width of the Rectangle object.
     * @return width in double
     */
    public double getWidth() {
        return width;
    }
    /**
     * Return height of the Rectangle object.
     * @return height in double
     */
    public double getHeight() {
        return height;
    }
    /**
     * Return area of rectangle.
     * @return area in double
     */
    public double getArea() {
        return area;
    }
    /**
     * Return perimeter of rectangle.
     * @return perimeter in double
     */
    public double getPerimeter() {
        return perimeter;
    }
    /**
     * Return String representation of Rectangle object.
     * @return String representation of Rectangle object
     */
    @Override
    public String toString() {
        return "Rectangle " + String.format("%.3f", area) + " " + String.format("%.3f", perimeter);
    }

}
