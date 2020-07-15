package nine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        Collection c = new ArrayList();
        c.add("i1");
        c.add("i2");
        c.add("i3");
        c.add("i4");

        Iterator iterable = c.iterator();
        while (iterable.hasNext()){
            String str = (String) iterable.next();
            if("i1".equals(str)){
//                iterable.remove();
                str = "fdf";
            }
            System.out.println(str);
        }
        System.out.println(c);

    }

    private static void test1() {
        Collection c = new ArrayList();
        c.add(1);
        c.add("r");
        System.out.println("c 集合元素" + c);

        Collection books = new HashSet();
        books.add("r");
        books.add("r12");
        books.add("r");// 这个元素不会被添加到set 中
        books.add("r23");
        System.out.println("books 元素 "+ books);

        c.removeAll(books);
        System.out.println("c 集合元素" + c);
        c.retainAll(books);
        System.out.println("c 集合元素" + c);
    }

}
