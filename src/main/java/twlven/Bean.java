package twlven;

import java.util.Comparator;

public class Bean implements Comparable {

    private int age;
    private String name;

    public Bean(int age, String name) {
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
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj != null && obj.getClass() == Bean.class) {

            Bean bean = (Bean) obj;
            return age == bean.age;
        }
        return false;
    }

    @Override
    public int compareTo(Object obj) {
        Bean bean = (Bean) obj;
        return Integer.compare(age, bean.age);
    }

    @Override
    public String toString() {
        return "Bean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
