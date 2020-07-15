package thread.threadpool;

public class B {

    private A a = new A();

    public B() {
        a.setAge(1);
        a.setName("one");
    }

    public A test(){
        A aa = a;

        a.setName("two");
        a.setAge(2);
        return aa;

    }
}
