
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input9.txt"));
            // Set the initial position of the head and tail to (0, 0).
            int headX = 0;
            int headY = 0;
            int tailX = 0;
            int tailY = 0;

            // Create a new Rope object with the starting position for the head and tail.
            Rope rope = new Rope();
            rope.headX = headX;
            rope.headY = headY;
            rope.tailX = tailX;
            rope.tailY = tailY;

            // Read the input to determine the series of movements for the head.
            String line;
            while ((line = reader.readLine()) != null) {
                String[] movement = line.split(" ");
                char direction = movement[0].charAt(0);
                int steps = Integer.parseInt(movement[1]);

                // Move the head the specified number of steps in the given direction.
                for (int i = 0; i < steps; i++) {
                    rope.moveHead(direction);
                    rope.moveTail();
                }
            }
            System.out.println(rope.fieldsVisited);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
