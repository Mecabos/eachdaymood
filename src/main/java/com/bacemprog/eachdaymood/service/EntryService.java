package com.bacemprog.eachdaymood.service;

import com.bacemprog.eachdaymood.entity.EntryPage;

import java.time.LocalDateTime;

public interface EntryService {

    void saveNew(LocalDateTime date, EntryPage entryPage);
}
