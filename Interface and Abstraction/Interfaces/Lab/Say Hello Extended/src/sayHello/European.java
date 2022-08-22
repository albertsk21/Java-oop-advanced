package sayHello;

public class European extends BasePerson implements Person {


    protected European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
