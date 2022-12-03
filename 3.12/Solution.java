import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//code for part 1
public class Solution {
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
            int priority=0;
            Map<String, String> splits = new TreeMap<>();

            while ((text = reader.readLine()) != null) {
                final int mid = text.length() / 2; //get the middle of the String
                splits.put(text.substring(0, mid),text.substring(mid));// put parts of the String in HashMap

            }

            char duplicate;
            String key;
            String value;

            for (Map.Entry<String, String> entry : splits.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                duplicate=findDuplicate(key,value);
                priority+=priorities.get(duplicate);

            }

            System.out.println(priority);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//function for part 1 solution
    public static char findDuplicate(String key, String value){
        for(int i=0; i< key.length();i++){
            if(value.indexOf(key.charAt(i)) != -1) {

                return key.charAt(i);
            }
        }
        //return 9 if no duplicate found
        return '9';
    }
}