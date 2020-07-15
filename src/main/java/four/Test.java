package four;

public class Test {
    private static void main(String[] args){

        class InnerBase{
            int a ;
        }

        class SubInnerClass extends InnerBase{
            int b;
        }

        SubInnerClass subInnerClass = new SubInnerClass();
        subInnerClass.a = 1;
        subInnerClass.b = 2;
    }
}
