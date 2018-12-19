package com.bacemprog.eachdaymood.service;

import com.bacemprog.eachdaymood.entity.EntryPage;

import java.time.LocalDateTime;
import java.util.List;

public interface EntryPageService {

    EntryPage saveNewWithEntries(EntryPage entryPage);
    List<EntryPage> getAll();
    EntryPage findByStartAndEndDate (LocalDateTime startDate, LocalDateTime endDate);
    EntryPage update(int id, EntryPage entryPage);
}
