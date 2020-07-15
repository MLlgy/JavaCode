package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ClassB2Proxy implements InvocationHandler {
    private Object mBase;

    public ClassB2Proxy(Object mBase) {
        this.mBase = mBase;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("执行方法前,方法名" + method.getName());
        if ("doSomething".equals(method.getName())) {
            System.out.println("执行 doSomething 方法");
        }
        return method.invoke(mBase, args);
    }
}
