package two;

public class Student {
    final static Student INSTANCE = new Student(3);
    public static int phoen = 123;
    private int age;

    public Student(int age) {
        this.age = age;
        System.out.println("out: "+phoen);
    }
}
