package reflect;

import eleven.ClassB;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtils {

    /**
     * 反射出一个构造器
     *
     * @param className        类名
     * @param constructorClass 类构造器参数类列表
     * @param params           实例化实例变量参数类别
     * @return 通过反射获取的实例变量
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static Object createObject(String className, Class[] constructorClass, Object[] params) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor(constructorClass);
        constructor.setAccessible(true);
        return constructor.newInstance(params);
    }

    /**
     * 无参构造器
     * @param className
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static Object createObject(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class[] constructorClass = new Class[]{};
        Object[] params = new Object[]{};
        return createObject(className, constructorClass, params);
    }


    /**
     * 通过反射调用实例方法
     *
     * @param object            实例变量
     * @param methodName        方法参数列表
     * @param methodParamsClass 方法参数
     * @param params
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Object invokeInstanceMethod(Object object, String methodName, Class[] methodParamsClass, Object[] params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (object == null) {
            return null;
        }
        Method method = object.getClass().getDeclaredMethod(methodName, methodParamsClass);
        method.setAccessible(true);
        return method.invoke(object, params);
    }

    /**
     * 通过反射调用类的静态方法
     *
     * @param className
     * @param methodName
     * @param methodParamClass
     * @param params
     * @return
     * @throws Exception
     */
    public static Object invokeStaticMethod(String className, String methodName, Class[] methodParamClass, Object[] params) throws Exception {
        Class clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod(methodName, methodParamClass);
        method.setAccessible(true);
        return method.invoke(null, method);
    }

    /**
     * 通过反射获得指定变量的值
     *
     * @param className
     * @param fieldName
     * @param object
     * @return
     * @throws Exception
     */
    public static Object getFieldObject(String className, String fieldName, Object object) throws Exception {
        Class clazz = Class.forName(className);
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }


    /**
     * 通过反射获得静态变量
     *
     * @param className
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static Object getStaticFieldObject(String className, String fieldName) throws Exception {
        Class clazz = Class.forName(className);
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(null);
    }

    /**
     * 通过反射设置实例变量或静态变量的值
     *
     * @param className
     * @param filedName
     * @param object
     * @param value
     * @throws Exception
     */
    public static void setFieldObject(String className, String filedName, Object object, Object value) throws Exception {
        Class clazz = Class.forName(className);
        Field field = clazz.getDeclaredField(filedName);
        field.setAccessible(true);
        field.set(object, value);
    }

}
