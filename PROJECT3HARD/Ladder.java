package PROJECT3HARD;
import java.util.Random;

public class Ladder {
    
    //Ladder object
    public String[][] ladder(){

        //Random method
        Random random = new Random();

        //Correct ladder(randomized each time its called)
        String[][] correctLadder = new String[10][6];
        for(int i = 0; i < correctLadder.length; i++){

            for(int j = 0; j < correctLadder[i].length; j++){

                if(i == 0 || i == 9){

                    correctLadder[i][j] = "|";

                } else if(j == 1){

                    //Assigns a glass type to either right or left ladder
                   correctLadder[i][j] = String.valueOf(random.nextInt(0,2));
                
                } else if(j == 4){

                    //This took me 30 years to figure out for some reason
                    String num = correctLadder[i][1];
                    String num2 = "1";

                    if(num.equals("1")){
                        num2 = "0";
                    } 

                    correctLadder[i][j] = num2;
                    
                } else{

                   correctLadder[i][j] = "|";

                }
            }
        }

        //Return array
        return correctLadder;

    }

    //Print ladder method
    public void printLadder(String[][] ladder, int row){

        if(row == 100000){

            for(int i = 0; i < ladder.length; i++){

                for(int j = 0; j < ladder[i].length; j++){

                    System.out.print(ladder[i][j]);

                }

                System.out.println();

            }

        } else{

            for(int i = 0; i < row; i++){

                for(int j = 0; j < ladder[i].length; j++){

                    System.out.print(ladder[i][j]);

                }

                System.out.println();

            }

        }

    }
    

}
