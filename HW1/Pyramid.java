package HW1;
/*
Make the output look like this:
#
##
###
####
#####
####
###
##
#
Hint: the object is created for you (Pyramid) and so is the method (Output)
Hint2: Also notice the method is void meaning you will not be returning anything
*/
public class Pyramid {
    public static void outPut() {
        //Variables declared
        String pyramidBlocks = "";

        for(int x = 0; x < 9; x++){
            if(x < 5){
                pyramidBlocks += "#";
                System.out.println(pyramidBlocks);
            }else if(x > 4){
                System.out.println(pyramidBlocks.substring(0, pyramidBlocks.length() - 1));
                pyramidBlocks = pyramidBlocks.substring(0, pyramidBlocks.length() - 1);
            }
        }
    }
}
