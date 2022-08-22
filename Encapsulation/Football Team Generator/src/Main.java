import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Team> teams = new LinkedHashMap<>();
        String[] input = bfr.readLine().split(";");

        while (!input[0].equals("END")){


            switch (input[0]) {
                case "Team":
                    try {
                        Team team = new Team(input[1]);
                        teams.put(input[1], team);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "Add": {

                    String teamName = input[1];
                    String playerName = input[2];

                    int endurance = Integer.parseInt(input[3]);
                    int sprint = Integer.parseInt(input[4]);
                    int dribble = Integer.parseInt(input[5]);
                    int passing = Integer.parseInt(input[6]);
                    int shooting = Integer.parseInt(input[7]);


                    try {
                        Team team;
                        if (teams.containsKey(teamName)) {
                            team = teams.get(teamName);
                            try {
                                Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);

                                team.addPlayer(player);
                                teams.put(playerName, team);


                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            }

                        } else {
                            System.out.printf("%s: There are no teams registered under this name.%n", teamName);
                        }

                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }


                    break;
                }
                case "Remove": {

                    String teamName = input[1];
                    String playerName = input[2];
                    if (teams.containsKey(teamName)) {
                        Team team = teams.get(teamName);

                        try {
                            team.removePlayer(playerName);

                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }


                    }


                    break;
                }
                case "Rating": {

                    String teamName = input[1];


                    try {
                        Team team;
                        if (teams.containsKey(teamName)) {
                            team = teams.get(teamName);
                            System.out.printf("%s - %d%n", teamName, Math.round(team.getRating()));
                        } else {
                            System.out.printf("%s: There are no teams registered under this name.%n", teamName);
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
            }


            input = bfr.readLine().split(";");
        }


    }


}
