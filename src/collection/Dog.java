package collection;

public class Dog implements Comparable {
    private String name;
    private int age;

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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
    public boolean equals(Object obj) {
        Dog dog = (Dog) obj;
        return dog.name.equals(name);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(Object o) {

        Dog dog = (Dog) o;
        return Integer.compare(age, dog.age);
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
