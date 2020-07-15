package eleven;

public class ClassD {
    private int num;

    public ClassD(int num) {
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
        return "ClassD{" +
                "num=" + num +
                '}';
    }
}
