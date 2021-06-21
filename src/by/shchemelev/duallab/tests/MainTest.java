package by.shchemelev.duallab.tests;

import by.shchemelev.duallab.enums.BusServices;
import by.shchemelev.duallab.iocontrol.InputFromFile;
import by.shchemelev.duallab.schedules.BusService;
import by.shchemelev.duallab.sorts.SortTimetable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    void makeTimetable() {
        List<BusService> givenList = InputFromFile.readDataFromFile("testcases.txt");
        givenList = SortTimetable.sortBusTimetable(givenList);

        List<BusService> resultList = new ArrayList<>();
        resultList.add(new BusService(BusServices.Posh, "05:00", "05:45"));
        resultList.add(new BusService(BusServices.Posh, "07:25", "07:55"));
        resultList.add(new BusService(BusServices.Posh, "09:11", "10:00"));
        resultList.add(new BusService(BusServices.Grotty, "11:20", "12:00"));
        resultList.add(new BusService(BusServices.Grotty, "12:30", "12:55"));

        assertEquals(resultList, givenList);
    }
}