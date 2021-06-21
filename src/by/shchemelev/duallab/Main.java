package by.shchemelev.duallab;

import by.shchemelev.duallab.iocontrol.InputFromFile;
import by.shchemelev.duallab.iocontrol.OutputToFile;
import by.shchemelev.duallab.schedules.BusService;
import by.shchemelev.duallab.sorts.SortTimetable;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        makeTimetable("input.txt");
    }

    public static void makeTimetable(String pathToInputFile){
        List<BusService> list = InputFromFile.readDataFromFile(pathToInputFile);
        List<BusService> list2 = SortTimetable.sortBusTimetable(list);
        try {
            OutputToFile.writeDataToFile(list2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
