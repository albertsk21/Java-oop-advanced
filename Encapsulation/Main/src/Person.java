class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;



    //---CONSTRUCTOR---//
    public Person(String firstName, String lastName, int age, double salary) {
            setFirstName(firstName);
            setLastName(lastName);
            setAge(age);
            setSalary(salary);

     }

    //---GETTERS---//
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }


    //---SETTERS---//
    public void setFirstName(String firstName) {
        if(firstName.length() < 3 ){
            throw new IllegalArgumentException("A person's first name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() < 3 ){
            throw new IllegalArgumentException("A person's first name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("A person's age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if(salary < 460){
            throw  new IllegalArgumentException("A person's salary cannot be less than 460 euro");
        }
        this.salary = salary;
    }

    //---ANOTHER-COMMANDS---//
    public void increaseSalary(double bonus){

        if(this.age < 30){
            this.setSalary(this.salary + ( this.salary * ( bonus / 200 )));

        }else{
            this.setSalary(this.salary + ( this.salary * ( bonus / 100 )));
        }

    }

    @Override
    public String toString() {
        return  String.format("%s %s received %.2f euro",this.getFirstName(),this.getLastName(),this.getSalary());
    }
}
