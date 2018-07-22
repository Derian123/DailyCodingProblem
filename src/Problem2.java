//Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
//
//        For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
//
//        Follow-up: what if you can't use division?

import java.util.Arrays;

public class Problem2 {

    //This solution uses division
    public int[] multiplyEachArrayIndex(int[] arr){
        int total = 1;
        int[] products = new int[arr.length];

        //We run through it the original array the first time to get the total of all elements
        for (int num : arr) total *= num;

        //We run through it a second time and divide each number by the total which will give us the number
        //as if we multiplied it by the others
        for(int i = 0; i < arr.length; i++) products[i] = total / arr[i];

        return products;
    }

    //This solution does not use division
    public int[] withoutDivisionMultiplyEachArrayIndex(int[] arr){

        int[] products = new int[arr.length];
        int result = 1;
        //We go from the left side where we put in the results of going through all the indices once
        //hence this will get the rightmost number and only do half the work since all the numbers will
        //only be multiplied by the numbers that came before it
        for(int i = 0; i < arr.length;i++){
            products[i] = result;
            result *= arr[i];
        }
        result = 1;

        //Then we start from the right side and multiply what we have in the array
        //we multiply by the result because that is the product of all the numbers that came before it.
        //which would finish up the work/
        for(int i = arr.length-1; i > -1; i--){
            products[i]*= result;
            result *= arr[i];
        }
        return products;
    }

    public static void main(String[] args) {
        Problem2 p2 = new Problem2();
        int[] arr = {2,3,4,5,6};
        int[] arr2 = {1,2,3};

        System.out.println(Arrays.toString(p2.multiplyEachArrayIndex(arr)));
        System.out.println(Arrays.toString(p2.withoutDivisionMultiplyEachArrayIndex(arr2)));
    }
}
