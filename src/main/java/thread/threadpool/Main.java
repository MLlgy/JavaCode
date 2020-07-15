package thread.threadpool;

import java.util.HashMap;
import java.util.concurrent.*;

public class Main {

    private static ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        try {
            futureWithRunnable();
            futureWithCallable();
            futureTask();
            threadWithFuture();
//            ArrayBlockingQueue

//            ConcurrentHashMap

            test();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test() {
        B b = new B();
        A a = b.test();
        System.out.println(a.getAge() + " " + a.getName());
    }

    private static void threadWithFuture() {
        Thread thread = new Thread(new FutureTask<>(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("------");
                return fibc(20);
            }
        }));
        thread.start();
    }

    /**
     * 向线程池中提交 FutureTask
     */
    private static void futureTask() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return fibc(20);
            }
        });
        //向线程池中提交 futureTask
        mExecutor.submit(futureTask);
        System.out.println("future result from futureTask is " + futureTask.get());

    }


    /**
     * 提交 Callable ，又返回值
     */
    private static void futureWithCallable() throws ExecutionException, InterruptedException {

        Future<Integer> future = mExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return fibc(20);
            }
        });
        System.out.println("future result from callable is " + future.get());

    }

    /**
     * 向线程池中提交 Runnable 对象,但是由于 Runnable 没有返回值，所以无法返回数据，打印结果为：future result from runnable is null
     */
    private static void futureWithRunnable() throws ExecutionException, InterruptedException {
        Future<?> result = mExecutor.submit(new Runnable() {
            @Override
            public void run() {
                fibc(20);
            }
        });
        System.out.println("future result from runnable is " + result.get());
    }

    private static int fibc(int num) {

        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }
        return fibc(num - 1) + fibc(num - 2);//recursive call
    }
}
