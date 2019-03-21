package four;

public class Main {

    private int name ;

    public static void main(String[] args) {

        OutCheckout.InnerCheckout innerCheckout = new OutCheckout().new InnerCheckout();
        innerCheckout.setName();

//        OutClass.InnerClass staticInnerClass = new OutClass.InnerClass();
//        staticInnerClass.

    }
    private void setName(){
        OutClass.InnerClass staticInnerClass = new OutClass.InnerClass();
//        staticInnerClass.
    }

    private class Inner{
        private int age;
        private void setData(){
            age = name;
        }
    }

}
