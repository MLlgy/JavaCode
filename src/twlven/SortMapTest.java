package twlven;

import java.util.*;

public class SortMapTest {

    public static void main(String[] args) {
//        testOne();
//        testTwo();

        int number = 10;
        //原始数二进制
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);
        printInfo(number >>> 1);
    }

    /**
     * 输出一个int的二进制数
     *
     * @param num
     */
    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }


    private static void testTwo() {
        TreeMap treeMap = new TreeMap((o1, o2) -> {
            Bean2 bean = (Bean2) o1;
            Bean2 bean2 = (Bean2) o2;
            return Integer.compare(bean.getAge(), bean2.getAge());
        });
        Bean2 bean = new Bean2(1, "mike");
        Bean2 bean2 = new Bean2(4, "mike2");
        Bean2 bean3 = new Bean2(3, "mike3");
        Bean2 bean4 = new Bean2(1, "mike4");
        treeMap.put(bean, "one");
        treeMap.put(bean4, "two");
        treeMap.put(bean3, "three");
        treeMap.put(bean2, "four");
        treeMap.put(bean2, "five");
        System.out.println(treeMap);


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
        System.out.println(Arrays.binarySearch(treeMap.keySet().toArray(), new Bean(3, "mike3")));

//        treeMap.forEach((beanK, s) ->
//                System.out.println(beanK.toString() + "  " + s)
//        );
    }
}
