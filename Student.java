public class Student {
    private String name;
    private String aNumber;
    private String[] previousCourses;
    private String[] registeredNextSemester;

    public Student(String name, String aNumber, String[] previous) {
        this.name = name;
        this.aNumber = aNumber;
        this.previousCourses = previous;
        this.registeredNextSemester = new String[5]; // limit to 5 courses per semester
    }
    //getters
    public String getID(){
        return aNumber;
    }
    public String getName(){
        return name;
    }
  // Logic to verify prerequisites
    public boolean hasTakenPrereqs(String[] requiredPrereqs) {
        return true; 
    }
    public boolean canRegister() {
        // Check if student has taken prerequisites
        if (!hasTakenPrereqs(Course.getPrerequisites())) {
            return false;
        }
        // Check if there are open seats in the course
        if (!Course.hasOpenSeats()) {
            return false;
        }
        return true;
    }
    public void register(Course course) {
        if (canRegister(course)) {
            // Logic to add course to registeredNextSemester
            for (int i = 0; i < registeredNextSemester.length; i++) {
                if (registeredNextSemester[i] == null) {
                    registeredNextSemester[i] = course.getId();
                    break;
                }
            }
        } else {
            System.out.println("Cannot register for course: " + course.getId());
        }
    }
    public String toString() {
        return "Student{name='" + name + "', aNumber='" + aNumber + "'}";
    }

}






