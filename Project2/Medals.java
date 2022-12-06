package Project2;

import java.util.ArrayList;

public class Medals {

    /*
    Create a program that will print a table of medal winner counts with row totals
    I have provided the initial values needed, all you need to do is put the logic for printing the table
    The table should look like this:
         Country   Gold    Silver    Bronze  Total
         Canada       1       0       1       2
          China       1       1       0       2
        Germany       0       0       1       1
          Korea       1       0       0       1
          Japan       0       1       1       2
         Russia       0       1       1       2
  United States       1       1       0       2
    After that create an ArrayList that is the total of each medal awarded (IE 4 gold, 4 silver, 5 bronze)
    print the total of each medal 
    Hints:
        int rows = counts.length; (get the rows)
        int cols = counts[0].length; (gets the columns)   
        counts[j][i] in a nested for loop would get you the totals of the column  
        Gold    Silver    Bronze
        4       4         5
    FINAL TABLE SHOULD LOOK LIKE THIS:
        Country    Gold    Silver    Bronze  Total
         Canada       1       0       1       2
          China       1       1       0       2
        Germany       0       0       1       1
          Korea       1       0       0       1
          Japan       0       1       1       2
         Russia       0       1       1       2
  United States       1       1       0       2
          Total    Gold    Silver    Bronze   X
                      4       4       5
    */

    public static void main(String[] args) {
        final int COUNTRIES = 7;
        final int MEDALS = 3;

        String[] countries = {
            "Canada",
            "China",
            "Germany",
            "Korea",
            "Japan",
            "Russia",
            "United States"
        };

        int[][] counts = 
        { 
            { 1, 0, 1 },
            { 1, 1, 0 }, 
            { 0, 0, 1 }, 
            { 1, 0, 1 }, 
            { 0, 1, 1 }, 
            { 0, 1, 1 },
            { 1, 1, 0 }
        };
        System.out.println("        Country    Gold    Silver    Bronze   Total");


        // TODO
        // NOTE: THIS CAN BE DONE WITH AN ARRAY OR ARRAY LIST OR BOTH IF YOU FIND IT EASIER
        // Print countries, counts, and row totals (IE total medals by country)
        // for formatting use these printf statements
        // System.out.printf("%15s", countries[i]);
        // System.out.printf("%8d", counts[i][j]);
        // System.out.printf("%8d\n", total);
        // These print statements are just for reference for the table above
        // if you want to change them you can
        // HINTS:
        // You will need a nested for loop 
        // (IE for i less than COUNTRIES, and for j < MEDALS)
        // Process the ith row
        // Print each row element and update the row total
        // Display the row total and print a new line



        // Display the total medals of each medal class
        // First create an Integer Array/ArrayList called medalCounts 
        // your rows are counts.length
        // your columns are counts[0].length

        // Make a for loop that will calculate the sum for each column 
        // hint: make a temp variable for the sum and then at the end of the for loop add each sum of
        // each column to the Array/ArrayList medalCounts
        // print the Array list and chart to look like this
        // Gold    Silver    Bronze
        // 4       4         5

        //Variables
        int[] totalMedals = new int[3];
        int[] medalCounts = new int[1];


        //Columns loop
        for(int i = 0; i < counts.length; i++){


            //temp variable(resets to 0 after each row)
            int tempTotal = 0;
            //Prints country name
            System.out.printf("%15s", countries[i]);


            //Rows loop table output
            for(int j = 0; j < counts[i].length; j++){
                
                //Prints medals
                System.out.printf("%8d", counts[i][j]);
                tempTotal += counts[i][j];
            }

            medalCounts[0] = tempTotal;
            //Prints row total
            System.out.printf("%8d\n", medalCounts[0]);
        }

        //Columns loop
        for(int i = 0; i < counts.length; i++){

            //Rows loop total medals output
            for(int j = 0; j < counts[i].length; j++){
                totalMedals[j] += counts[i][j];
            }

        }

        System.out.println("          Total    Gold    Silver    Bronze   X");
        System.out.print("              ");
            for(Integer z: totalMedals){
                System.out.printf("%8d",z);
            }
     
    }
    
}
