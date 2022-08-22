public class BasePerson implements Person {

    //---VARIABLES---//
    private String firstName;
    private String lastName;
    private int age;

    //---CONSTRUCTOR---//
    public BasePerson(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public BasePerson(String firstName){
        this.firstName = firstName;
    }
    protected BasePerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //---SETTERS---//
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //---GETTERS---//
    @Override
    public String getFirstName() {
        return null;
    }
    @Override
    public String getLastName() {
        return null;
    }
    @Override
    public int getAge() {
        return 0;
    }



    //---TO-STRING---//
    @Override
    public String toString() {
        return "BasePerson{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", age=" + this.getAge() +
                '}';
    }


}
