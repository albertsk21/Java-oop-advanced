package com.company;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<String> invitedPeople = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        Map<String, List<String>> commandMap = new LinkedHashMap<>();

        List<BiPredicate<String, String>> commands = new ArrayList<>();



        while(true){

            String[] input = scanner.nextLine().split(";");
            if("Print".endsWith(input[0])){
                break;
            }else if(input[0].equals("Add filter")){

                String command = input[1];
                String parameter = input[2];

                commandMap.putIfAbsent(command, new ArrayList<>());
                commandMap.get(command).add(parameter);

            }else if(input[0].equals("Remove filter")){
                String command = input[1];
                String parameter = input[2];

                if (commandMap.get(command).size() > 1) {
                    commandMap.get(command).remove(parameter);
                } else {
                    commandMap.remove(command);
                }



            }
        }


        print(invitedPeople,commandMap);

    }

    private static List<String> filterPredicate(List<String> names, Map<String, List<String>> command) {

        List<String> changedName = null;


        BiPredicate<String, String> startsWith = (name, prefix) -> !name.startsWith(prefix);
        BiPredicate<String, String> endsWith = (name, sufix) -> !name.endsWith(sufix);
        BiPredicate<String, String> length = (name, strLength) -> name.length() <= Integer.parseInt(strLength);
        BiPredicate<String,String> containsPredicate = (name,contains) -> !name.contains(contains);


        for (Map.Entry<String, List<String>> entry : command.entrySet()) {
            for (String parameter : entry.getValue()) {
                switch (entry.getKey()) {
                    case "Starts with":
                        names = names.stream()
                                .filter(f -> startsWith.test(f, parameter))
                                .collect(Collectors.toList());

                        break;
                    case "Ends with":
                        names = names.stream()
                                .filter(f -> endsWith.test(f, parameter))
                                .collect(Collectors.toList());
                        break;
                    case "Length":
                        names = names.stream()
                                .filter(f -> length.test(f, parameter))
                                .collect(Collectors.toList());

                        break;
                    case "Contains":
                        names = names.stream()
                                .filter(f -> containsPredicate.test(f, parameter))
                                .collect(Collectors.toList());

                        break;
                }
            }
        }

        return names;

    }
    private static void print(List<String>  people ,   Map<String, List<String>> commandMap){

        for (String name: filterPredicate(people,commandMap)) {
            System.out.print(name + " ");
        }
    }

}
