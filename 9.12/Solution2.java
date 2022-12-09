import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        // Read the input from a file.
        BufferedReader reader = new BufferedReader(new FileReader("input9.txt"));

        // Create a new Rope object with 10 knots.
        Rope2 rope = new Rope2(10);

        // Set the initial position of the knots to (0, 0).
        for (int i = 0; i < rope.knots.length; i++) {
            rope.knots[i] = new Point(0, 0);
        }

        // Read each line of the input file.
        String line;
        while ((line = reader.readLine()) != null) {
            // Get the direction and distance of the current motion.
            char direction = line.charAt(0);
            int distance = Integer.parseInt(line.substring(1).trim());

            // Move the head in the specified direction the specified distance.
            for (int i = 0; i < distance; i++) {
                rope.moveHead(direction);

                // Move the tail based on the updated position of the head.
                rope.moveTail();
            }
        }

        // Print the number of fields visited by the tail.
        System.out.println(rope.fieldsVisited);
    }



}

