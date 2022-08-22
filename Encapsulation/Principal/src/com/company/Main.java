package com.company;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] scannerPeople = scanner.nextLine().split(" ");


        List<String> invitedPeople = new ArrayList<>(Arrays.asList(scannerPeople));

        BiPredicate<String, String> startsWith = (name, prefix) -> !name.startsWith(prefix);
        BiPredicate<String, String> endsWith = (name, sufix) -> !name.endsWith(sufix);
        BiPredicate<String, String> length = (name, strLength) -> name.length() != Integer.parseInt(strLength);
        BiPredicate<String,String> containss = (name,contains) -> !name.contains(contains);


        Map<String,BiPredicate<String ,String >> commands = new LinkedHashMap<>();
        commands.put("Starts with",startsWith);
        commands.put("Ends with",endsWith);
        commands.put("Contains",containss);
        commands.put("Length",length);


        List<String> eliminatedPeople = new ArrayList<>();

        while(true){

            String[] input = scanner.nextLine().split(";");
            if("Print".endsWith(input[0])){

                for (int i = 0; i <invitedPeople.size() ; i++) {
                    if(i == invitedPeople.size() - 1){
                        System.out.printf("%s%n", invitedPeople.get(i));
                    }else {
                        System.out.printf("%s ",invitedPeople.get(i));
                    }
                }
                break;
            }else if(input[0].equals("Add filter")){

                String command = input[1];
                String parameter = input[2];
                for (int i = 0; i < invitedPeople.size(); i++) {
                    if (commands.get(command).test(invitedPeople.get(i), parameter)) {
                        eliminatedPeople.add(invitedPeople.get(i));
                        invitedPeople.remove(invitedPeople.get(i));
                        i--;
                    }
                }

            }else if(input[0].equals("Remove filter")){
                String command = input[1];
                String parameter = input[2];


                for (String eliminatedPerson : eliminatedPeople) {
                    if (commands.get(command).test(eliminatedPerson, parameter)) {
                        invitedPeople.add(invitedPeople.size() - 1,eliminatedPerson);
                    }
                }

            }
        }


    }
}
