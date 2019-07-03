package thirteenth;

import eleven.ClassE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new ClassE(2));
        list.add(new ClassE(1));
        list.add(new ClassE(3));
        System.out.println(list);
        list.sort(Comparator.comparingInt(o -> ((ClassE) o).getNum())
        );
        System.out.println(list);

        ListIterator listIterator = list.listIterator();
        int a = 6;
        while (listIterator.hasNext()) {
            ClassE classE = (ClassE) listIterator.next();
            if (classE.getNum() == 3) {
                listIterator.add(new ClassE(6));
            }
            System.out.println("listIterator " + classE.toString());
        }
        System.out.println(list);
    }

}
