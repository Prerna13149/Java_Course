import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.util.List;
/**
 * Defining directory driver class.
 * @author Prerna Singh
 * andrew id - prernasi
 *
 */
public class DirectoryDriver {
    /**
     * Instance variable for Directory directory.
     */
    private static Directory directory;
    /**
     * Instance variable for JTextArea area1.
     */
    private static JTextArea area1 = new JTextArea(1, 10);
    /**
     * Instance variable for JTextArea area2.
     */
    private static JTextArea area2 = new JTextArea(1, 10);
    /**
     * Instance variable for JTextArea area3.
     */
    private static JTextArea area3 = new JTextArea(1, 10);
    /**
     * Instance variable for JTextArea area4.
     */
    private static JTextArea area4 = new JTextArea(1, 10);
    /**
     * Instance variable for JTextArea area5.
     */
    private static JTextArea area5 = new JTextArea(1, 10);
    /**
     * Instance variable for JTextArea area6.
     */
    private static JTextArea area6 = new JTextArea(1, 10);
    /**
     * Instance variable for JTextArea area7.
     */
    private static JTextArea area7 = new JTextArea(20, 85);
    /**
     * Instance variable for JButton andrewButton.
     */
    private static JButton andrewButton;
    /**
     * Instance variable for JButton firstNameButton.
     */
    private static JButton firstNameButton;
    /**
     * Instance variable for JButton lastNameButton.
     */
    private static JButton lastNameButton;
    /**
     * Instance variable for JTextField tfSearchKey.
     */
    private static JTextField tfSearchKey;
    /**
     * Method for creating a JButton button.
     * @param name String
     * @return button JButton
     */
    public JButton createButton(String name) {
        JButton button = new JButton(name);
        button.setBackground(Color.blue);
        button.setForeground(Color.white);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        return button;
    }
    /**
     * Method for setting colors.
     * @param lblKey JLable
     * @param tfKey JTextField
     */
    public void setColors(JLabel lblKey, JTextField tfKey) {
        lblKey.setLabelFor(tfKey);
        lblKey.setForeground(Color.blue);
        lblKey.setOpaque(true);
        lblKey.setBackground(Color.white);
    }
    /**
     * Method for adding student from CSV.
     * @param c CSVReader
     */
    public void addStudentFromCSV(CSVReader c) throws IOException {
        int lineNum = 0;
        boolean eof = false;
        while (!eof) {
            String[] values = c.readCSVLine();
            if (values == null) {
                eof = true;
            } else {
                lineNum = lineNum + 1;

                System.out.print("Line " + lineNum + "  " + values.length + " components:");
                if (lineNum != 1) {
                    Student std = new Student(values[2]);
                    std.setFirstName(values[0]);
                    std.setLastName(values[1]);
                    std.setPhoneNumber(values[3]);
                    directory.addStudent(std);
                }

                for (String s : values) {
                    System.out.print(" \"" + s + "\"");
                }

                System.out.println();
            }
        }
        c.close();
    }
    /**
     * Constructor where JFrame and other components are instantiated.
     * @param fileName String
     * @throws IOException
     */
    public DirectoryDriver(String fileName) throws IOException {
        directory = new Directory();
        //defining font and border
        Border tempBorder = BorderFactory.createEtchedBorder(Color.blue, Color.blue);
        Font tempFont = new Font("times new roman", Font.PLAIN, 12);
        // Reading csv
        FileReader fr = new FileReader(fileName);
        CSVReader c = new CSVReader(fr);
        addStudentFromCSV(c);

        JFrame frame = new JFrame("17-681 QuoteGUI Example");
        frame.setSize(1000, 600);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border border = BorderFactory.createLineBorder(Color.BLUE);
        ///  Final panel ////////////
        JPanel paneFinal = new JPanel();
        paneFinal.setLayout(new BoxLayout(paneFinal, BoxLayout.Y_AXIS));
        // Add student panel //
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createTitledBorder(tempBorder, "Add a new student", TitledBorder.LEFT, TitledBorder.TOP, tempFont, Color.blue));
        JPanel line = new JPanel();
        line.setBackground(Color.white);
        JLabel lblFName = new JLabel("First Name:");
        JTextField tfFName = new JTextField(20);
        setColors(lblFName, tfFName);
        area1.setBorder(border);
        line.setAlignmentX(0);
        line.add(lblFName);
        line.add(area1);
        JLabel lblLName = new JLabel("Last Name:");
        JTextField tfLName = new JTextField(20);
        setColors(lblLName, tfLName);
        area2.setBorder(border);
        line.add(lblLName);
        line.add(area2);
        JLabel lblAndrew = new JLabel("Andrew ID:");
        JTextField tfAndrew = new JTextField(20);
        setColors(lblAndrew, tfAndrew);
        area3.setBorder(border);
        line.add(lblAndrew);
        line.add(area3);
        JLabel lblPhone = new JLabel("Phone Number:");
        JTextField tfPhone = new JTextField(20);
        setColors(lblPhone, tfPhone);
        area4.setBorder(border);
        line.add(lblPhone);
        line.add(area4);
        // Add button
        JButton addButton = createButton("Add");
        //addButton.setBorder(new RoundedBorder(10));
        addButton.addActionListener(new AddActionListener());
        line.add(addButton);
        pane.add(line);
        pane.setBackground(Color.white);

