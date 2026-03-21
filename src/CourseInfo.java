import java.io.FileWriter;
import java.io.IOException;

public class CourseInfo implements CollegeCourses { //File 1
    FileWriter writer = new FileWriter("CourseList.txt");

    public CourseInfo() throws IOException {
        System.out.println("HERE");
        writeFile();
        }

       public void writeFile() throws IOException {
        writer.write("Apple");
        writer.close();
        }
    }
