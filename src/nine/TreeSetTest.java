package nine;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] strs) {
        TreeSet treeSet = new TreeSet(/*(o1, o2) -> {
            M m1 = (M) o1;
            M m2 = (M) o2;
            return m1.age > m2.age ? -1 : m1.age < m2.age ? 1 : 0;
        }*/);
        treeSet.add(new M(2));
        treeSet.add(new M(3));
        treeSet.add(new M(4));
        treeSet.add(new M(5));
        System.out.println(treeSet);
    }
}
