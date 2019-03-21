package ten;

import java.util.Objects;

public class R {
    int count ;

    public R(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        R r = (R) o;
        return count == r.count;
    }

    @Override
    public int hashCode() {
        return this.count;
    }
}
