import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {
    public static void main(String[] args) {
        File file = new File("input4.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            int overlappingFully=0;
            int overlapping=0;
            while ((text = reader.readLine()) != null) {
                 // split String input and parse it to int array
                int [] splits = Stream.of(text.split("[-,]"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                if(isOverlappingFully(splits)) overlappingFully++;
                if(isOverlapping(splits)) overlapping++;

            }
            //part 1 answer
            System.out.println(overlappingFully);
            //part 2 answer
            System.out.println((overlapping));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //part 1 function
    public static Boolean isOverlappingFully(int[] splits){
        return (splits[0] >= splits[2] && splits[1] <= splits[3]) || (splits[2] >= splits[0] && splits[3] <= splits[1]);
    }
    //part 2 function
    public static Boolean isOverlapping(int[] splits){
        return max(splits[0], splits[2]) <= min(splits[1], splits[3]);
    }
}