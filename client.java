import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class Client {
    private Student currentStudent;
    private Course[] courseCatalog = new Course[100]; //set max courses
    private int courseCount;

    public static void main(String[] args) { 
        Client client = new Client();

        // read the two input files 
         client.readFile1("CS-26F.txt");
         client.readFile2("A20123456.txt");

        // start menu after files are loaded
        client.menu();
        
        //logic to create client object and call methods to read files, search courses, register students, and write back to files
    }
    
    public void readFile1(String filename) {
        File courseFile = new File(filename); //set file path 
        // Logic to read student data from file and initialize User object
        try { 
            Scanner scr = new Scanner(courseFile);
            
            if (scr.hasNextLine()) {
                scr.nextLine(); //skip header line
                
                while (scr.hasNextLine()) {
                    String line = scr.nextLine();
                    String[] columns = line.split("\t"); //uses tab as delimiter'
                    
                    String courseID = columns[0];
                    String courseName = columns[1];
                    
                    //find if seats are avalible
                    String status = columns[2];
                    String[] seats = status.split("/"); //splits by taken/total)
                    int registered = Integer.parseInt(seats[0]);
                    int capacity = Integer.parseInt(seats[1]);
                    
                    // handle prerequisites if they exist by creating an empty array then filling it if they exist.
                    String[] prereqs = new String[0];
                    if (columns.length > 3 && !columns[3].trim().equals("")) {
                        prereqs = columns[3].replace("\"", "").split(","); //split by comma
                        }
                    
                    //import parsed data into Course object
                    Course newCourse = new Course(courseID, courseName, registered, capacity, prereqs);
                    courseCatalog[courseCount] = newCourse;
                    courseCount++;
                }
            }
            
            System.out.println("Course data loaded successfully." + courseCount + " courses found.");
            scr.close();
            
    }   catch (FileNotFoundException e) {
            System.out.println("Course data file not found.");
        }
    }
    public void readFile2(String filename) {
        File studentFile = new File(filename); //set file path
        // Logic to read student data from file and initialize User object
        try {
                Scanner scr = new Scanner(studentFile);
                String studentName = scr.nextLine();
                String studentID = scr.nextLine();
                String courses = scr.nextLine();
                String[] previousCourses = courses.split(",");
                //import parsed data into Student object
                currentStudent = new Student(studentName, studentID, previousCourses);
                scr.close();
            } catch (FileNotFoundException e) { 
                System.out.println("Student data file not found. " + filename);
            }
    }

    // prints all loaded coures 
    public void printAllCourses() {
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courseCatalog[i].getId() + " - " + courseCatalog[i].getName());
        }
    }

    // prints courses the student already completed
    public void printCompletedCourses() { 
        String[] completed = currentStudent.getPreviousCourses();

        System.out.println("Completed courses:");
        for (int i = 0; i < completed.length; i++) {
            System.out.println(completed[i]);
        }
    }
    // searches for a coures by ID
    public Course searchCourseById(String id) {
        for (int i = 0; i < courseCount; i++) {
            if (courseCatalog[i].getId().equalsIgnoreCase(id)) {
                return courseCatalog[i];
            }
        }
        return null;
    }
    // register for a course by ID
    public void registerForCourse(String id) {
        Course foundCourse = searchCourseById(id);

        if (foundCourse == null) { 
            System.out.println("Course not found.");
        } else { 
            currentStudent.register(foundCourse);
        }
    }

    public void writeFile1(String filename) {
        try { 
            PrintWriter pw = new PrintWriter(filename);

            pw.println("ID\tName\tStatus\tPrerequisite");

            for (int i = 0; i < courseCount; i++) { 
                Course c = courseCatalog[i];

                pw.print(c.getId() + "\t");
                pw.print(c.getName() + "\t");
                pw.print(c.getStatus() + "\t");

                String[] prereqs = c.getPrerequisites();
                if (prereqs != null && prereqs.length > 0) {
                    for (int j = 0; j < prereqs.length; j++) {
                        pw.print(prereqs[j].trim());
                        if (j < prereqs.length - 1) {
                            pw.print(",");
                        }
                    }
                }

                pw.println();
            }
            pw.close();
            System.out.println("Course file updated.");
        } catch (IOException e) { 
            System.out.println("Error writing course file."); 
        } 
    } 

    public void writeFile2(String filename) {
        try { 
            PrintWriter pw = new PrintWriter(filename);

            pw.println(currentStudent.getName());
            pw.println(currentStudent.getID());

            String [] completed = currentStudent.getPreviousCourses();
            for (int i = 0; i < completed.length; i++) { 
                pw.print(completed[i].trim());
                if (i < completed.length - 1) { 
                    pw.print(",");
                } 
            }
            pw.println();

            String[] registered = currentStudent.getRegisteredNextSemester();
            boolean hasRegisteredCourse = false;

            for (int i = 0; i < registered.length; i++) { 
                if  (registered[i] != null) {
                    if (hasRegisteredCourse) {
                        pw.print(",");
                    } 
                    pw.print(registered[i]);
                    hasRegisteredCourse = true;
                }
            }
            pw.println();

            pw.close();
            System.out.println("Student file updated.");
        } catch (IOException e) {
            System.out.println("Error writing student file.");
        } 
    } 
    
    public void menu() {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("============================");
            System.out.println("|====Registration Menu=====|");
            System.out.println("|1. Print all courses      |");
            System.out.println("|2. Print completed courses|");
            System.out.println("|3. Search for a course    |");
            System.out.println("|4. Register for a course  |");
            System.out.println("|5. Exit                   |");
            System.out.println("============================");
            
            //case statesments to handle user input to call methods for each choice
            int choice = input.nextInt();
            input.nextLine(); // clear leftover new line 
            
            switch (choice) {
                case 1:
                    printAllCourses();
                    break;
                case 2:
                    printCompletedCourses();
                    break;
                case 3:
                    System.out.print("Enter course ID: ");
                    String searchID = input.nextLine();
                    Course result = searchCourseById(searchID);

                    if (result == null) {
                        System.out.println("Course not found.");
                    } else { 
                        System.out.println(result);
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter course ID to register: ");
                    String registerID = input.nextLine();
                    registerForCourse(registerID);
                    break;
                    
                case 5:
                    writeFile1("CS-26F.txt");
                    writeFile2("A20123456.txt");
                    System.out.println("Exiting...");
                    input.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

