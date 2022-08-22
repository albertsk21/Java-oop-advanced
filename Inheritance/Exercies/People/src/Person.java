import java.awt.desktop.UserSessionEvent;

public class Person {

    private String name;
    private int age;


    //---CONSTRUCTOR---//
    public Person(String name, int age){
        this.setName(name);
        this.setAge(age);

    }


    //---SETTERS---//
    private void setName(String name) {
        this.name = name;
    }
    private void setAge(int age) {
        this.age = age;
    }



    //---GETTERS---//
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }


}

