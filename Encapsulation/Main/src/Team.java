import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;


    //---CONSTRUCTORS---//
    public Team(String name) {
        this.setName(name);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    //---GETTERS---//
    public String getName() {
        return name;
    }
    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }
    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }


    //---SETTERS---//
    private void setName(String name) {
        this.name = name;
    }

    //---COMMANDS--//
    public void addPlayer(Person person){

        if(person.getAge() < 40){
            this.firstTeam.add(person);
        }else{
            this.reserveTeam.add(person);
        }
    }

}
