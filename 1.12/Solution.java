import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int sum =0;
        int max =0;
        int topThree;
        File file = new File("input1.txt");
        List<Integer> sums= new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;

            while ((text = reader.readLine()) != null) {
                if (text.isEmpty()) {
                    if (sum > max) max = sum;
                    sums.add(sum);
                    sum = 0;
                    continue;
                }
                sum += Integer.parseInt(text);
            }
            Collections.sort(sums, Collections.reverseOrder());
            topThree = sums.get(0) + sums.get(1) + sums.get(2);
            System.out.println("Elf carrying the most calories is carrying: " + max + " calories");
            System.out.println("Sum of top three elves are carrying in total: " + topThree + " calories");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

