package four;

class OutStaticClass {

    private int num = 1;
    private static int age = 2;

    private void doSomething(){
        StaticInnerClass.staticNum++;
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.method();
        staticInnerClass.num++;
    }

    protected static class StaticInnerClass {
        private static int staticNum = 10;
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
