
 public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
       this.setAge(age);
       this.setName(name);
    }


    //---SETTERS---//
    private void setName(String name) {
        if(name.length() < 1){
            throw new IllegalArgumentException("A chicken's name cannot be empty.");
        }
        this.name = name;
    }
    private void setAge(int age) {

        if(age > 15 || age < 1){
            throw new IllegalArgumentException("A chicken's age can only be a number between 0 and 15.");
        }
        this.age = age;
    }

    //---GETTERS---//
    private String getName() {
        return name;
    }
    private int getAge() {
        return age;
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    private double calculateProductPerDay(){

        double eggPerDay = 0;
        if(this.getAge() >= 0 && this.getAge() < 6){
                eggPerDay = 2;
        }else if(this.getAge() >=6 && this.getAge() < 12 ){
            eggPerDay = 1;
        }else{
            eggPerDay = 0.75;
        }


        return eggPerDay;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) can lay %.2f eggs per day.",getName(),getAge(),productPerDay());
    }
}
