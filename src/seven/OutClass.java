package seven;


public class OutClass {

    private int num = 1;
    private int num2 = 3;

    private class InnerClass {

        private int num = 2;

        private void method() {
            System.out.println("innerclass method");
            System.out.println("innerclass method inner num " + num);
            System.out.println("innerclass method inner num " + this.num);
            System.out.println("innerclass method out num " + OutClass.this.num);
            System.out.println("innerclass method out num2 " + num2);
        }

    }

    public static void main(String[] args) {
        OutClass outclass = new OutClass();
        System.out.println("main "+ outclass.num);
        outclass.test();
    }

    private void test() {
        InnerClass inner = new InnerClass();
        inner.method();
        System.out.println("outclass test");
    }
}
