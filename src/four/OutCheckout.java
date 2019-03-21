package four;

public class OutCheckout {

    /**
     * 如果 OutCheckout 实现 ICheckout，同时有一个同名方法的访问权限为 private ，则会报出如下错误
     * Error:(6, 18) java: four.OutCheckout中的setName()无法实现four.ICheckout中的setName()
     * 正在尝试分配更低的访问权限; 以前为public
     * //
     */
//    private void setName(){
//
//    }
    private void setName() {

    }

    protected class InnerCheckout implements ICheckout {

        @Override
        public void setName() {

        }
    }
}
