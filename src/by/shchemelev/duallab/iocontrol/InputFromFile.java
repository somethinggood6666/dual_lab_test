package by.shchemelev.duallab.iocontrol;

import by.shchemelev.duallab.enums.BusServices;
import by.shchemelev.duallab.exceptions.InvalidDataException;
import by.shchemelev.duallab.schedules.BusService;
import by.shchemelev.duallab.utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFromFile {
    public static List<BusService> readDataFromFile(String path){
        List<BusService> listOfBuses = new ArrayList<>();
        File file = new File(path);
        Utils.requireExistingFile(file);

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] fileData;
        //fileData consists of 3 fields - service name, departure time, arrival time.

        while (scanner.hasNext()){
            fileData = scanner.nextLine().split(" ");
            requireCorrectFileData(fileData);
            listOfBuses.add(new BusService(BusServices.valueOf(fileData[0]), fileData[1], fileData[2]));
        }

        return listOfBuses;
    }

    private static void requireCorrectFileData(String[] fileData) {
        if (!isBusService(fileData[0])
                || !isTimeCorrect(fileData[1])
                || !isTimeCorrect(fileData[2])
                || (fileData[1].compareTo(fileData[2])) >= 0){
            try {
                throw new InvalidDataException("Data has wrong format");
            } catch (InvalidDataException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private static boolean isBusService(String service){
        BusServices[] busServices = BusServices.values();
        for (BusServices busService: busServices) {
            if (busService.toString().equals(service)){
                return true;
            }
        }
        return false;
    }

    private static boolean isTimeCorrect(String time){
        return time.matches("^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$");
    }
}
