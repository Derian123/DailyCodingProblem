//Given an array of integers, find the first missing positive integer
//In other words, find the lowest positive integer that does not exist in the array.
//The array can contain duplicates and negative numbers as well.

import java.util.Arrays;

public class Problem4 {

    public int missingPositiveInt(int[] arr){

        if(arr.length == 0) return 0;
        int nextIndex = 1;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length-1;i++){
            if(arr[i] < 0) nextIndex++;

            else if(arr[i]+1 != arr[nextIndex]){
                return arr[i] + 1;
            }
            nextIndex++;
        }
        return arr[arr.length-1]+1;
    }

    public static void main(String[] args) {
        Problem4 p4 = new Problem4();
        int[] arr = {3,2,1};

        System.out.println(p4.missingPositiveInt(arr));
    }
}
