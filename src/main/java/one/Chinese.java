package one;

import java.util.Objects;

public class Chinese implements Cloneable {
    private String mName;
    private int age;
    private static int phone;


    public Chinese(String mName, int age) {
        this.mName = mName;
        this.age = age;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static int setChange(){
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chinese)) return false;
        Chinese chinese = (Chinese) o;
        return getAge() == chinese.getAge() &&
                Objects.equals(getmName(), chinese.getmName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getmName(), getAge());
    }
}
