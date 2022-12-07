import java.io.*;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input6.txt");
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;

            while ((text = reader.readLine()) != null) {
                builder.append(text);
            }
            text = builder.toString();
            //part 1 solution
            for(int i=3; i<text.length(); i++){
                String temp = text.substring(i - 3, i + 1);
                if(uniqueCharacters(temp)) {
                    System.out.println(i+1);
                    break;
                }
            }

            //part 2 solution
            for(int i=13; i<text.length(); i++){
                String temp = text.substring(i - 13, i + 1);
                System.out.println(temp);
                if(uniqueCharacters(temp)) {
                    System.out.println(i+1);
                    break;
                }
            }

            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
    static boolean uniqueCharacters(String s)
    {
        // If at any character more than once create another stream
        // stream count more than 0, return false
        return s.chars().filter(e-> Collections.frequency(s.chars().boxed().collect(Collectors.toList()), e) > 1).count() > 1 ? false: true;
    }

    }



