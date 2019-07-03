package copy;

public class DeepCloneStudent implements Cloneable {
    private int age;
    private String name;
    private Subject subject;

    public DeepCloneStudent(int age, String name) {
        this.age = age;
        this.name = name;
        subject = new Subject("Subject");
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() {
        return new DeepCloneStudent(age, name);
    }
}
