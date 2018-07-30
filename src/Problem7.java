//Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
//
// For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

public class Problem7 {

    public int largestSum(int[] arr){

        int currentSum = 0;
        int previousSum = 0;
        int tempSum;
        //we loop through the array and find the largest sum.
        //We are going to have to sums constantly rotating to see which sum is bigger
        for(int i : arr){

            //This variable will hold the largest total


            //we check to see if the last number(s) added are of a bigger sum that the current sum
            if(previousSum > currentSum)tempSum = previousSum; else tempSum = currentSum;

            //we increment currentsum + the arr[index]
            currentSum = previousSum + i;
            //we set the previous sum to the temp sum
            previousSum = tempSum;
        }

        //We return which ever is bigger
        if(currentSum > previousSum) return currentSum;
        return previousSum;
    }

    public static void main(String[] args) {
        Problem7 p7 = new Problem7();
        int[] arr = {5,1,1,5};
        System.out.println(p7.largestSum(arr));
    }
}
