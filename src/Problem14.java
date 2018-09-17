import java.io.IOException;

//push(val), which pushes an element onto the stack
//pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
//max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
public class Problem14 {

    //Array for stack
    int[] stack = new int[10];
    //Use the min value to account for negatives
    int max = Integer.MIN_VALUE;
    //start index at -1 to ensure nothing is in the stack
    int index = -1;

    public void push(int x){
        //increment index
        index++;
        //array at index is set to input
        stack[index] = x;

        //we check to see if the current max is less than x
        if(x > max) max = x;
    }
    public int pop(){
        //get the value that we're going to pop
        int res = stack[index];
        //decrement index
        index--;
        //return the value that we popped
        return res;
    }
    public int max() throws IOException {
        //if there is nothing in the stack then we throw and an exception
        if(index == -1){
            throw new IOException("Nothing in stack");
        }

        //else we return the max
        return max;
    }

    //To resize the array
    public int[] resize(){
        //Make a new array
        int[] newStack = new int[stack.length*2];

        //Copy the old array into the new array
        for(int i = 0; i < stack.length;i++){
            newStack[i] = stack[i];
        }
        //then we set the old array reference to the new one
        stack = newStack;
        //we return the new stack and essentially delete the old one since there is no reference to it anymore
        return stack;

    }

    public static void main(String[] args) {
        Problem14 p14 = new Problem14();
        try {
            System.out.println(p14.max());
        } catch (IOException e) {
            e.printStackTrace();
        }
        p14.push(2);
        p14.push(22);
        p14.push(432);
        p14.push(762);
        p14.push(6542);
        p14.push(4321);
        try {
            System.out.println(p14.max());
        } catch (IOException e) {
            e.printStackTrace();
        }
        p14.resize();
        System.out.println(p14.stack.length);
        p14.push(14);
        System.out.println(p14.pop());
    }

}
