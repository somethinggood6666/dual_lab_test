package by.shchemelev.duallab.schedules;

import by.shchemelev.duallab.enums.BusServices;

public class BusService {
    private final String departureTime;
    private final String arrivalTime;
    private final BusServices busService;

    public BusService(BusServices busService, String departureTime, String arrivalTime) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.busService = busService;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public BusServices getBusService() {
        return busService;
    }

    @Override
    public String toString() {
        return busService + " " + departureTime + " " + arrivalTime;
    }
}
