package twlve;

import java.util.Collection;
import java.util.HashMap;

public class Father {
    public Collection method(HashMap hashMap){
        System.out.println("父类方法被执行");
        return hashMap.values();
    }
}
