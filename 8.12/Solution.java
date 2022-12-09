import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        File inputFile = new File("input8.txt");
        try (Scanner scanner = new Scanner(inputFile)) {
            // Read the grid of trees
            ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<Integer> row = new ArrayList<>();

                for (int j = 0; j < line.length(); j++) {
                    row.add(Integer.parseInt(line.substring(j, j + 1)));
                }
                grid.add(row);
            }
            // Count the number of visible trees
            int count = countVisibleTrees(grid);
            int highestScore = getHighestScenicScore(grid);


            // Print the result
            System.out.println(count);
            System.out.println(highestScore);


        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static int countVisibleTrees(ArrayList<ArrayList<Integer>> grid) {
        // Count the number of trees that are visible from outside the grid
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                // Check if the current tree is visible from the left
                boolean visibleFromLeft = true;
                for (int k = 0; k < j; k++) {
                    if (grid.get(i).get(k) >= grid.get(i).get(j)) {
                        visibleFromLeft = false;
                        break;
                    }
                }
                // Check if the current tree is visible from the right
                boolean visibleFromRight = true;
                for (int k = j + 1; k < grid.get(i).size(); k++) {
                    if (grid.get(i).get(k) >= grid.get(i).get(j)) {
                        visibleFromRight = false;
                        break;
                    }
                }
                // Check if the current tree is visible from the top
                boolean visibleFromTop = true;
                for (int k = 0; k < i; k++) {
                    if (grid.get(k).get(j) >= grid.get(i).get(j)) {
                        visibleFromTop = false;
                        break;
                    }
                }
                // Check if the current tree is visible from the bottom
                boolean visibleFromBottom = true;
                for (int k = i + 1; k < grid.size(); k++) {
                    if (grid.get(k).get(j) >= grid.get(i).get(j)) {
                        visibleFromBottom = false;
                        break;
                    }
                }

                // If the current tree is visible from at least one side, increment the count
                if (visibleFromLeft || visibleFromRight || visibleFromTop || visibleFromBottom) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int getHighestScenicScore(ArrayList<ArrayList<Integer>> grid) {
        int maxScore = 0;
        int left;
        int right;
        int up;
        int down;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                int score;
                left=0;
                right=0;
                up=0;
                down=0;
                int currentHeight = grid.get(i).get(j);
                // check up
                for (int k = i - 1; k >= 0; k--) {
                    up++;
                    int height = grid.get(k).get(j);
                    if (height >= currentHeight) break;

                }
                // check right
                for (int k = j + 1; k < grid.get(i).size(); k++) {
                    right++;
                    int height = grid.get(i).get(k);
                    if (height >= currentHeight) break;

                }
                // check down
                for (int k = i + 1; k < grid.size(); k++) {
                    down++;
                    int height = grid.get(k).get(j);
                    if (height >= currentHeight) break;

                }
                // check left
                for (int k = j - 1; k >= 0; k--) {
                    left++;
                    int height = grid.get(i).get(k);
                    if (height >= currentHeight) break;

                }
                score=up*right*left*down;
                if(score>maxScore) maxScore=score;
            }
        }
        return maxScore;
    }

}













