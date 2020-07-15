package collection;

import eleven.ClassE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        testList();
//        testHashSet();
//        testTreeSet();
        testList();
    }


    private static void testTreeSet() {
        TreeSet treeSet = new TreeSet();
        Dog dog1 = new Dog("mike", 1);
        Dog dog2 = new Dog("mike", 2);
        Dog dog3 = new Dog("mike", 3);
        Dog dog4 = new Dog("mike", 4);
        treeSet.add(dog1);
        treeSet.add(dog2);
        treeSet.add(dog3);
        treeSet.add(dog4);
        System.out.println("1 " + treeSet);
        treeSet.remove(dog1);
        System.out.println("2 " + treeSet);
        Dog showDog = (Dog) treeSet.first();
        showDog.setAge(6);
        System.out.println("3 " + treeSet);
        System.out.println("4 " + treeSet.remove(new Dog("Mike", 6)));
        System.out.println("5 " + treeSet.remove(new Dog("Mike", 2)));
        System.out.println("6 " + treeSet.first());
        System.out.println("7 " + treeSet.remove(treeSet.first()));
        System.out.println("8 " + treeSet);


    }

    private static void testHashSet() {
        Dog dog = new Dog("mike");
        Dog dog2 = new Dog("mike2");
        HashSet hashSet = new HashSet();
        hashSet.add(dog);
        hashSet.add(dog2);
        System.out.println(hashSet);


    }


    private static void testList() {
        List<ClassE> list = new ArrayList();
        list.add(new ClassE(2));
        list.add(new ClassE(1));
        list.add(new ClassE(3));
        System.out.println(list);
        list.sort(Comparator.comparingInt(o -> o.getNum())
        );
        System.out.println(list);

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ClassE classE = (ClassE) listIterator.next();
            System.out.println(classE);
            if (classE.getNum() == 2) {
                listIterator.add(new ClassE(6));
            }
        }


        System.out.println(list);
        list.set(2,new ClassE(0));

        System.out.println(list);
    }

    private void testQueue(){
        ArrayDeque queue = new ArrayDeque();
//        queue.push();
    }
}
