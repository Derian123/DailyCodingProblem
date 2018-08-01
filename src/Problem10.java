//There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N,
//write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
public class Problem10 {

    //The logic here is that we know that the base case for no steps and 1 step is 1
    //We also know that to get the current number of steps we need to add the previous 2 entries to get the current
    //amount of steps
    public int numberOfWays(int steps){

        //we make an array to store the entries
        int[] ways = new int[steps+1];
        ways[0] = 1;
        ways[1] = 1;
        //we loop through it adding i-2 + i-1 to the ith position
        for(int i = 2; i < ways.length;i++){
            ways[i] = ways[i-2] + ways[i-1];
        }
        //then we return the number of steps
        return ways[steps];
    }
    //This method is if instead of going up 1 or 2 steps at a time we go the steps given in an array
    public int numberOfWaysGivenAmountOfSteps(int steps, int[] numSteps){

        //We first construct the possible combinations
        int[] numWays = new int[steps+1];
        numWays[0] = 1;
        numWays[1] = 1;
        int total = 0;

        for(int i = 2; i < numWays.length;i++){
            numWays[i] = numWays[i-2] + numWays[i-1];
        }
        //Afterwards we check if the steps - i < 0 because we can't have a negative step
        //else we increment total by steps - i for the unique ways
        for(int i : numSteps){
            if(steps - i < 0) continue;else total += numWays[steps-i];
        }
        return total;
    }

    public static void main(String[] args) {
        Problem10 p10 = new Problem10();
        int steps = 5;
        int[] numSteps = {1,2};

        System.out.println(p10.numberOfWays(steps));
        System.out.println(p10.numberOfWaysGivenAmountOfSteps(steps, numSteps));
    }
}
