import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Rope2 {
    // Array to store the positions of the knots.
    Point[] knots;

    // Set to store the coordinates of the fields visited by the tail.
    Set<String> visitedFields;

    // Field to store the number of fields visited by the tail.
    int fieldsVisited;

    // Constructor for the Rope class.
    public Rope2(int numKnots) {
        // Initialize the array of knots.
        knots = new Point[numKnots];

        // Initialize the set of visited fields.
        visitedFields = new HashSet<>();

        // Set the initial count of fields visited to 1 (the starting field).
        fieldsVisited = 1;
    }
    // Method to move the head in a given direction.
    public void moveHead(char direction) {
        // Get the position of the head knot.
        Point head = knots[0];

        // Update the position of the head based on the given direction.
        switch (direction) {
            case 'U' -> head.y--;
            case 'D' -> head.y++;
            case 'L' -> head.x--;
            case 'R' -> head.x++;
        }
    }

    // Method to move the tail based on the current positions of the knots.
    public void moveTail() {
        // Loop through the knots in the rope, starting from the second knot (the first knot after the head).
        for (int i = 1; i < knots.length; i++) {
            // Get the current knot and the knot in front of it.
            Point currentKnot = knots[i];
            Point frontKnot = knots[i - 1];

            // If the current knot is touching the knot in front of it, do nothing.
            if (Math.abs(currentKnot.x - frontKnot.x) <= 1 && Math.abs(currentKnot.y - frontKnot.y) <= 1) {
                continue;
            }

            // If the current knot and the knot in front of it are in the same row or column, move the current knot one step in the same direction as the knot in front of it.
            if (currentKnot.x == frontKnot.x || currentKnot.y == frontKnot.y) {
                currentKnot.x += (frontKnot.x - currentKnot.x) / Math.max(1, Math.abs(frontKnot.x - currentKnot.x));
                currentKnot.y += (frontKnot.y - currentKnot.y) / Math.max(1, Math.abs(frontKnot.y - currentKnot.y));
            } else {
                // Otherwise, move the current knot one step diagonally to keep up with the knot in front of it.
                if (frontKnot.x > currentKnot.x) {
                    currentKnot.x++;
                } else {
                    currentKnot.x--;
                }

                if (frontKnot.y > currentKnot.y) {
                    currentKnot.y++;
                } else {
                    currentKnot.y--;
                }
            }


            // If the current knot is the tail, update the set of visited fields and the count of visited fields.
            if (i == knots.length - 1) {
                // Check if the tail is moving to a new field.
                String field = currentKnot.x + "," + currentKnot.y;
                if (!visitedFields.contains(field)) {
                    // If the tail is moving to a new field, increment the count of fields visited and add the field to the set of visited fields.
                    fieldsVisited++;
                    visitedFields.add(field);
                }
            }
        }
    }
}

