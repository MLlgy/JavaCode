package seven;

public class OutterClass {


    private int age;

    private void outMethod(){

    }

     class InnerClass {
        private final static String name = "";

        private void innerMethod() {
            age++;
            outMethod();
        }

        public void test(){

        }
    }
}
