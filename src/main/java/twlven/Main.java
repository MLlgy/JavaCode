package twlven;

import java.util.ArrayList;

public class Main {

    private ITest iTest;

    public static void main(String[] args) {
//        testLinkList();
        testDuLinkList();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread");
            }
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("Lambda");
        });

        Thread thread1 = new Thread(() -> System.out.println("Lambda"));
        Main main = new Main();
        main.setITest(new ITest() {
            @Override
            public void showTest(int a, String b) {

            }
        });

        Test test = new Test();
        test.setITest(new ITest() {
            @Override
            public void showTest(int a, String b) {
                System.out.println("lambda");
            }
        });

        test.setITest((int a, String b) -> System.out.println("lambda"));
//        test.setITest();
//
    }

    private static void testDuLinkList() {
        DuLinkList<String> duLinkList = new DuLinkList<>();
        duLinkList.insert("zero", 0);
        duLinkList.add("one");
        duLinkList.add("two");
        duLinkList.add("three");
        System.out.println(duLinkList);
        System.out.println(duLinkList.get(2));
        System.out.println(duLinkList.getNodeByIndex(2));
    }

    private static void testLinkList() {
        LinkList<String> linkList = new LinkList<>();
        linkList.insert("zero", 0);
        linkList.add("one");
        linkList.add("two");
        System.out.println(linkList.toString());
        linkList.insert("three", 2);
        System.out.println(linkList.toString());
        System.out.println(linkList.get(0));
        System.out.println(linkList);
        System.out.println(linkList.delete(2));
        System.out.println(linkList);
        System.out.println(linkList.locate("one"));
    }

    private void setITest(ITest iTest) {
        this.iTest = iTest;
    }


}
