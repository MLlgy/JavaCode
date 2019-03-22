package reflect;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) {

        try {
//            getSpConstructor();
//            callConstructor();
//            callPrivateMethod();
//            callPrivateMethod();
//            callPrivateStaticsMethod();
//            getPrivateField();
//            getPrivateStaticField();
            getGenerics();
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private static void getGenerics() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        //Singleton 为泛型类，通过以下代码获得指定的 field
        Class<?> singleton = Class.forName("reflect.Singleton");
        Field singletonField = singleton.getDeclaredField("mInstance");
        singletonField.setAccessible(true);

        // 获取 Singleton 的实例对象，只不过这个对象是通过另外一个类产生的
        Class<?> activityManagerNativeClass = Class.forName("reflect.AMN");
        Field gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");
        gDefaultField.setAccessible(true);
        // 获取 gDefaultField 对于的静态实例变量对于的值，并把它包装后返回
        Object gDefault = gDefaultField.get(null);
        System.out.println("gDefault " + gDefault);

        //AMN 的 gDefault 对象的 mInstance 具体值，然后包装成类。 此处 mInstance 为原始 ClassB2 对象
        //获得 gDefault 对象的 singletonField 对应字段的值
        Object raw2Object = singletonField.get(gDefault);

        System.out.println("raw2Object " + raw2Object.toString());

        Class<?> class2Interface = Class.forName("reflect.ClassB2Interface");
        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{class2Interface}, new ClassB2Proxy(raw2Object));


        singletonField.set(gDefault, proxy);

    }

    /**
     * 获得类的私有静态变量并修改它
     */
    private static void getPrivateStaticField() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Class.forName("reflect.TestClass");

        // 获取类的 name 静态字段
        Field field = clazz.getDeclaredField("tag");
        field.setAccessible(true);

        // 为 static 变量时传入 null
        Object fieldObject = field.get(null);
        //修改值
        field.set(fieldObject, "ABCD");

        TestClass.printStatics();

    }

    /**
     * 获取类的实例变量并修改
     */
    private static void getPrivateField() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 通过反射获得类实例
        Class clazz = Class.forName("reflect.TestClass");
        Class[] classes = {String.class, int.class};
        Constructor constructor = clazz.getConstructor(classes);
        Object object = constructor.newInstance("Mike", 3);

        //获得实例变量 getField 获取一个类的public 成员变量包括基类
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);

        //非静态实例变量传入object ,获得 object 的实例变量的值，并把它包装成类
        Object fieldObject = field.get(object);

        //修改 object 对应属于的值
        field.set(object, "test Field");
        System.out.println(fieldObject);

        Object fieldObject1 = field.get(object);
        System.out.println(fieldObject1);

    }

    /**
     * 获取私有静态的方法并调用
     */
    private static void callPrivateStaticsMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取私有静态方法
        Class clazz = Class.forName("reflect.TestClass");
        Method method = clazz.getDeclaredMethod("testStaticsMethod");
        method.setAccessible(true);

        //调用
        method.invoke(null);

    }

    /**
     * 获取私有方法并调用
     */
    private static void callPrivateMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //通过反射获得实例对象
        Class clazz = Class.forName("reflect.TestClass");
        Class[] classes = {String.class, int.class};
        Constructor constructor = clazz.getConstructor(classes);
        Object object = constructor.newInstance("test", 1);
        TestClass testClass = (TestClass) object;

        //获得指定的 private 方法
        Class[] params = {String.class};
        Method method = clazz.getDeclaredMethod("showName", params);
        method.setAccessible(true);

        // 调用指定对象的的方法
        Object[] argList = {"call private method"};
        Object returnParam = method.invoke(testClass, argList);
        System.out.println(returnParam);

    }


    /**
     * 调用构造器新建对象
     */
    private static void callConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("reflect.TestClass");
        Class[] classes = {String.class, int.class};
        Constructor constructor = clazz.getConstructor(classes);
        Object object = constructor.newInstance("test", 1);
        TestClass testClass = (TestClass) object;
        System.out.println(testClass.toString());
    }

    /**
     * 获取指定的构造器
     */
    private static void getSpConstructor() throws NoSuchMethodException {
        TestClass testClass = new TestClass();
        Class clazz = testClass.getClass();
        Class[] classes = {String.class, int.class};
        Constructor constructor = clazz.getConstructor(classes);
        Class[] params = constructor.getParameterTypes();
        for (int i = 0; i < params.length; i++) {
            System.out.println(params[i].getName());
        }
    }


    /**
     * 构造器所有相关
     */
    private static void getAllConstractor() {
        TestClass testClass = new TestClass();
        Class clazz = testClass.getClass();
        String name = clazz.getName();
        System.out.println(name + " 获取所有的构造器");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            int mode = constructors[i].getModifiers();
            System.out.println(String.format("第 %d 个构造器，修饰符为 %d", i, mode));
            Class[] params = constructors[i].getParameterTypes();
            for (int j = 0; j < params.length; j++) {
                System.out.println(params[j].getName());
            }
        }
    }


}
