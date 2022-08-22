package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader  bfr =  new BufferedReader(new InputStreamReader(System.in));


        Map<String,Hardware> hardwareMap = new HashMap<>();
        Map<String, Hardware> dumpMap = new LinkedHashMap<>();

        while(true){

            // INPUT AND SPLIT
            String input = bfr.readLine();
            input = input.replace('(','-');
            input = input.replace(')','-');
            String[] token = input.split("-");

            if(token[0].equals("System Split")){
                break;
            }else if(token[0].equals("RegisterPowerHardware")){

                String[] items = token[1].split(", ");

                String name = items[0];
                int capacity = Integer.parseInt(items[1]);
                int memory = Integer.parseInt(items[2]);


                Hardware hardware = new Hardware(name,"Power",capacity,memory);
                hardware.powerHardware();

                if(hardwareMap.isEmpty()){
                    hardwareMap.put(hardware.getName(),hardware);
                }else{
                    hardwareMap = addElementLast(hardwareMap,hardware);
                }

            }else if(token[0].equals("RegisterHeavyHardware")){

                String[] items = token[1].split(", ");

                String name = items[0];
                int capacity = Integer.parseInt(items[1]);
                int memory = Integer.parseInt(items[2]);

                Hardware hardware = new Hardware(name,"Heavy",capacity,memory);
                hardware.heavyHardware();

                if(hardwareMap.isEmpty()){
                    hardwareMap.put(hardware.getName(),hardware);
                }else{
                    hardwareMap = addElementLast(hardwareMap,hardware);
                }


            }else if(token[0].equals("RegisterExpressSoftware")){


                String[] items = token[1].split(", ");

                String hardwareComponentName = items[0];
                String name = items[1];
                int capacity = Integer.parseInt(items[2]);
                int memory = Integer.parseInt(items[3]);


                if(hardwareMap.containsKey(hardwareComponentName)){

                    Hardware hardware = hardwareMap.get(hardwareComponentName);

                    if(!(capacity > hardware.getMaximumCapacity() || memory > hardware.getMaximumMemory())){
                        Software software = new Software(hardwareComponentName,name,capacity,memory);
                        software.expressSoftware();
                        software.addHardware(hardware);
                        hardware.addSoftware("Express",software);
                        hardwareMap.put(hardwareComponentName,hardware);
                    }
                }

            }else if(token[0].equals("RegisterLightSoftware")){

                String[] items = token[1].split(", ");

                String hardwareComponentName = items[0];
                String name = items[1];
                int capacity = Integer.parseInt(items[2]);
                int memory = Integer.parseInt(items[3]);


                if(hardwareMap.containsKey(hardwareComponentName)){


                    Hardware hardware = hardwareMap.get(hardwareComponentName);

                    if(!(capacity > hardware.getMaximumCapacity() || memory > hardware.getMaximumMemory())){
                        Software software = new Software(hardwareComponentName,name,capacity,memory);
                        software.lightSoftware();
                        software.addHardware(hardware);
                        hardware.addSoftware("Light",software);
                        hardwareMap.put(hardwareComponentName,hardware);
                    }
                }



            }else if(token[0].equals("ReleaseSoftwareComponent")){

                String[] items = token[1].split(", ");

                String hardwareComponentName = items[0];
                String softwareComponentName = items[1];

                if(hardwareMap.containsKey(hardwareComponentName)){
                    Hardware hardware = hardwareMap.get(hardwareComponentName);

                    //CHECK IF IS EXPRESS OR LIGHT SOFTWARE
                    if(hardware.containsExpressSoftware(softwareComponentName)){

                        Software software = hardware.getSoftwareExpress(softwareComponentName);
                        List<Software> expressSoftwareList = hardware.getExpressSoftware();
                        expressSoftwareList.remove(software);
                        hardware.setExpressSoftware(expressSoftwareList);
                       hardwareMap = addElementLast(hardwareMap,hardware);
                    }else if(hardware.containsLightSoftware(softwareComponentName)){

                        Software software = hardware.getSoftwareLight(softwareComponentName);
                        List<Software> lightSoftwareList = hardware.getLightSoftware();
                        lightSoftwareList.remove(software);
                        hardware.setLightSoftware(lightSoftwareList);
                      hardwareMap = addElementLast(hardwareMap,hardware);
                    }


                }
            }else if(token[0].equals("Analyze")){

                printAnalyze(hardwareMap);

            }else if(token[0].equals("Dump")){
                String[] items = token[1].split(", ");

                String hardwareComponentName = items[0];

                if(hardwareMap.containsKey(hardwareComponentName)){

                    Hardware hardware = hardwareMap.get(hardwareComponentName);
                    hardwareMap.remove(hardwareComponentName);
                    dumpMap.put(hardwareComponentName,hardware);

                }

            }else if(token[0].equals("Restore")){
                String[] items = token[1].split(", ");
                String hardwareComponentName = items[0];

                if(dumpMap.containsKey(hardwareComponentName)){

                    Hardware hardware = dumpMap.get(hardwareComponentName);
                    dumpMap.remove(hardwareComponentName);
                    hardwareMap.put(hardwareComponentName,hardware);

                }


            }else if(token[0].equals("Destroy")){
                String[] items = token[1].split(", ");
                String hardwareComponentName = items[0];

                if(dumpMap.containsKey(hardwareComponentName)){
                    dumpMap.remove(hardwareComponentName);
                }

            }else if(token[0].equals("DumpAnalyze")){
                printDump(dumpMap);
            }
        }






        List<Hardware> hardwareList = new ArrayList<>();
        if(hardwareMap.containsKey("SSD")){


            boolean isHDD = false;
            for (Hardware hardware : hardwareMap.values()) {
                if (hardware.getName().equals("HDD")) {
                    isHDD = true;
                    break;
                }
                break;
            }


            if(!isHDD){
                for (Hardware hardware : hardwareMap.values()) {
                    hardwareList.add(hardware);
                }
                Collections.reverse(hardwareList);


                for (Hardware hardware : hardwareList) {
                    hardware.print();
                }
            }else{
                for (Hardware hardware: hardwareMap.values() ) {
                    hardware.print();
                }
            }
        }else{

            for (Hardware hardware: hardwareMap.values() ) {
                hardware.print();
            }

        }





    }


    //---ADD-ELEMENT---//
    public static Map<String, Hardware> addElementLast(Map<String, Hardware> hardwareMap , Hardware hardware){
        Map<String, Hardware> current = new LinkedHashMap<>(hardwareMap);
        Map<String, Hardware> mainMap = new LinkedHashMap<>(hardwareMap);

        hardwareMap.clear();
        mainMap.put(hardware.getName(),hardware);

        for (Hardware hardwareInside : current.values()) {
            mainMap.put(hardwareInside.getName(),hardwareInside);
        }
        return mainMap;
    }


    //---TOTAL MAXIMUM---//
    public static int totalMaximumMemory(Map<String, Hardware> hardwareMap){

        int totalMaximumMemory = 0;
        for (Hardware hardware : hardwareMap.values() ) {
            totalMaximumMemory += hardware.getMaximumMemory();
        }

        return totalMaximumMemory;
    }
    public static int totalMaximumCapacity(Map<String, Hardware> hardwareMap){

        int totalMaximumCapacity = 0;
        for (Hardware hardware : hardwareMap.values() ) {
            totalMaximumCapacity += hardware.getMaximumCapacity();
        }

        return totalMaximumCapacity;
    }

    //---TOTAL-CONSUMPTION---//
    public static int totalMemoryConsumption(Map<String,Hardware> hardwareMap){


        int totalMemoryInUse = 0;
        for (Hardware hardware : hardwareMap.values()) {
            List<Software> lightSoftwareList = hardware.getLightSoftware();
            for (Software software : lightSoftwareList) {
                totalMemoryInUse += software.getMemoryConsumption();
            }

            List<Software> expressSoftwareList = hardware.getExpressSoftware();
            for (Software software : expressSoftwareList) {
                totalMemoryInUse += software.getMemoryConsumption();
            }
        }


        return totalMemoryInUse;
    }
    public static int totalCapacityConsumption(Map<String,Hardware> hardwareMap){


        int totalCapacityInUse = 0;
        for (Hardware hardware : hardwareMap.values()) {
            List<Software> lightSoftwareList = hardware.getLightSoftware();
            for (Software software : lightSoftwareList) {
                totalCapacityInUse += software.getCapacityConsumption();
            }

            List<Software> expressSoftwareList = hardware.getExpressSoftware();
            for (Software software : expressSoftwareList) {
                totalCapacityInUse += software.getCapacityConsumption();
            }
        }


        return totalCapacityInUse;
    }

    //---COUNTERS---//
    public static int countPowerHardware(Map<String, Hardware> hardwareMap){

        int counter = 0;
        for (Hardware hardware : hardwareMap.values()) {
            if(hardware.getType().equals("Power")){
                counter++;
            }
        }
        return counter;
    }
    public static int countHeavyHardware(Map<String, Hardware> hardwareMap){

        int counter = 0;
        for (Hardware hardware : hardwareMap.values()) {
            if(hardware.getType().equals("Heavy")){
                counter++;
            }
        }
        return counter;
    }
    public static int countExpressSoftware(Map<String, Hardware> hardwareMap){
        int counterExpressSoftware = 0;
        for ( Hardware hardware : hardwareMap.values() ) {
            counterExpressSoftware += hardware.countOfExpressSoftwareComponents();
        }
        return counterExpressSoftware;
    }
    public static int countLightSoftware(Map<String, Hardware> hardwareMap){

        int counterLightSoftware = 0;
        for ( Hardware hardware : hardwareMap.values() ) {
            counterLightSoftware += hardware.countOfLightSoftwareComponents();
        }
        return counterLightSoftware;
    }

    //---DUMPED-METHODS---//
    public static int totalDumpedMemory(Map<String, Hardware> hardwareMap){
        int totalMemory = 0;
        for (Hardware hardware : hardwareMap.values()) {
            totalMemory += hardware.totalMemoryConsumptionAllSoftware();
        }
        return totalMemory;
    }
    public static int totalDumpedCapacity(Map<String, Hardware> hardwareMap){
        int totalCapacity = 0;
        for (Hardware hardware : hardwareMap.values()) {
            totalCapacity += hardware.totalCapacityConsumptionAllSoftware();
        }
        return totalCapacity;
    }
    public static int totalSoftwareDumped(Map<String, Hardware> hardwareMap){


        int allSoftwareCounters = 0;
        for (Hardware hardware : hardwareMap.values()) {
            List<Software> lightSoftwareList = hardware.getLightSoftware();
            allSoftwareCounters += lightSoftwareList.size();

            List<Software> expressSoftwareList = hardware.getExpressSoftware();
            allSoftwareCounters += expressSoftwareList.size();
        }

        return allSoftwareCounters;
    }

    //---PRINT---//
    public static void printDump(Map<String, Hardware> hardwareMap){
        System.out.println("Dump Analysis");
        System.out.printf("Power Hardware Components: %d%n",countPowerHardware(hardwareMap));
        System.out.printf("Heavy Hardware Components: %d%n",countHeavyHardware(hardwareMap));
        System.out.printf("Express Software Components: %d%n",countExpressSoftware(hardwareMap));
        System.out.printf("Light Software Components: %d%n",countLightSoftware(hardwareMap));
        System.out.printf("Total Dumped Memory: %d%n",totalDumpedMemory(hardwareMap));
        System.out.printf("Total Dumped Capacity: %d%n",totalDumpedCapacity(hardwareMap));
    }
    public static void printAnalyze(Map<String,Hardware> hardwareMap){
        System.out.println("System Analysis");
        System.out.printf("Hardware Components: %d%n",hardwareMap.size());
        System.out.printf("Software Components: %d%n",totalSoftwareDumped(hardwareMap));
        System.out.printf("Total Operational Memory: %d / %d%n", totalMemoryConsumption(hardwareMap), totalMaximumMemory(hardwareMap));
        System.out.printf("Total Capacity Taken: %d / %d%n",totalCapacityConsumption(hardwareMap), totalMaximumCapacity(hardwareMap));

    }

}
