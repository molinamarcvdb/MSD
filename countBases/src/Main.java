import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the path to the FASTA file as an argument.");
            return;
        }

        String filePath = args[0];
        try {
            // Load the FASTA file
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Count the number of nucleotides
            int countA = 0;
            int countC = 0;
            int countG = 0;
            int countT = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith(">")) {
                    for (char c : line.toCharArray()) {
                        if (c == 'A') {
                            countA++;
                        } else if (c == 'C') {
                            countC++;
                        } else if (c == 'G') {
                            countG++;
                        } else if (c == 'T') {
                            countT++;
                        }
                    }
                }
            }

            // Print the counts to the console
            System.out.println("Count of A: " + countA);
            System.out.println("Count of C: " + countC);
            System.out.println("Count of G: " + countG);
            System.out.println("Count of T: " + countT);

            // Close the file reader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
