package excutors;

public class Main {
    public static void main(String[] args) {
        DirectExecutor directExecutor = new DirectExecutor();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("begin");
                System.out.println("我在 Runnable 中 run 方法中执行，线程名为：" + Thread.currentThread().getName());
                System.out.println("end");
            }
        };
        System.out.println("与 runnable 同步执行 one");
        directExecutor.execute(runnable);
        System.out.println("与 runnable 同步执行 two");
    }
}
