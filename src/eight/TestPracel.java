package eight;


public class TestPracel {
    public static void main(String[] arg){

        Pracel pracel = new Pracel();
        Contents contents = pracel.contents();
        Destination destination = pracel.destination("name");
        destination.readLabel();

    }
}
