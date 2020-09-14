package reference;

public class StrongReferenceTest {
    public static void main(String[] args) {
        People[] people = new People[1000];
        for (int i = 0;i< people.length;i++){
            people[i] = new People("name: " + i,"nickName: " + i);
        }
        System.out.println(people[2]);
        System.out.println(people[4]);

        // 强制进行垃圾回收
        System.gc();
        System.runFinalization();

        System.out.println("----GC 后----");

        // 强引用的数组，不受 GC 的影响
        System.out.println(people[2]);
        System.out.println(people[4]);


    }
}
