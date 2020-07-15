package A1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class One {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask(() -> 1+2);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
