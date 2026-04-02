public class Course{
    private String id; // format CSXXX
    private String name;
    private int registeredStudents; 
    private int maxSeats;
    private String[] prerequisites; // separated by comma 

    // Constructor to initialize from file data 
    public Course(String id, String name, int registered, int max, String[] prereqs) {
        this.id = id;
        this.name = name;
        this.registeredStudents = registered;
        this.maxSeats = max;
        this.prerequisites = prereqs;
    }

    // sort by course ID method
    public int compareTo(Course other) {
        return this.id.compareTo(other.id);
    }

    // check for open seats helper method
    public boolean hasOpenSeats() {
        return registeredStudents < maxSeats;
    }
}