public class Animal {

    private String name;
    private int age;
    private String gender;



    //---CONSTRUCTOR---//
    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    //---SETTERS---//
    private void setName(String name) {


        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }
    private void setGender(String gender) {
        if(gender == null || gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }
    private void setAge(int age){

        if(age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String produceSound(){
      return "";
    }

    //---GETTERS---//

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {


        String output = String.format("%s\n",getClass().getSimpleName());
               output += String.format("%s %d %s\n", this.getName(), this.getAge(),this.getGender());
               output += this.produceSound();

               return output;
    }
}
