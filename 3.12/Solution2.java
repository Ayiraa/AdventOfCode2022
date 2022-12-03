import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Solution2 {
    public static void main(String[] args) {
        File file = new File("input3.txt");

        final Map<Character, Integer> priorities = new HashMap<>();
        //put uppercase letter to priorities map
        for(int i=65; i<=90; i++){
            priorities.put((char)i,i-38);
        }
        //put lowercase letters to priorities map
        for(int i=97; i<=122; i++){
            priorities.put((char)i,i-96);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            String text2;
            String text3;
            int priority=0;

            while ((text = reader.readLine()) != null) {
                text2 = reader.readLine();
                text3 = reader.readLine();
                priority+=priorities.get(findInThree(text,text2,text3));

            }
        System.out.println(priority);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Character findInThree(String text, String text2, String text3){
        for(int i=0; i< text.length();i++){
            if(text2.indexOf(text.charAt(i)) != -1 && text3.indexOf(text.charAt(i)) != -1) {

                return text.charAt(i);
            }
        }
        return '9';
    }
}
