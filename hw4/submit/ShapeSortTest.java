/**
 * Class for sorting shapes.
 * @author Prerna Singh
 * Andrew id - prernasi
 */
public class ShapeSortTest {
    /**
     * Method to perform sorting on array of Shapes.
     * @param args array of String
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = args.length;
        Shape[] shapeArray = new Shape[n];
        for (int i = 0; i < n; i++) {
            //System.out.println(args[i]);
            char a = args[i].charAt(0);
            String curr = args[i];
            int len = curr.length();
            int side = Integer.parseInt(curr.substring(1));
            switch (a) {
            case 'C':
                shapeArray[i] = new Circle(side);
                break;
            case 'H':
                shapeArray[i] = new Hexagon(side);
                break;
            case 'S':
                shapeArray[i] = new Square(side);
                break;
            case 'O':
                shapeArray[i] = new Octagon(side);
                break;
            case 'R':
                shapeArray[i] = new Rectangle(side, side);
                break;
            default:
                break;
            }
        }
        /*
         * Sorting the shapeArray on basis of area.
         */
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (shapeArray[j].getArea() < shapeArray[i].getArea()) {
                    Shape temp = shapeArray[i];
                    shapeArray[i] = shapeArray[j];
                    shapeArray[j] = temp;
                }
            }
        }
        /*
         * Printing shape in sorted order of area.
         */
        for (Shape sh : shapeArray) {
            System.out.println(sh.toString());
        }
        /*
         * Sorting the shapeArray on basis of perimeter.
         */
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (shapeArray[j].getPerimeter() > shapeArray[i].getPerimeter()) {
                    Shape temp = shapeArray[i];
                    shapeArray[i] = shapeArray[j];
                    shapeArray[j] = temp;
                }
            }
        }
        /*
         * Printing shape in descending order of perimeter.
         */
        for (Shape sh : shapeArray) {
            System.out.println(sh.toString());
        }
    }
}
