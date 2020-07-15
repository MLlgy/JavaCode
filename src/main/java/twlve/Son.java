package twlve;

import javafx.print.Collation;

import java.util.Collection;
import java.util.Map;

public class Son extends Father {
    public Collection method(Map map) {
        System.out.println("子类方法被执行");
        return map.values();
    }
}
