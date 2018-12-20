package com.bacemprog.eachdaymood.service;

import com.bacemprog.eachdaymood.entity.Entry;
import com.bacemprog.eachdaymood.entity.EntryPage;

import java.time.LocalDateTime;

public interface EntryService {

    Entry saveNew(LocalDateTime date, EntryPage entryPage);
    Entry update(int id, Entry entry);
}
