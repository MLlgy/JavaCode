package excutors;

import java.util.concurrent.Executor;

public class DirectExecutor implements Executor {
    public void execute(Runnable r) {
        System.out.println("线程池中执行，线程名为：" + Thread.currentThread().getName());
        r.run();
    }
}