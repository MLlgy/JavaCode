package copy;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "杰克");
        Student copyStudent = (Student) student.clone();
        printMessage(student, copyStudent);
        student.setName("再见杰克");
        student.setAge(2);
        student.getSubject().setName("Subject Rename Origin Change");
        printMessage(student, copyStudent);
        copyStudent.setAge(3);
        copyStudent.setName("幻觉");
        copyStudent.getSubject().setName("Subject Rename Copy Change");
        printMessage(student, copyStudent);
    }

    private static void printMessage(Student originStudent, Student copiedStudent) {
        System.out.println("student Name is:" + originStudent.getName() + " ,age is " + originStudent.getAge() + " , subject Name is " + originStudent.getSubject().getName());
        System.out.println("copyStudent Name is:" + copiedStudent.getName() + " ,age is " + copiedStudent.getAge() + " , subject Name is " + copiedStudent.getSubject().getName());
        System.out.println("================");


    }
}
