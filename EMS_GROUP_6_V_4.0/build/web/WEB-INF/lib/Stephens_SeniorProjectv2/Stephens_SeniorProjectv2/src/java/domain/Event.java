package domain;

import java.util.ArrayList;

/**
 *
 * @author Stephen
 */
public class Event {

    private String id;
    private String description;
    private String startTime;
    private String endTime;
    private String date;
    private String eventName;

    public Event(String id) {
        this.id = id;
    }
    
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        String s = endTime.substring(10);
        this.endTime = s;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        String s = startTime.substring(10);
        this.startTime = s;
    }

    @Override
    public String toString() {
        return id + "  " + startTime + "  " + endTime;

    }
}
