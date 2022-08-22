package com.company;


import java.util.*;

import java.util.stream.Collectors;

public class Problem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, List<String>> command = new LinkedHashMap<>();


        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] tokens = input.split(";");
            String typeFilter = tokens[1];
            String param = tokens[2];

            if (tokens[0].contains("Add")) {
                command.putIfAbsent(typeFilter, new ArrayList<>());
                command.get(typeFilter).add(param);
            } else {
                if (command.get(typeFilter).size() > 1) {
                    command.get(typeFilter).remove(param);
                } else {
                    command.remove(typeFilter);
                }
            }
            input = scanner.nextLine();
        }


        for (String name : predicateFilter(names, command)) {
            System.out.print(name + " ");
        }
// ->method to do
    }

    private static List<String> predicateFilter(List<String> names, Map<String, List<String>> command) {
        List<String> nameChanged = null;
        for (Map.Entry<String, List<String>> entry : command.entrySet()) {
            for (String param : entry.getValue()) {
                if (entry.getKey().equals("Starts with")) {
                    names = names.stream()
                            .filter(f -> !f.startsWith(param))
                            .collect(Collectors.toList());

                } else if (entry.getKey().equals("Ends with")) {
                    names = names.stream()
                            .filter(f -> !f.endsWith(param))
                            .collect(Collectors.toList());
                } else if (entry.getKey().equals("Length")) {
                    names = names.stream()
                            .filter(f -> f.length() != Integer.parseInt(param))
                            .collect(Collectors.toList());

                } else if (entry.getKey().equals("Contains")) {
                    names = names.stream()
                            .filter(f -> !f.contains(param))
                            .collect(Collectors.toList());

                }
            }
        }

        return names;

    }

}