import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) {
        File file = new File("input2.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            int points =0;
            List<String> opponent =new ArrayList<>();
            List<String> player =new ArrayList<>();
            while ((text = reader.readLine()) != null) {

                String[] split = text.split(" ");
                opponent.add(split[0]);
                player.add(split[1]);
            }
            for(int i =0;i<opponent.size();i++){
                //calculating points for part 1
                //points+=result(opponent.get(i),player.get(i)) + pointForFigure(player.get(i));
                //calculating points for part2
                points+=pointsForResult(player.get(i)) + figurePoints(opponent.get(i), player.get(i) );
                System.out.println(figurePoints(opponent.get(i), player.get(i)));
            }
            System.out.println(points
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //part 1 functions
    public static int result(String op, String pl){
        //check if its a draw
        if((op.equals("A") && pl.equals("X")) || (op.equals("B") && pl.equals("Y")) || op.equals("C") && pl.equals("Z")){
            return 3;
        //check for win
        }else if((op.equals("A") && pl.equals("Y")) || (op.equals("B") && pl.equals("Z")) || op.equals("C") && pl.equals("X")){
            return 6;
        }else{
            //game lost
            return 0;
        }

    }

    public static int pointForFigure(String pl){
        if(pl.equals("X")) return 1;
        else if(pl.equals("Y")) return 2;
        else return 3;
    }
    //part 2 functions
    public static int pointsForResult(String fig){
        if(fig.equals("Z")) return 6;
        else if(fig.equals("Y")) return 3;
        else return 0;

    }

    public static int figurePoints(String op, String res){
        //check for paper
        if((op.equals("A") && res.equals("Z")) || (op.equals("B") && res.equals("Y")) || (op.equals("C") && res.equals("X"))){
            return 2;
        //check for scissors
        }else if((op.equals("A") && res.equals("X")) || (op.equals("B") && res.equals("Z")) || (op.equals("C") && res.equals("Y"))){
            return 3;
        }else{
            return 1;
        }


    }
}