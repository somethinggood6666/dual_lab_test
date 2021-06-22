package by.shchemelev.duallab.sorts;

import by.shchemelev.duallab.schedules.BusService;
import by.shchemelev.duallab.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SortTimetable {
    public static List<BusService> sortBusTimetable(List<BusService> listOfBuses){
        sortTimetableByArrivalTime(listOfBuses);
        List<BusService> sortedList = new ArrayList<>();

        for (int i = 0; i < listOfBuses.size() - 1; i++){
            if (isCorrectCondition(listOfBuses.get(i), listOfBuses.get(i + 1))){
                sortedList.add(listOfBuses.get(i));
            }
        }

        //check the last element separately
        BusService lastElement = listOfBuses.get(listOfBuses.size() - 1);
        if (isTimeLessThanHour(lastElement.getArrivalTime(), lastElement.getDepartureTime())){
            sortedList.add(lastElement);
        }
        removeEqualsBuses(sortedList);
        return sortedList;

    }

    private static void removeEqualsBuses(List<BusService> sortedList) {
        int size = sortedList.size();
        int i = 0;
        while (i < size - 1) {
            if (sortedList.get(i).getDepartureTime().equals(sortedList.get(i + 1).getDepartureTime()) &&
                    (sortedList.get(i).getArrivalTime().equals(sortedList.get(i + 1).getArrivalTime()))){
                if (sortedList.get(i).getBusService().getPriority() > sortedList.get(i + 1).getBusService().getPriority()){
                    sortedList.remove(i + 1);
                } else {
                    sortedList.remove(i);
                }
                size--;
            }
            i++;
        }
    }

    private static boolean isCorrectCondition(BusService x, BusService y) {
        if (x.getDepartureTime().equals(y.getDepartureTime()) &&
                (x.getArrivalTime().equals(y.getArrivalTime()))){
            return x.getBusService().getPriority() > y.getBusService().getPriority();
        }
        return (((x.getArrivalTime().compareTo(y.getArrivalTime())) < 0) &&
                (x.getDepartureTime().compareTo(y.getDepartureTime())) <= 0) &&
                (isTimeLessThanHour(x.getArrivalTime(), x.getDepartureTime()));
    }

    private static boolean isTimeLessThanHour(String arrivalTime, String departureTime) {
        int newTime = Utils.getHours(departureTime) + 1;
        String hour= newTime + ":" + Utils.getMinutes(departureTime);
        String timePlusHour = (newTime < 10) ? (0 + hour) : hour;
        return timePlusHour.compareTo(arrivalTime) > 0;
    }


    private static void sortTimetableByArrivalTime(List<BusService> listOfBuses) {
        for (int i = listOfBuses.size() - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if (listOfBuses.get(j).getDepartureTime().compareTo(listOfBuses.get(j + 1).getDepartureTime()) > 0){
                    swap(listOfBuses, j, j + 1);
                }
            }
        }

    }

    private static void swap(List<BusService> listOfBuses, int j, int i) {
        BusService temp = listOfBuses.get(j);
        listOfBuses.set(j, listOfBuses.get(i));
        listOfBuses.set(i, temp);
    }
}
