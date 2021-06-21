package by.shchemelev.duallab.schedules;

import by.shchemelev.duallab.enums.BusServices;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusService that = (BusService) o;
        return Objects.equals(departureTime, that.departureTime) && Objects.equals(arrivalTime, that.arrivalTime) && busService == that.busService;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureTime, arrivalTime, busService);
    }

    @Override
    public String toString() {
        return busService + " " + departureTime + " " + arrivalTime;
    }
}
