import java.util.ArrayList;
import java.util.List;

public class Team {


    private String name;
    private final List<Player> players;

    public Team(String name){
        this.setName(name);
        this.players = new ArrayList<>();
    }

    //---SETTERS---//
    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Names cannot be blank.");
        }
        this.name = name.trim();
    }

    //---GETTERS---//
    public String getName() {
        return name;
    }
    public double getRating(){

        int counter = 0;
        double result = 0;
        for (Player player : this.players) {
            result += player.overallSkillLevel();
            counter++;
        }

        result = result / counter;


        if(Double.isNaN(result)){
            result = 0;
        }
        return result;
    }



    //---ANOTHER--COMMANDS---//
    public void addPlayer(Player player){

        this.players.add(player);

    }
    public void removePlayer(String name){

        boolean check = false;
        for (int i = 0; i < this.players.size() ; i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                players.remove(i);
                check = true;
                break;
            }

        }
        if(!check){
            throw new IllegalArgumentException(String.format("Player %s is not in %s.",name,this.getName()));
        }
    }

}
