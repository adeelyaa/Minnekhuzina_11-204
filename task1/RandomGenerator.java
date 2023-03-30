import java.io.*;
import java.util.*;

public class RandomGenerator {
    public static void main(String[] args) {
        int numStrings = new Random().nextInt(51) + 50;
        File file = new File("File.txt");
        try {
            FileWriter writer = new FileWriter(file);
            for (int i = 1; i <= numStrings; i++) {
                int count = new Random().nextInt(9901) + 100;
                writer.write(Integer.toString(count));
                writer.write(" ");
                for (int j = 0; j < count; j++) {
                    int number = new Random().nextInt(10000) + 1;
                    writer.write(Integer.toString(number) + " ");
                }
                writer.write("\n");
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
