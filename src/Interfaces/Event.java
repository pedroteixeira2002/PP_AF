package Interfaces;

import enumerations.EventType;

import java.time.LocalDate;

public interface Event {
    public EventType getType();
    public String getLocation();
    public LocalDate getStartDate();
    public LocalDate getEndDate();
    void setLocation(String location);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);
}
