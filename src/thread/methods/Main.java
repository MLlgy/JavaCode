package thread.methods;


public class Main {

    private static final Object mLockObject = new Object();

    public static void main(String[] args) {
//        waitAndNotifyAll();
//        joinTest();
        yieldTest();
    }

    /**
     thread-1 优先级为：5 ---> 0
     thread-1 优先级为：5 ---> 1
     thread-1 优先级为：5 ---> 2
     thread-4 优先级为：5 ---> 0
     thread-4 优先级为：5 ---> 1
     thread-4 优先级为：5 ---> 2
     thread-4 进入到就绪状态 ---> 2 thread-4
     thread-3 优先级为：5 ---> 0
     thread-3 优先级为：5 ---> 1
     thread-3 优先级为：5 ---> 2
     thread-3 进入到就绪状态 ---> 2 thread-3
     thread-2 优先级为：5 ---> 0
     thread-1 进入到就绪状态 ---> 2 thread-1
     thread-2 优先级为：5 ---> 1
     thread-2 优先级为：5 ---> 2
     thread-2 进入到就绪状态 ---> 2 thread-2
     thread-4 优先级为：5 ---> 3
     thread-4 重新回到运行状态 ---> 3  thread-4
     thread-4 优先级为：5 ---> 4
     thread-3 优先级为：5 ---> 3
     thread-3 重新回到运行状态 ---> 3  thread-3
     thread-3 优先级为：5 ---> 4
     thread-1 优先级为：5 ---> 3
     thread-1 重新回到运行状态 ---> 3  thread-1
     thread-1 优先级为：5 ---> 4
     thread-2 优先级为：5 ---> 3
     thread-2 重新回到运行状态 ---> 3  thread-2
     thread-2 优先级为：5 ---> 4
     */
    private static void yieldTest() {
        YieldThread yieldThread1 = new YieldThread("thread-1");
        YieldThread yieldThread2 = new YieldThread("thread-2");
        YieldThread yieldThread3 = new YieldThread("thread-3");
        YieldThread yieldThread4 = new YieldThread("thread-4");
        YieldThread yieldThread5 = new YieldThread("thread-5");
        yieldThread1.start();
        yieldThread2.start();
        yieldThread3.start();
        yieldThread4.start();
        yieldThread5.start();


    }

    private static void joinTest() {

        Worker worker1 = new Worker("worker-1");
        Worker worker2 = new Worker("worker-2");
        worker1.start();

        long start = System.currentTimeMillis();
        try {
            System.out.println("启动线程 1");
            // 调用 worker1 中的 join 函数，主线程会阻塞知道 worker1 执行完成
            worker1.join();
            System.out.println("启动线程 2");
            // 启动线程2 ，调用 worker2 中的 join 函数，主线程会阻塞知道 worker2 执行完成
            worker2.start();
            worker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程继续执行");
        System.out.println("主线程等待线程 1 和线程 2 的时间为：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static void waitAndNotifyAll() {
        System.out.println("主线程执行");
        Thread thread = new WaitThread();
        thread.start();

//        thread.join();
        long startTime = System.currentTimeMillis();
        synchronized (mLockObject) {
            try {
                System.out.println("主线程等待");
                mLockObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long timsMs = System.currentTimeMillis() - startTime;
        System.out.println("主线程继续 -> 等待耗时：" + timsMs + " ms");
    }


    static class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Work in: " + getName());
        }
    }

    static class WaitThread extends Thread {
        @Override
        public void run() {
            super.run();
            synchronized (mLockObject) {
                try {
                    System.out.println("子线程执行,3s 后执行 notifyAll");
                    Thread.sleep(3000);
                    mLockObject.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class YieldThread extends Thread {

        public YieldThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s 优先级为：%d ---> %d\n", this.getName(), this.getPriority(), i);
                // 当 i = 2 时，调用当前线程执行 yield 函数
                if (i == 2) {
                    System.out.printf("%s 进入到就绪状态 ---> %d %s \n", this.getName(), i,this.getName());
                    Thread.yield();
                }
                if (i == 3) {
                    System.out.printf("%s 重新回到运行状态 ---> %d  %s \n", this.getName(), i, this.getName());
                }
            }
        }
    }
}
