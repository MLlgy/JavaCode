package four;

class OutClass {

    private int num = 1;
    private static int age = 2;

    private void doSomething() {
        InnerClass staticInnerClass = new InnerClass();
        staticInnerClass.method();
        staticInnerClass.num++;
    }

    static class InnerClass {

        InnerClass(){

        }

        InnerClass(String name){

        }
        public static int staticNum = 10;
        private int num = 100;

        private void method() {
            num++;
            staticNum++;
            age++;
            // 'four.OutClass.this' cannot be referenced from a static context
            // -- four.OutClass.this 不能再 static 环境下被引用
            // OutClass.this.num++;

        }

    }
}
