package eleven;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test4() {
        EnumSet enumSet = EnumSet.noneOf(EnumA.class);
        enumSet.add(EnumA.ONE);
        enumSet.add(EnumA.THREE);
        enumSet.add(EnumA.TWO);
        System.out.println(enumSet);
        EnumSet enumSet2 = EnumSet.allOf(EnumA.class);
        System.out.println(enumSet2);

        SortedSet treeSet = Collections.synchronizedSortedSet(new TreeSet((o1,o2)->{
            return 0;
        }));
    }


    private static void test3() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new ClassE(2));
        treeSet.add(new ClassE(1));
        treeSet.add(new ClassE(1));
        System.out.println(treeSet);

    }

    private static void test2() {
        TreeSet treeSet = new TreeSet((o1, o2) -> {
            ClassD classD1 = (ClassD) o1;
            ClassD classD2 = (ClassD) o2;
            if(classD1.getNum() == classD2.getNum()){
                return 0;
            }
            return classD1.getNum() > classD2.getNum() ? -1 : 1;
        });
        treeSet.add(new ClassD(1));
        treeSet.add(new ClassD(-1));
        treeSet.add(new ClassD(0));
        ClassD classD = new ClassD(2);
        treeSet.add(classD);
        treeSet.add(classD);
        System.out.println(treeSet);
    }

    private static void test1() {
        HashSet hashSet = new HashSet();
        hashSet.add(new ClassA());
        hashSet.add(new ClassA());
        hashSet.add(new ClassB());
        hashSet.add(new ClassB());
        hashSet.add(new ClassC());
        hashSet.add(new ClassC());
        System.out.println(hashSet);
    }


}
