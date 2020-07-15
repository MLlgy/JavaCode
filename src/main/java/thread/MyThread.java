package thread;

public class MyThread extends Thread {

    public MyThread() {
        System.out.println("MyThread 代码执行的 Thread:" + this.getName());
        System.out.println("MyThread 当前的 Thread 的 name:" + Thread.currentThread().getName());
    }

    public void test(){
        System.out.println();
    }
}

