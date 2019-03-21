public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        Pair<? extends Employee> employeePair = new Pair<Manager>();
////        employeePair.setData(new Manager());//setData(capture<? extends Employee>)in Pair cannot be appliedto(Manager)
//        Manager employee = (Manager) employeePair.getData();
//
//
//
//        Pair<? super Employee> pair = new Pair<Employee>();
//        pair.setData(new Employee());
////        Employee m = pair.getData();//imcompatible type. Required: Employee, found: capture<? super Employee>
//
//        Pair<?> pair1 = new Pair<String>();
//        Object o = pair1.getData();
//
//        PairUtil.swap(pair1);
//
////        Class

//        Pair<String> pair = new Pair();
//        pair.setData("abc");
//        Pair<Integer> pair2 = new Pair();
//        pair2.setData(new Integer(2));
//
//        System.out.println(pair.getData() + "   --  " + pair2.getData().toString());

        int a = 10;
        if(a>2){
            System.out.println("2");
        }else if(a > 5){
            System.out.println("5");
        }
    }


}
