package excutors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class ThreadPerTaskExecutor implements Executor {

    @Override
    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
