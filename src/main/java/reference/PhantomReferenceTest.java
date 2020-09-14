package reference;


import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.WeakHashMap;

/**
 * 虚引用测试
 */
public class PhantomReferenceTest {

    public static void main(String[] args) {
        String str = new String("我是一个字符串");
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        // 创建一个虚引用，让此虚引用引用到 str
        PhantomReference<String> phantomReference = new PhantomReference<>(str,referenceQueue);
        // 切断 str 引用和字符串之间的引用
        str = null;
        // 试图获取虚引用所引用的对象，但是并不能通过虚引用访问被引用对象，所以输出为 null
        System.out.println(phantomReference.get());
        // 强制垃圾回收
        System.gc();
        System.runFinalization();
        // 取出引用队列中最先进入队列的引用与 phantomReference 进行比较，结果为 true
        System.out.println(referenceQueue.poll() == phantomReference);
    }
}