        // Delete student panel ///////////////////////////////////
        JPanel pane2 = new JPanel();
        pane2.setBorder(BorderFactory.createTitledBorder(tempBorder, "Delete a student", TitledBorder.LEFT, TitledBorder.TOP, tempFont, Color.blue));
        JPanel line2 = new JPanel();
        line2.setBackground(Color.white);
        JLabel lblSearchId = new JLabel("Andrew Id:");
        JTextField tfSearchId = new JTextField(20);
        setColors(lblSearchId, tfSearchId);
        area5.setBorder(border);
        line2.add(lblSearchId);
        line2.add(area5);
        // Adding delete button
        JButton deleteButton = createButton("Delete");
        deleteButton.addActionListener(new DeleteActionListener());
        line2.add(deleteButton);
        pane2.add(line2);
        pane2.setBackground(Color.white);

        // Search student panel  /////////////////////////////////
        JPanel pane3 = new JPanel();
        pane3.setBorder(BorderFactory.createTitledBorder(tempBorder, "Search student(s)", TitledBorder.LEFT, TitledBorder.TOP, tempFont, Color.blue));
        JPanel line3 = new JPanel();
        line3.setBackground(Color.white);
        JLabel lblSearchKey = new JLabel("Search Key:");
        tfSearchKey = new JTextField(20);

