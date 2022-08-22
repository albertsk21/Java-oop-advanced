package hero;

public class Hero {

    private String username;
    private int level;



    //---CONSTRUCTOR---//
    public Hero(String username,int level){
        this.setUsername(username);
        this.setLevel(level);
    }


    //---SETTERS---//
    private void setLevel(int level) {
        this.level = level;
    }
    private void setUsername(String username) {
        this.username = username;
    }

    //---GETTERS---//
    public String getUsername() {
        return username;
    }
    public int getLevel() {
        return level;
    }


    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }
}
