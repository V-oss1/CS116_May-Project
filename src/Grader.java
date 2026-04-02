import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Grader extends AnswerSheet  {
    String userFileString;
    File userFile;


    public void readMyFile(String userFile) {
        boolean valid = false;


        Scanner scan = new Scanner(System.in);

        String[] validFiles = {"answers1.txt", "Final.txt", "Midterm.txt"};

        while (!valid) {
             try {

                 for (int i = 0; i < validFiles.length; i++) {

                     if (userFile.equals(validFiles[i])) {
                         System.out.println("The answer sheet is now graded now.");
                         //Method call?

                         userFileString = userFile;
                         File f = new File(userFileString);
                         this.userFile = f;

                         valid = true;
                         break;

                     } else if (i == validFiles.length-1 && !userFile.equals(validFiles[i])) {
                         throw new InvalidFileException("Not a file");
                     }
                 }

             }
             catch (InvalidFileException e) {
                 System.out.println("File not found. Try again.");
                 userFile = scan.next();
            }
        }

    }

    public void gradeMyFile(File userFile) throws IOException { //maybe private and called by readMyFile method
        FileWriter writer = new FileWriter(userFile, true); //true appends
        writer.write( "\n" + "***");

    }

}

/*
Method 1:
The program allows users to enter the name of an input file (we refer the input file as an answer sheet in the
rest of the problem description) from the console. The program should make the user keep entering file names
until an 𝐚𝐧𝐬𝐰𝐞𝐫 𝐬𝐡𝐞𝐞𝐭 with the entered name is found. COMPLETED


Method 2:
When the program reads in an ungraded answer sheet, it will grade this answer sheet (following the same way
used in the 𝐴𝑛𝑠𝑤𝑒𝑟𝑆ℎ𝑒𝑒𝑡 program) and append the results into the same file (as shown in the above example);
and then the answer sheet becomes graded. After grading, the program should print out a message in the
console to notify users that the grading is successfully done.

Method 3?:
When the program reads in a graded answer sheet, it will print out a message in the console to notify users
that the answer sheet is already graded and do nothing to the file.
 */


