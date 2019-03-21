package eleven;

import two.Student;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3(){
        ArrayDeque queue = new ArrayDeque();
        queue.offer("Java EE");
        queue.offer("Java PE");
        queue.offer("Java SE");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());

        System.out.println(queue);

    }
    /**
     * ArrayDeque 做栈
     */
    private static void test2(){
        ArrayDeque stack = new ArrayDeque();
        stack.push("Java EE");
        stack.push("Java SE");
        stack.push("Java PE");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    private static void test1(){
        String[] strings = new String[4];
        strings[0] = "0";
        strings[1] = "1";
        strings[2] = "2";
        strings[3] = "3";
        List arrays = Arrays.asList(strings);
        System.out.println(arrays);

    }


}
