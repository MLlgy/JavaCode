package eleven;

import java.util.*;

public class Main3 {


    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    private static void test5() {
        HashMap hashMap = new HashMap();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("four", 4);
        System.out.println(hashMap);
        hashMap.compute("two", (key, value) -> (Integer) value * (Integer) value);
        hashMap.compute("two", (key, value) -> (Integer) value * (Integer) value);
        System.out.println(hashMap);
    }

    private static void test4() {
        HashMap hashMap = new HashMap();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("four", 4);
        System.out.println(hashMap);

        Set keySet = hashMap.keySet();
        for (Object obj : keySet) {
            System.out.println(hashMap.get(obj));
        }
    }

    private static void test3() {
        ArrayDeque arrayDeque = new ArrayDeque();
        // 将 3 个元素加入队列
        arrayDeque.offer("one");
        arrayDeque.offer("two");
        arrayDeque.offer("three");
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque);
    }

    private static void test2() {
        ArrayDeque arrayDeque = new ArrayDeque();
        //将 3 个元素 push 入栈
        arrayDeque.push("one");
        arrayDeque.push("two");
        arrayDeque.push("three");
        System.out.println(arrayDeque);
        // 访问第一个元素，但不出栈
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque);
        // 第一个元素出栈
        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque);
    }

    private static void test1() {
        List list = new ArrayList();
        list.add(new ClassE(2));
        list.add(new ClassE(1));
        list.add(new ClassE(3));
//        System.out.println(list);
//        list.sort((o1, o2) ->
//            ((ClassE)o1).getNum() -((ClassE)o2).getNum()
//        );
//        System.out.println(list);
//        ((ArrayList) list).ensureCapacity(4);
//        System.out.println(list.size());
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.add("-----");
        }

        System.out.println(list);

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        List arrayList = Arrays.asList(new Object());
    }


}
