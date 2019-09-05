package excutors;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("begin");
            System.out.println("我在 Runnable 中 run 方法中执行，线程名为：" + Thread.currentThread().getName());
            System.out.println("end");
        };
//        testOne(runnable);
//        testTwo(runnable);
//        testThree();
//        testFour();

        testFutureTask();
        testFutureTask2();
    }

    /**
     * 线程池中同步执行
     */
    private static void testOne(Runnable runnable) {
        DirectExecutor directExecutor = new DirectExecutor();
        System.out.println("与 runnable 同步执行 one");
        directExecutor.execute(runnable);
        System.out.println("与 runnable 同步执行 two");
    }

    /**
     * 线程池中异步执行
     */
    private static void testTwo(Runnable runnable) {
        ThreadPerTaskExecutor executor = new ThreadPerTaskExecutor();
        System.out.println("与 runnable 异步执行 one");
        executor.execute(runnable);
        System.out.println("与 runnable 异步执行 two");
    }


    /**
     * ExecutorService 执行
     */
    private static void testThree() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableTask task = new CallableTask();
        Future<String> future = executorService.submit(task);
        executorService.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程在执行任务");
        try {
            System.out.println("task运行结果：" + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }


    /**
     * Thread 执行
     */
    private static void testFour() {
        CallableTask callableTask = new CallableTask();
        FutureTask futureTask = new FutureTask(callableTask);
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程在执行任务");
        try {
            System.out.println("task运行结果：" + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }


    private static void testFutureTask() {
        // 创建 FutureTask
        FutureTask<Integer> futureTask
                = new FutureTask<>(() -> 1 + 2);
        // 创建线程池
        ExecutorService es =
                Executors.newCachedThreadPool();
        // 提交 FutureTask
        es.submit(futureTask);
        // 获取计算结果
        try {
            Integer result = futureTask.get();
            System.out.println("result： " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void testFutureTask2() {
        FutureTask<Integer> futureTask
                = new FutureTask<>(() -> 1 + 2);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println("result 2： " + futureTask.get().intValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}

