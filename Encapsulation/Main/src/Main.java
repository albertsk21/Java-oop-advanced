
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int iteration = Integer.parseInt(bfr.readLine());
        List<Person> players = new ArrayList<>();

        for (int i = 0; i < iteration; i++) {
            String[] input = bfr.readLine().split(" ");
            players.add(new Person(input[0],input[1],Integer.parseInt(input[2]),Double.parseDouble(input[3])));

        }
        Team team = new Team("Black Eagles");
        for (Person player : players) {
            team.addPlayer(player);
        }

        System.out.println("The number of players on the main team is:"
                + team.getFirstTeam().size());

        System.out.println("The number of players on the reserve team is:"
                + team.getReserveTeam().size());
    }

}


