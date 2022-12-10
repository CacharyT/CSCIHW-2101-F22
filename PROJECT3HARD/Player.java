package PROJECT3HARD;

public class Player {
    private int lives;

    public Player(){
        lives = 10;
    }

    public int getLives(){
        return lives;
    }

    public void death(){
        lives = lives - 1;
    }

    public String answer(String direct, String[][] ladderArray, int row){

        //correct continue condition
        String cCondition = "C";

        //incorrect continue condition
        String iCondition = "I";

        //win condition
        String win = "W";

        //invalid answer condition
        String other = "X";

        //Conditions for the answer
        String answer = "";

        if(direct.equals("l") || direct.equals("L")){

            String current = ladderArray[row][1];

            if(current == "|"){

                answer = win;

            } else if(current.equals("0")){

                answer = iCondition;

            } else if(current.equals("1")){

                answer = cCondition;

            } 

        } else if (direct.equalsIgnoreCase("r")){

            String current2 = ladderArray[row][4];

            if(current2 == "|"){

                answer =  win;

            } else if(current2 == "0"){

                answer =  iCondition;

            } else if(current2 == "1"){

                answer =  cCondition;

            }

        } else{

            answer = other;

        }

        return answer;

    }
}
