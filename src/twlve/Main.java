package twlve;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        invoker();
        invoker2();
    }

    private static void invoker() {
        Father f = new Father();
        HashMap map = new HashMap();
        f.method(map);
    }
    private static void invoker2() {
        Son f = new Son();
        HashMap map = new HashMap();
        f.method(map);
    }
}
