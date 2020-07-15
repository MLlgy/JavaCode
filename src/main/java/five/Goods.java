package five;

import sun.security.krb5.internal.crypto.Des;

public class Goods {
    private class Content implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return 0;
        }
    }

    protected class GDestation implements Destination{
        private String label;

        public GDestation(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination dest(String string){
        return new GDestation(string);
    }

    public Contents cont(){
        return new Content();
    }
}
