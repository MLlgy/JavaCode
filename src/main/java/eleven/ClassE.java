package eleven;

public class ClassE implements Comparable {
    private int num;

    public ClassE(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ClassE{" +
                "num=" + num +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        ClassE classE = (ClassE) o;
        if (classE.getNum() == num) {
            return 0;
        }
        return classE.getNum() > num ? 1 : -1;
    }
}
