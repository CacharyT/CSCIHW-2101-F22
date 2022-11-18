package HW3;
import java.util.Scanner;

public class Loops {

    //NOTE: DO NOT change anything in the boiler plate
    //If I added default code it is meant to be there
    //and should not be adjusted unless otherwise noted
    //(return statments are usually changed)

    //Make a method that will return true if a given 
    //String contains between 1 and 3 'e' chars.
    //Ex.
    //loopE("eat") -> true
    //eeat -> true
    //eeeat -> true
    //eeeeat -> false

    public static boolean loopE(String str){

        int length = str.length();
        int counter = 0;

        while(length > 0 ){
            if(str.charAt(length-1) == 'e'){
                counter++;
            }
            length--;
        }

        if(counter < 1 || counter > 3){
            return false;
        } else{
            return true;
        }

    }

    //Given a String str and int n return a larger string
    //that is n copies of the original string 
    //Ex.
    //stringTimes("Code",2) ->"CodeCode"
    //stringTimes("Code",4) ->"CodeCodeCodeCode"
    public static String stringTimes(String str, int n) {
        
        String newString = "";
        int counter = n; 

        while(counter > 0){
            counter--;
            newString+=str;
        }

        return newString;
    } 

    //Create a method Given a string, return the string where all of the "z"
    //Have been removed. Except do not remove a z at the start
    //or end
    //Ex.
    //stringZ("zHelzloz") -> "zHelloz"
    //stringZ("nozthaznks") -> "nothanks"
    //stringZ("xksiazdjaasldzsajzasdz") -> "xksiadjaasldsajasdz"
    public static String stringZ(String str){

        String newString = "";
        int length = str.length();
        int counter = 0; 

        while(length > 0){
            if(str.charAt(counter) == 'z' && counter == 0 || str.charAt(counter) == 'z' && counter == str.length()-1){
                newString += str.charAt(counter);
                counter++;
                length--;
            } else if(str.charAt(counter) == 'z' && counter != 0 || str.charAt(counter) == 'z' && counter != length-1){
                counter++;
                length--;
            } else{
                newString += str.charAt(counter);
                counter++;
                length--;
            }
        }
        return newString;
    }

    //Create a method that contains a while loop that allows for
    //The user to input numbers until the number 0 is entered. Each time a number is 
    //entered the total will be summed and then prompted for a second number. 
    //NOTE: I require the use of scanner here to get each integer from the user
    //Assume the numbers entered are integers
    //Also note that the method is void meaning you will not need to return anything
    //It will need to sysout the numbers however
    //Below is a sample output what I would like
    // I will add up the numbers you give me....
    // Number: 12
    // The total so far is 12.
    // Number: 2
    // The total so far is 14.
    // Number: 3
    // The total so far is 17.
    // Number: 4
    // The total so far is 21.
    // Number: 1
    // The total so far is 22.
    // Number: 2
    // The total so far is 24.
    // Number: 3
    // The total so far is 27.
    // Number: 0
    // TOTAL ENDED --- The total is 27.
    public static void sums(){

        Scanner scan = new Scanner(System.in);
        int total = 0;
        int adder = 0;
        int stopNumber = 1;

        System.out.println("I will add up the numbers you give me....");

        while(stopNumber > 0){

            System.out.print("Number: ");
            adder = scan.nextInt();
            total = total + adder;

            if(adder == 0){

                stopNumber = 0;

            } else{

                System.out.println("The total so far is " + total + ".");

            }
        }

        System.out.println("TOTAL ENDED --- The total is " + total + ".");

    }



    public static void main(String[] args) {

        // Add code to help test your methods here
        System.out.println("Start of Main");

        //Checks loopE method
        System.out.println(loopE("eeeeat"));

        //Checks stringTimes method
        System.out.println(stringTimes("Optimal",2));

        //Checks stringZ method
        System.out.println(stringZ("zHelzloz"));
        System.out.println(stringZ("nozthaznks"));
        System.out.println(stringZ("xksiazdjaasldzsajzasdz"));

        //Checks sums method
        sums();

    }
    
}