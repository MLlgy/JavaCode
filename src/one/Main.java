package one;

public class Main {

    public static void main(String[] args) {
//       Group mGroup = new Group();
//       Chinese chinese = mGroup.getChinese();
//       chinese.setAge(0);
//       System.out.println(mGroup.getChinese().getAge());

//        A a;
//        a = new A();
////        a.testMethod();
//        a = new B();
////        a.testMethod();

        String str1 = "ab";
        String str2 = "a" + "b";
        System.out.println(str1 == str2);// true

        final String str3 = "a";
        final String str4 = "b";
        String str5 = str3 + str4;
        System.out.println(str1 == str5);

        String str6 = new String("ab");
        System.out.println(str1.equals(str6));
    }

}
