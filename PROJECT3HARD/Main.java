package PROJECT3HARD;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner object
        Scanner scan = new Scanner(System.in);

        //Player object
        Player player = new Player();

        //Beginning of the game
        int counter = player.getLives();

        //Creates a ladder object & array variable
        Ladder ladder = new Ladder();
        String[][] ladderArray = ladder.ladder();

        //Counter for player position
        int row = 1;

        //Print legend every death
        System.out.println("---------LEGEND-----------");
        System.out.println("0: Glass");
        System.out.println("1: Tempered Glass");
        System.out.println("--------------------------");

        //Loop to continue the game
        while(counter != 0){


            //Prints the ladder(starting point)
            ladder.printLadder(ladderArray,row);
            System.out.println("");

            //Asks for input
            System.out.println("Choose L or R");
            String answer = scan.nextLine();

            //Checks for winner or died or lost lives
            String result = player.answer(answer, ladderArray, row);
            if(result == "C"){

                //Seperator
                System.out.println("");
                System.out.println("--------------------------");
                row+=1;

            } else if(result == "I"){
                
                //Seperator
                System.out.println("");
                System.out.println("--------------------------");

                //death message
                System.out.println("You lost 1 life");
                player.death();
                System.out.println("Total lives: " + player.getLives());
                System.out.println("");
                counter--;

                if(counter == 0){
                    System.out.println("You lost the game");
                }

            } else if(result == "X"){

                System.out.println("please enter L or R");
                if(row == 0){
                    break;
                } else{
                    row--;
                }

            } else if(result == "W"){

                System.out.println("");
                System.out.println("You won the game!");
                ladder.printLadder(ladderArray, 100000);
                counter = 0;

            }

        }

    }

}