        setColors(lblSearchKey, tfSearchKey);
        area6.setBorder(border);
        line3.add(lblSearchKey);
        line3.add(tfSearchKey);
        //line3.add(area6);
        // Andrew Id button
        andrewButton = createButton("By Andrew ID");
        andrewButton.addActionListener(new SearchListener());
        line3.add(andrewButton);
        tfSearchKey.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    //System.out.println("Hello");
                    searchByKey();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
            }
        });
        //FirstName button
        firstNameButton = createButton("By First Name");
        firstNameButton.addActionListener(new SearchListener());
        line3.add(firstNameButton);

        //LastName button
        lastNameButton = createButton("By Last Name");
        lastNameButton.addActionListener(new SearchListener());
        line3.add(lastNameButton);
        pane3.add(line3);
        pane3.setBackground(Color.white);

        // Results panel  /////////////////////////////////
        JPanel pane4 = new JPanel();
        pane4.setBorder(BorderFactory.createTitledBorder(tempBorder, "Results", TitledBorder.LEFT, TitledBorder.TOP, tempFont, Color.blue));
        JPanel line4 = new JPanel();
        line4.setBackground(Color.white);
        area7.setBorder(border);
        JScrollPane scroller = new JScrollPane(area7);
        pane.add(scroller);
        line4.add(area7);
        pane4.add(line4);
        pane4.setBackground(Color.white);

        paneFinal.add(pane);
        paneFinal.add(pane2);
        paneFinal.add(pane3);
        paneFinal.add(pane4);

        frame.setContentPane(paneFinal);
        frame.setBackground(Color.white);
        frame.setVisible(true);
        tfSearchKey.requestFocus();
    }
    /**
     * Private static nested class used to provide actionPerformed() method to Swing.
     */
    private static class AddActionListener implements ActionListener {
        private AddActionListener() {
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            if (area3.getText().trim().equals("")) {
                area7.setText("");
                area7.append("Not possible to add student. Andrew Id is missing. Please enter Andrew Id.\n");
                return;
            }
            Student studentPresent = directory.searchByAndrewId(area3.getText());
            if (studentPresent != null) {
                area7.append("Not possible to add student. Data already contains an entry for this Andrew ID.\n");
                return;
            }
            if (area1.getText().trim().equals("")) {
                area7.setText("");
                area7.append("Not possible to add student. First Name is missing. Please enter first name.\n");
                return;
            }
            if (area2.getText().trim().equals("")) {
                area7.setText("");
                area7.append("Not possible to add student. Last Name is missing. Please enter last name.\n");
                return;
            }
            Student s = new Student(area3.getText());
            s.setFirstName(area1.getText());
            s.setLastName(area2.getText());
            if (!area4.getText().trim().equals("")) {
                s.setPhoneNumber(area4.getText());
            }
            directory.addStudent(s);
            area7.append("Added student: ");
            area7.append(s.toString());
            area7.append("\n");
            directory.print();
            area1.setText("");
            area2.setText("");
            area3.setText("");
            area4.setText("");
        }
    }
    /**
     * Private static nested class used to provide actionPerformed() method to Swing.
     */
    private static class DeleteActionListener implements ActionListener {
        private DeleteActionListener() {
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            if (area5.getText().trim().equals("")) {
                area7.setText("");
                area7.append("Andrew Id missing. Please enter andrew id.\n");
                return;
            }
            Student s = directory.searchByAndrewId(area5.getText());
            if (s == null) {
                String str = "Delete not possible. Andrew Id " + area5.getText() + " not found in the directory\n";
                area7.append(str);
            } else {
                area7.append("Deleted the entry: ");
                area7.append(s.toString());
                area7.append("\n");
                directory.deleteStudent(area5.getText());
                area5.setText("");
            }
        }
    }
    /**
     * Private static nested class used to provide actionPerformed() method to Swing.
     */
    public void searchByKey() {
        if (tfSearchKey.getText().trim().equals("")) {
            area7.setText("");
            area7.append("Andrew id missing. Please enter andrew id.\n");
            return;
            }
        Student s = directory.searchByAndrewId(tfSearchKey.getText());
        if (s == null) {
            String str = "Andrew Id " + tfSearchKey.getText() + " not found in the directory\n";
            area7.append(str);
            } else {
                area7.append(s.toString());
                area7.append("\n");
                tfSearchKey.setText("");
                }
    }
    /**
     * Private static nested class used to provide actionPerformed() method to Swing.
     */
    private static class SearchListener implements ActionListener {
        private SearchListener() {

        }
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == andrewButton) {
                //System.out.println(tfSearchKey.getText());
                if (tfSearchKey.getText().trim().equals("")) {
                    area7.setText("");
                    area7.append("Andrew id missing. Please enter andrew id.\n");
                    return;
                }
                Student s = directory.searchByAndrewId(tfSearchKey.getText());
                if (s == null) {
                    String str = "Andrew Id " + tfSearchKey.getText() + " not found in the directory\n";
                    area7.append(str);
                } else {
                    area7.append(s.toString());
                    area7.append("\n");
                    tfSearchKey.setText("");
                }
            }
            if (event.getSource() == firstNameButton) {
                if (tfSearchKey.getText().trim().equals("")) {
                    area7.setText("");
                    area7.append("Firstname missing. Please enter firstname.\n");
                    return;
                }
                List<Student> lst = directory.searchByFirstName(tfSearchKey.getText());
                if (lst.size() == 0) {
                    String str = "First name " + tfSearchKey.getText() + " not found in the directory\n";
                    area7.append(str);
                } else {
                    for (Student s:lst) {
                        area7.append(s.toString());
                        area7.append("\n");
                        tfSearchKey.setText("");
                    }
                }
            }
            if (event.getSource() == lastNameButton) {
                if (tfSearchKey.getText().trim().equals("")) {
                    area7.setText("");
                    area7.append("Lastname missing.  Please enter last name.\n");
                    return;
                }
                List<Student> lst =  directory.searchByLastName(tfSearchKey.getText());
                if (lst.size() == 0) {
                    String str = "Last name " + tfSearchKey.getText() + " not found in the directory\n";
                    area7.append(str);
                } else {
                    for (Student s:lst) {
                        area7.append(s.toString());
                        area7.append("\n");
                        tfSearchKey.setText("");
                    }
                }
            }
        }
    }
    /**
     * Defining private CSVReader class.
     */
    private class CSVReader extends BufferedReader {
        /**
         * Initializes the class.
         * @param in the reader from which to read CSV lines
         */
        private CSVReader(Reader in) {
            super(in);
        }

        /**
         * This is the only additional method. It uses readLine from the superclass
         * to get a line but returns the comma separated values as in an array of
         * strings.
         * @return an array of Strings containing the values At the end of the file,
         *         readCSVLine returns null (just as readLine does).
         * @throws IOException throws IOException
         */
        public String[] readCSVLine() throws IOException {

            // Get a line by calling the superclass's readLine method
            String line = super.readLine();

            // If we're at the end of the file, readLine returns null
            // so we return null.
            if (line == null) {
                return null;
            }

            // Count up the number of commas
            int commaCount = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    commaCount = commaCount + 1;
                }
            }

            // Allocate an array of the necessary size to return the strings
            String[] values = new String[commaCount + 1];

            // In a loop, set beginIndex and endIndex to the start and end
            // positions of each argument and then use the substring method
            // to create strings for each of the comma separate values

            // Start beginIndex at the beginning of the String, position 0
            int beginIndex = 0;

            for (int i = 0; i < commaCount; i++) {
                // set endIndex to the position of the (next) comma
                int endIndex = line.indexOf(',', beginIndex);

                // if the argument begins and ends with quotes, remove them
                if (line.charAt(beginIndex) == '"' && line.charAt(endIndex - 1) == '"') {

                    // If we made it here, we have quotes around our string.
                    // Add/subtract one from the start/end of the args
                    // to substring to get the value. (See else comment
                    // below for details on how this works.)
                    values[i] = line.substring(beginIndex + 1, endIndex - 1);

                } else {
                    // If we made it here, we don't have quotes around
                    // our string. Take the substring of this line
                    // from the beginIndex to the endIndex. The substring
                    // method called on a String will return the portion
                    // of the String starting with the beginIndex and up
                    // to but not including the endIndex.
                    values[i] = line.substring(beginIndex, endIndex);
                }

                // Set beginIndex to the position character after the
                // comma. (Remember, endIndex was set to the position
                // of the comma.)
                beginIndex = endIndex + 1;
            }

            // handle the value that's after the last comma
            if (line.charAt(beginIndex) == '"' && line.charAt(line.length() - 1) == '"') {
                values[commaCount] = line.substring(beginIndex + 1, line.length() - 1);
            } else {
                values[commaCount] = line.substring(beginIndex, line.length());
            }

            return values;
        }
    }
    /**
     * Simple program to show cook book programming for Swing.
     * @param args arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        new DirectoryDriver(args[0]);
    }
}
