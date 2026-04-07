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
    // Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String[] getPrerequisites() {
        return prerequisites;
    }

    // check for open seats helper method
    public boolean hasOpenSeats() {
        return registeredStudents < maxSeats;
    }
}

// + getID(): String
// + getName(): String
// + getStatus(): String 
// + hasOpenSeats(): boolean 
// + toString(): String
