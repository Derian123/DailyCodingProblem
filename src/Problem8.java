import java.util.concurrent.*;

//Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.

public class Problem8 {

    //The scheduled job to print out hello world after x milliseoncds
    public void message() {


        System.out.println("Hello World!");

    }

    //Takes in the function message and milliseconds
    public void jobScheduler(Callable<Void> message, int milliseconds) {

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        //lambda function to execute message and the shut down the execution of the message after
        //Prevents leak
        exec.scheduleAtFixedRate(() -> {
            message();
            exec.shutdown();

        }, milliseconds, 1, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        Problem8 p8 = new Problem8();
        p8.jobScheduler(() -> null, 50000);
    }
}
