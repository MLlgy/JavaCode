public class Employee {
    private String name;
    private int age = 5;

    {
        String mPhone = "1234";

    }

    private int age2 = 5;


    public Employee(int age) {
        this.age = age;
    }

    public Employee() {
        name = "mike";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
