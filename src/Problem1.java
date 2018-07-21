/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

        Bonus: Can you do this in one pass?
*/

import java.util.HashMap;

public class Problem1{
//This code does it in one pass as it'll check the number for its compliment.

    public boolean arrayHasSumOf(int[] arr, int target){
        
        //hashmap to store the values
        HashMap<Integer, Integer> map = new HashMap<>();

        //goes to each element once
        for(int i = 0; i < arr.length; i++){

            //if map contains the compliment of the number at index i
            if(map.containsKey(target - arr[i])) return true;

            //else we put the value at index i into the map
            map.put(arr[i], i);
        }
        //if the for loop has finished then there was no match and we can safely return false;
        return false;
    }

    //this way is very inefficient
    //The approach here is to use a nested for loop and check every combination possible

//    public boolean arrayHasSumOf(int[] arr, int target){
//

//        for(int i = 0; i < arr.length-1; i++){
//
//            for(int j = 1; j < arr.length; j++){
//
//                if (arr[i] + arr[j] == target) return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {

        Problem1 p1 = new Problem1();

        int[] arr = {10,15,3,7};

        System.out.println(p1.arrayHasSumOf(arr, 17));
    }

}
