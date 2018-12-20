package com.bacemprog.eachdaymood.dto.entry;

import com.bacemprog.eachdaymood.enumeration.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class EntryDtoForUpdate {

    private String title = "";
    private String description = "";
    private EventType event = EventType.Normal;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEvent() {
        return event;
    }

    public void setEvent(EventType event) {
        this.event = event;
    }
}
