public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    //---CONSTRUCTOR---//
    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {

        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }


    //---SETTERS---//
    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Names cannot be blank.");
        }
        this.name = name.trim();
    }
    private void setEndurance(int endurance) {
        validateStatus(endurance,"endurance");
        this.endurance = endurance;
    }
    private void setSprint(int sprint) {
        validateStatus(sprint,"sprint");
        this.sprint = sprint;
    }
    private void setDribble(int dribble) {
        validateStatus(dribble,"dribble");
        this.dribble = dribble;
    }
    private void setPassing(int passing) {
        validateStatus(passing,"passing");
        this.passing = passing;
    }
    private void setShooting(int shooting) {
        validateStatus(shooting,"shooting");
        this.shooting = shooting;
    }


    //---GETTERS---//
    public String getName() {
        return name;
    }


    //---ANOTHER-COMMANDS---//
    public double overallSkillLevel(){

        return ((double) (this.endurance + this.dribble + this.passing + this.sprint + this.shooting) / 5);
    }

    private void validateStatus(int number, String status){
        if(number < 0 || number > 100){
            throw new IllegalArgumentException(String.format("A player's %s should be a number between 0 and 100.",status));
        }
    }

}
