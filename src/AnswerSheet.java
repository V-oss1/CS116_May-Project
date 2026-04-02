import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnswerSheet {

    private static char[] key;

    private static void setKey(String data) {

        String[] elements = data.split(",");

        key = new char[elements.length - 1];

        for (int i = 0; i < key.length; i++) {
            key[i] = elements[i + 1].charAt(0);
        }

    }

    private static double getScore(char[] ans) {
        double score = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == key[i]) {
                score += 1;
            } else if (ans[i] == '?') {
                score += 0;
            } else {
                score -= 0.25;
            }
        }

        return score;
    }

    private static void grade(String fileName) throws FileNotFoundException {

        File myFile = new File(fileName);
        Scanner myScanner = new Scanner(myFile);

        // set up key
        String firstLine = myScanner.nextLine();
        setKey(firstLine);

        // read students answers, record highest, calculate score

        String toPrint = "";
        double highScore = Double.MIN_VALUE;
        String highScoreStudent = "";

        while (myScanner.hasNextLine()) {

            //Split a line for information
            String line = myScanner.nextLine();
            String[] info = line.split(",");
            String name = info[0];

            char[] answers = new char[info.length - 1];
            for (int i = 0; i < answers.length; i++) {
                answers[i] = info[i + 1].charAt(0);
            }
            double grade = getScore(answers);

            //update toPrint
            toPrint += name + " ";
            for (char c: answers) {
                toPrint += c + " ";
            }
            toPrint += "score = " + grade +"\n";

            //update Highscore
            if (grade > highScore) {
                highScore = grade;
                highScoreStudent = name;
            } else if (grade == highScore){
                highScoreStudent += " " + name;
            }
        }

        //toPrint last line
        toPrint += "Best Student(s): " + highScoreStudent;

        System.out.println(toPrint);

        myScanner.close();

    }

    public static void main(String[] args) throws FileNotFoundException {

        //grade("answers1.txt");
        Grader n = new Grader();
        //n.readMyFile("Papers.txt");
        //n.readMyFile("Final.txt");

    }

}