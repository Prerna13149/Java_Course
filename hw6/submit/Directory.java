import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
/**
 * Defining directory class.
 * @author Prerna Singh
 * andrew id - prernasi
 *
 */
public class Directory {
    /**
     * Instance variable for hashmap directory.
     */
    private HashMap<String, Student> directory = new HashMap<String, Student>();
    /**
     * Instance variable for hashmap based on firstname.
     */
    private HashMap<String, List<Student>> firstNameMap = new HashMap<String, List<Student>>();
    /**
     * Instance variables for hashmap with lastname.
     */
    private HashMap<String, List<Student>> lastNameMap = new HashMap<String, List<Student>>();
    /**
     * Default constructor.
     */
    public Directory() {
    }
    /**
     * Adding student to directory.
     * @param s Student
     */
    public void addStudent(Student s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (directory != null && directory.containsKey(s.getAndrewId())) {
            throw new IllegalArgumentException();
        }
        Student student = new Student(s.getAndrewId());
        student.setFirstName(s.getFirstName());
        student.setLastName(s.getLastName());
        student.setPhoneNumber(s.getPhoneNumber());
        directory.put(s.getAndrewId(), student);
        if (firstNameMap.get(s.getFirstName()) != null) {
            firstNameMap.get(s.getFirstName()).add(student);
        } else {
            List<Student> temp1 = new ArrayList<Student>();
            temp1.add(student);
            firstNameMap.put(s.getFirstName(), temp1);
        }
        if (lastNameMap.get(s.getLastName()) != null) {
            lastNameMap.get(s.getLastName()).add(student);
        } else {
            List<Student> temp1 = new ArrayList<Student>();
            temp1.add(student);
            lastNameMap.put(s.getLastName(), temp1);
        }
    }
    /**
     * Delete student from directory.
     * @param andrewId String
     */
    public void deleteStudent(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        }
        if (!(andrewId instanceof String)) {
            throw new IllegalArgumentException();
        }
        if (andrewId.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        if (!directory.containsKey(andrewId)) {
            throw new IllegalArgumentException();
        }
        Student std = directory.get(andrewId);
        directory.remove(andrewId);
        int n = firstNameMap.get(std.getFirstName()).size();
        if (n > 1) {
            firstNameMap.get(std.getFirstName()).remove(std);
        } else {
            firstNameMap.remove(std.getFirstName());
        }
        n = lastNameMap.get(std.getLastName()).size();
        if (n > 1) {
            lastNameMap.get(std.getLastName()).remove(std);
        } else {
            lastNameMap.remove(std.getLastName());
        }
    }
    /**
     * Search student from directory.
     * @param andrewId String
     * @return Student object
     */
    public Student searchByAndrewId(String andrewId) {
        if (!(andrewId instanceof String)) {
            throw new IllegalArgumentException();
        }
        if (andrewId.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        if (!directory.containsKey(andrewId)) {
            return null;
        }
        Student std = directory.get(andrewId);
        Student temp = new Student(std.getAndrewId());
        temp.setFirstName(std.getFirstName());
        temp.setLastName(std.getLastName());
        temp.setPhoneNumber(std.getPhoneNumber());
        return temp;
    }
    /**
     * Search student by firstName from directory.
     * @param firstName String
     * @return ArrayList<Student>
     */
    public List<Student> searchByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException();
        }
        if (firstNameMap.containsKey(firstName)) {
            List<Student> ans = new ArrayList<Student>();
            for (Student s: firstNameMap.get(firstName)) {
                Student temp = new Student(s.getAndrewId());
                temp.setFirstName(s.getFirstName());
                temp.setLastName(s.getLastName());
                temp.setPhoneNumber(s.getPhoneNumber());
                ans.add(temp);
            }
            return ans;
        }
        return new ArrayList<Student>();
    }
    /**
     * Search student by lastname from directory.
     * @param lastName String
     * @return ArrayList<Student>
     */
    public List<Student> searchByLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException();
        }
        if (lastNameMap.containsKey(lastName)) {
            List<Student> ans = new ArrayList<Student>();
            for (Student s: lastNameMap.get(lastName)) {
                Student temp = new Student(s.getAndrewId());
                temp.setFirstName(s.getFirstName());
                temp.setLastName(s.getLastName());
                temp.setPhoneNumber(s.getPhoneNumber());
                ans.add(temp);
            }
            return ans;
        }
        return new ArrayList<Student>();
    }
    /**
     * Get size of the directory.
     * @return size of directory int
     */
    public int size() {
        return directory.size();
    }
    /**
     *  Print the directory.
     */
    public void print() {
        for (Entry<String, Student> set : directory.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue().getPhoneNumber() + " " + set.getValue().getFirstName());
        }
        System.out.println(firstNameMap.size());
        System.out.println(lastNameMap.size());
    }
}
