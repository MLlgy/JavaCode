package ten;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
    public static void main(String[] strs){
        HashSet hs = new HashSet();
        hs.add(new R(5));
        hs.add(new R(-3));
        hs.add(new R(9));
        hs.add(new R(-2));
        System.out.println(hs);

        Iterator iterator = hs.iterator();
        R first = (R) iterator.next();
        first.count = -3;
        System.out.println(hs);
        hs.remove(new R(-3));
        System.out.println(hs);
        System.out.println("hs 是否包含 count 为 -3 的 R 对象？"+ hs.contains(new R(-3)));
        System.out.println("hs 是否包含 count 为 -2 的 R 对象？"+ hs.contains(new R(-2)));

    }
}
