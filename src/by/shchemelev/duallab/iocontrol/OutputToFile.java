package by.shchemelev.duallab.iocontrol;

import by.shchemelev.duallab.enums.BusServices;
import by.shchemelev.duallab.schedules.BusService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputToFile {
    public static void writeDataToFile(List<BusService> serviceList) throws IOException {
        List<BusService> listOfGrottyService = new ArrayList<>();

        //firstly write Posh service buses
        FileWriter fileWriter = new FileWriter("output.txt");
        for (BusService busService: serviceList) {
            if (busService.getBusService() != BusServices.Grotty) {
                fileWriter.write(busService + "\n");
            } else {
                listOfGrottyService.add(busService);
            }
        }
        fileWriter.write("\n");

        //than Grotty service
        for (BusService busService: listOfGrottyService) {
            fileWriter.write(busService + "\n");
        }
        fileWriter.close();

    }

}
