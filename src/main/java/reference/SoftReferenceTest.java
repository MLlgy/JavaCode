package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftReferenceTest {
    public static void main(String[] args) {
//        test(1000);
//        test(10000);
        testWithQueue(10000);
    }

    private static void testWithQueue(int length) {
        ReferenceQueue<People> referenceQueue = new ReferenceQueue<>();
        SoftReference<People>[] softReferenceArray = new SoftReference[length];
        for (int i = 0;i < length;i++){
            softReferenceArray[i] = new SoftReference<>(new People("name: " + i,"nickName: " + i),referenceQueue);
        }
        System.out.println(softReferenceArray[2].get());
        System.out.println(softReferenceArray[4].get());

        System.gc();
        System.runFinalization();

        System.out.println("---GC 后---");
        System.out.println(softReferenceArray[2].get());
        System.out.println(softReferenceArray[4].get());

        System.out.println("---RefereceQueue---");

        System.out.println(referenceQueue.poll() == softReferenceArray[0]);



    }

    private static void test(int length) {
        SoftReference<People>[] softReferenceArray = new SoftReference[length];
        for (int i = 0;i < length;i++){
            softReferenceArray[i] = new SoftReference<>(new People("name: " + i,"nickName: " + i));
        }
        System.out.println(softReferenceArray[2].get());
        System.out.println(softReferenceArray[4].get());

        System.gc();
        System.runFinalization();

        System.out.println("---GC 后---");
        // 在数组的长度为 1000 时，内存够用，则 GC 前后能够获得相应的对象
        // 在数组的长度为 10000 时，内存够用，内存不够用，则会回收软引用持有的对象，所以一下显示为 null

        System.out.println(softReferenceArray[2].get());
        System.out.println(softReferenceArray[4].get());
    }
}
