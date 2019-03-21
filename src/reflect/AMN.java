package reflect;

public class AMN {
    private static final Singleton<ClassB2Interface> gDefault = new Singleton<ClassB2Interface>() {
        @Override
        protected ClassB2Interface create() {
            ClassB2 classB2 = new ClassB2();
            classB2.id = 34;
            return classB2;
        }
    };

    public static ClassB2Interface getDefault() {
        return gDefault.get();
    }

}
