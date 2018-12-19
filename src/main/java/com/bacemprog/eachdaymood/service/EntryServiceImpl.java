package com.bacemprog.eachdaymood.service;

import com.bacemprog.eachdaymood.entity.Entry;
import com.bacemprog.eachdaymood.entity.EntryPage;
import com.bacemprog.eachdaymood.enumeration.EventType;
import com.bacemprog.eachdaymood.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EntryServiceImpl implements EntryService {

    private EntryRepository entryRepository;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @Override
    public void saveNew(LocalDateTime date, EntryPage entryPage) {
        entryRepository.save(new Entry(
                date,
                "",
                "",
                null,
                null,
                EventType.Normal,
                entryPage));
    }
}
