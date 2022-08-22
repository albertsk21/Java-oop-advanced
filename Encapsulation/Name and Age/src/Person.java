import java.text.DecimalFormat;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void increaseSalary(double bonus){



        if(this.age >= 30){
            double procentage = bonus / 100;
            double result = this.salary * procentage;
            this.salary = result + this.salary;
        }else{
            double procentage = bonus / 200;
            double result = this.salary * procentage;
            this.salary = result + this.salary;
        }

    }

    @Override
    public String toString() {
//        DecimalFormat decimalFormat = new DecimalFormat("#.###########");
        return String.format("%s %s gets %.2f euro",this.firstName,this.lastName,this.salary);
    }
}
