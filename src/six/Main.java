package six;


public class Main {

    public  void main(String[] args) {

        final String  name = "name";
        show(new IClick() {
            @Override
            public void change() {
                System.out.println(name);
            }
        });
    }

    private  void show(IClick click){
        click.change();
    }
}
