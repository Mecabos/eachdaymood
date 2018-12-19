package com.bacemprog.eachdaymood.dto.entry;

import com.bacemprog.eachdaymood.enumeration.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class EntryDtoForRead {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime date;
    private String title = "";
    private String description = "";
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime firstInsertDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime lastUpdateDate;
    private EventType event = EventType.Normal;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

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

    public LocalDateTime getFirstInsertDate() {
        return firstInsertDate;
    }

    public void setFirstInsertDate(LocalDateTime firstInsertDate) {
        this.firstInsertDate = firstInsertDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public EventType getEvent() {
        return event;
    }

    public void setEvent(EventType event) {
        this.event = event;
    }
}
