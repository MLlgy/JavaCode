package thread;

public class StaticSynchronziedMethod {

    public void testMethod() {
        synchronized (StaticSynchronziedMethod.class) {
            doSomething();
        }
    }

    public synchronized void testStaticMethod() {
        doSomething();
    }

    private void doSomething() {
        System.out.println("begin thread name : " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end thread name : " + Thread.currentThread().getName());
    }
}
