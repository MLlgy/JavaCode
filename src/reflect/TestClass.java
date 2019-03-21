package reflect;

public class TestClass {
    private String name = "default";
    private int age;
    private static String tag;

    public TestClass() {
    }

    public TestClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String showName(String string) {
        return name + " && " + string;
    }

    private static void testStaticsMethod() {
        System.out.println("testStaticsMethod");
    }

    public static void printStatics(){
        System.out.println(tag);
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
