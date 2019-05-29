package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Main2 {


    public static void main(String[] args) {
//        getConstract();
    }

    private static void getConstract() throws NoSuchMethodException {
        TestClass testClass = new TestClass();
        Class clazz = testClass.getClass();
        String className = clazz.getName();

        Constructor[] classList = clazz.getDeclaredConstructors();

        Constructor constructor = clazz.getDeclaredConstructor();

        for (int i = 0; i < classList.length; i++) {

            int mode = classList[i].getModifiers();
            System.out.println("ClassName : " + className + " " + Modifier.toString(mode));

            Class[] classParamsType = classList[i].getParameterTypes();

            for (int j = 0; j < classParamsType.length; j++) {
                System.out.println(classParamsType[j].getName());
            }

        }

    }
}
