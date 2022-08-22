public class Animal {


    private String name;



    public Animal(String name){
        this.setName(name);
    }

    //---SETTER---//
    private void setName(String name) {
        this.name = name;
    }

    //---GETTER---//
    public String getName() {
        return name;
    }
}
