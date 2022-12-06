package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPlayground {
    public static void main(String[] args) {
        System.out.println("Start of HW5");
        // Question 1
        // Write Java statements that do the following:
        // a) Declare an arrayList nums of 15 elements of type Integer.

        ArrayList<Integer> numArray = new ArrayList<Integer>(15);
        //Adds value first to the empty ArrayList to avoid IndexOutOfBounds error
        for(int i = 0; i < 15; i++){
            numArray.add(i);
        }

        // b) Output the value of the tenth element of the array nums.

        System.out.println(numArray.get(10));

        // c) Set the value of the 5th element of the array nums to 99.

        numArray.set(5,99);

        // d) set the value of the 13th element to 15

        numArray.set(13, 15);

        // d) set the value of the 2nd element to 6

        numArray.set(2,6);

        // d) Set the value of the 9th element of the array nums to the sum of the 13th
        // and 2nd elements of the array nums.

        numArray.set(9, numArray.get(13) + numArray.get(2));

        // Question 2
        // a) create an arrayList of Strings that contain each day of the week.(starting
        // on monday)

        ArrayList<String> daysOfTheWeek = new ArrayList<String>(7);
        daysOfTheWeek.add("monday");
        daysOfTheWeek.add("tuesday");
        daysOfTheWeek.add("wednesday");
        daysOfTheWeek.add("thursday");
        daysOfTheWeek.add("friday");
        daysOfTheWeek.add("saturday");
        daysOfTheWeek.add("sunday");

        // b) output each of the days of the week

        for(int i = 0; i < daysOfTheWeek.size(); i++){
            System.out.println(daysOfTheWeek.get(i));
        }

        // c) output the days of the week that we have class

        System.out.println(daysOfTheWeek.get(0));
        System.out.println(daysOfTheWeek.get(2));

        // d) change the arrayList to start on Sunday

        Collections.rotate(daysOfTheWeek, 1);
        //Checks for correction
        System.out.println(daysOfTheWeek.get(0));

        // Question 3
        // a) create an ArrayList and prompt the user for numbers to add to it until the
        // number 0 is selected

        ArrayList<Integer> userNumbers = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int stopNumber = 1;
        while(stopNumber > 0){
            System.out.println("Enter a number: ");
            int userInput = scan.nextInt();
            if(userInput == 0){
                stopNumber = 0;
            }
            else{
                userNumbers.add(userInput);
            }
        }

        // b) return the largest and smallest number

        int largest = userNumbers.get(0);
        int smallest = userNumbers.get(0);

        for(int i = 0; i < userNumbers.size(); i++){
            if(largest < userNumbers.get(i)){
                largest = userNumbers.get(i);
            } else if(smallest > userNumbers.get(i)){
                smallest = userNumbers.get(i);
            }
        }
        System.out.println("The largest number is: " + largest);
        System.out.println("The smallest number is: " + smallest);

        // c) return the ArrayList sorted smallest to largest

        Collections.sort(userNumbers);
        //Checks for correction
        for(Integer i: userNumbers){
            System.out.println(i);
        }

        ArrayList<Integer> sortedArray = new ArrayList<Integer>();
        ArrayList<Integer> tempArray = userNumbers;
        int temp = 0;
        for(int i = 0; i < userNumbers.size(); i++){   
            for(int x = i+1; x < userNumbers.size(); x++){
                if(userNumbers.get(1) > userNumbers.get(x)){
                    temp = userNumbers.get(i);
                    tempArray.set(i,userNumbers.get(x));
                    userNumbers.set(x, temp);
                }
            }
        }
        sortedArray = tempArray;
        //Checks for correction
        for(Integer i: sortedArray){
            System.out.println(i);
        }
        

        // d) take that ArrayList see if its size is divisable by 3 and then output the
        // ArrayList in a matrix format
        // NOTE: make the matrix n X 3 so it can be n rows by 3 columns
        // EX. ArrayList [1,2,3,4,5,6,7,8,9]
        // 1 2 3
        // 4 5 6
        // 7 8 9
        // NOTE: If the ArrayList is NOT divisable by 3 ask the user for more numbers
        // and add them until it is
        // ArrayList Size: 7
        // Please enter 2 more numbers to create the matrix...
        //
        // Hint 1: use collections sort to sort the numbers
        // Hint 2: you can see if the size of the array list is divisible by 3 by
        // running:
        // numbers.size()%3==0
        // Hint 3: You can use this logic to print the array list in a 3x3 pattern once
        // its created:
        // for(int i=0;i<numbers.size();i++)
        // {
        // System.out.print(numbers.get(i)+" ");
        // if((i+1)%3==0)
        // {
        // System.out.println();
        // }
        // }
        if(sortedArray.size()%3 == 0){

            for(int i = 0; i < sortedArray.size(); i++){
                System.out.print(sortedArray.get(i) + " ");
                if((i+1)%3 ==0){
                    System.out.println();
                }
            } 
        } else{
            int remainingNumbers = 3 - (sortedArray.size()%3);
            System.out.println("Please enter " + remainingNumbers + " more numbers to create the matrix...");
            for(int i = 0; i < remainingNumbers; i++){
                System.out.println("Enter a number: ");
                int userNum = scan.nextInt();
                sortedArray.add(userNum);
            }
            
            Collections.sort(sortedArray);

            for(int i = 0; i < sortedArray.size(); i++){
                System.out.print(sortedArray.get(i) + " ");
                if((i+1)%3 ==0){
                    System.out.println();
                }
            } 
        }

    }
}