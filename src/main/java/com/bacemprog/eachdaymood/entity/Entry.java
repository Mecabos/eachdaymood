package com.bacemprog.eachdaymood.entity;

import com.bacemprog.eachdaymood.enumeration.EventType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime date;
    @Length(max = 150)
    private String title = "";
    @Length(max = 10000)
    private String description = "";
    private LocalDateTime firstInsertDate;
    private LocalDateTime lastUpdateDate;
    @Enumerated(EnumType.STRING)
    private EventType event = EventType.Normal;

    @ManyToOne()
    @JoinColumn(name = "entry_page_id")
    private EntryPage entryPage;

    public Entry() {
    }

    public Entry(LocalDateTime date, String title, String description, LocalDateTime firstInsertDate, LocalDateTime lastUpdateDate, EventType event, EntryPage entryPage) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.firstInsertDate = firstInsertDate;
        this.lastUpdateDate = lastUpdateDate;
        this.event = event;
        this.entryPage = entryPage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public EntryPage getEntryPage() {
        return entryPage;
    }

    public void setEntryPage(EntryPage entryPage) {
        this.entryPage = entryPage;
    }
}

