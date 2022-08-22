public class Employee extends BasePerson{


    private String department;


    public Employee(String firstName, String lastName, int age, String department) {
        super(firstName, lastName, age);
        this.department = department;
    }


    public String getDepartment() {
        return department;
    }



    //---TO-STRING---//
    @Override
    public String toString() {
        return "BasePerson{" +
                "firstName='" + this.getFirstName()+ '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", age=" + this.getAge() +
                '}';
    }



}
