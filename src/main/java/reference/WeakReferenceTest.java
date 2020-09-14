package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    public static void main(String[] args) {
        String str = new String("我是一个字符串");
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        // 创建一个虚引用，让此虚引用引用到 str
        WeakReference<String> weakReference = new WeakReference<>(str,referenceQueue);
//        WeakReference<String> weakReference = new WeakReference<>(str);
        // 切断 str 引用和字符串之间的引用
        str = null;
        // 试图获取虚引用所引用的对象，但是并不能通过虚引用访问被引用对象，所以输出为 null
        System.out.println(weakReference.get());
        // 强制垃圾回收
        System.gc();
        System.runFinalization();
        System.out.println("GC 后：" + weakReference.get());
        System.out.println(referenceQueue.poll().get());
        System.out.println(referenceQueue.poll() == weakReference);
    }
}
