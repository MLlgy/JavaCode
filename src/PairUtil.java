public class PairUtil {
    public static boolean hasNull(Pair<?> pair) {
        return pair.getData() == null;
    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> pair) {
        T t = pair.getData();
        pair.setData(pair.getData());
        pair.setData(t);
    }
}
