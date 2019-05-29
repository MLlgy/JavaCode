package twlven;

public class Bean2 {

    private int age;
    private String name;

    public Bean2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Bean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
