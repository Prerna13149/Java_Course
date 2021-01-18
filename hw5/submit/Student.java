/**
 * Class for defining a student.
 * @author Prerna Singh
 * andrew id - prernsi
 *
 */
public class Student {
    /**
     * Instance variable for first name.
     */
    private String firstName;
    /**
     * Instance variable for last name.
     */
    private String lastName;
    /**
     * Instance variable for andrew id.
     */
    private String andrewid;
    /**
     * Instance variable for phone number.
     */
    private String phoneNumber;
    /**
     * Student constructor.
     * @param andrewId String
     */
    public Student(String andrewId) {
        andrewid = andrewId;
    }
    /**
     * Get andrewId of student.
     * @return andrewid String
     */
    public String getAndrewId() {
        return andrewid;
    }
    /**
     * Get firstName of student.
     * @return firstName String
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Get lastname of student.
     * @return lastName String
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Get student phone number.
     * @return phoneNumber String
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Set student name.
     * @param s String
     */
    public void setFirstName(String s) {
        firstName = s;
    }
    /**
     * Set last name of the student.
     * @param s String
     */
    public void setLastName(String s) {
        lastName = s;
    }
    /**
     * Set phone number for student.
     * @param s String
     */
    public void setPhoneNumber(String s) {
        phoneNumber = s;
    }
    /**
     * Override toString method.
     * @return studentdetails String
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " (Andrew ID: " + andrewid + ", Phone Number: " +  phoneNumber + ")";
    }
}
