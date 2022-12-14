public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){

        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);

    }
     public Dough(String flourType,  double weight){
        this.setFlourType(flourType);
        this.setWeight(weight);
    }



    //---SETTERS---//
    private void setWeight(double weight) {
        if(!(weight >= 1 &&  weight <= 200) ){
            throw new IllegalArgumentException( "Dough weight should be in the range (1..200)");

        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {

        if(!TypeUtils.DOUGH_TYPES.containsKey(flourType)){
            throw new IllegalArgumentException( "Invalid type of dough");
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {

      if(!TypeUtils.BAKING_TECHNIQUES.containsKey(bakingTechnique)){
          throw new IllegalArgumentException( "Invalid type of dough");
      }
        this.bakingTechnique = bakingTechnique;
    }


    //---GETTERS---//
    public double getWeight() {
        return weight;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    public String getFlourType() {
        return flourType;
    }


    public double calculateCalories(){
            return 2 * this.getWeight() * TypeUtils.BAKING_TECHNIQUES.get(this.getBakingTechnique()) * TypeUtils.DOUGH_TYPES.get(this.getFlourType());
    }
}
