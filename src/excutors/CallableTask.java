package excutors;


import javax.script.ScriptException;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        String name;
        Thread.sleep(3000);
        name = "Mike";
        System.out.println("我是 Task，执行 call 的线程为: " + Thread.currentThread().getName());
        return name;
    }
}
