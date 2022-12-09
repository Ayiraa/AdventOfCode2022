import java.util.HashSet;
import java.util.Set;

public class Rope {
    // Fields to represent the position of the head and tail.
    int headX;
    int headY;
    int tailX;
    int tailY;

    // Field to store the number of fields visited by the tail.
    int fieldsVisited;

    // Set to store the coordinates of the fields visited by the tail.
    Set<String> visitedFields;

    // Constructor for the Rope class.
    public Rope() {
        // Initialize the set of visited fields.
        visitedFields = new HashSet<>();

        // Set the initial count of fields visited to 1 (the starting field).
        fieldsVisited = 1;
    }

    // Method to move the head in a given direction.
    public void moveHead(char direction) {
        switch (direction) {
            case 'U' -> headY--;
            case 'D' -> headY++;
            case 'L' -> headX--;
            case 'R' -> headX++;
        }
    }

    // Method to move the tail based on the current position of the head.
    public void moveTail() {
        // If the head and tail are touching, do nothing.
        if (Math.abs(headX - tailX) <= 1 && Math.abs(headY - tailY) <= 1) {
            return;
        }

        // If the head and tail are in the same row or column, move the tail one step in the same direction as the head.
        if (headX == tailX || headY == tailY) {
            tailX += (headX - tailX) / Math.max(1, Math.abs(headX - tailX));
            tailY += (headY - tailY) / Math.max(1, Math.abs(headY - tailY));
        } else {
            // Otherwise, move the tail one step diagonally to keep up with the head.
            if (headX > tailX) {
                tailX++;
            } else {
                tailX--;
            }

            if (headY > tailY) {
                tailY++;
            } else {
                tailY--;
            }
        }

        // Check if the tail is moving to a new field.
        String field = tailX + "," + tailY;
        if (!visitedFields.contains(field)) {
            // If the tail is moving to a new field, increment the count of fields visited and add the field to the set of visited fields.
            fieldsVisited++;
            visitedFields.add(field);
        }
    }
}
