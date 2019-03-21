package eight;

public class Pracel {
    private class PContents implements Contents{

        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination{

        private String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Contents contents(){
        return new PContents();
    }

    public Destination destination(String s){
        return new PDestination(s);
    }
}
