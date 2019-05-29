package twlven;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortMapTest {

    public static void main(String[] args) {
        testOne();
    }

    private static void testOne() {

        TreeMap treeMap = new TreeMap();
        Bean bean = new Bean(1, "mike");
        Bean bean2 = new Bean(4, "mike2");
        Bean bean3 = new Bean(3, "mike3");
        Bean bean4 = new Bean(1, "mike4");

        treeMap.put(bean, "one");
        treeMap.put(bean4, "two");
        treeMap.put(bean3, "three");
        treeMap.put(bean2, "four");
        treeMap.put(bean2, "five");
        System.out.println(treeMap);

//        treeMap.forEach((beanK, s) ->
//                System.out.println(beanK.toString() + "  " + s)
//        );
    }
}
