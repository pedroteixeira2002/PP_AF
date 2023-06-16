package CBL;

import Interfaces.Event;
import enumerations.EventType;

import java.time.LocalDate;

public class EventImp implements Event {
    private final EventType type;
    private String location;
    private LocalDate startDate, endDate;

    public EventImp(EventType type, String location, LocalDate startDate, LocalDate endDate) {
        this.type = type;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public EventType getType() {
        return type;
    }
    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public LocalDate getEndDate() {return endDate; }
    @Override

    public void setLocation(String location) {
        this.location = location;
    }
    @Override

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    @Override
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "\n -------Event-------" +
                "\n Type: " + type.toString() +
                "\n Location: " + location +
                "\n Start Date: " + startDate +
                "\n End Date: " + endDate;
    }
}
