package com.bacemprog.eachdaymood.service;

import com.bacemprog.eachdaymood.entity.Entry;
import com.bacemprog.eachdaymood.entity.EntryPage;
import com.bacemprog.eachdaymood.enumeration.EventType;
import com.bacemprog.eachdaymood.repository.EntryRepository;
import com.bacemprog.eachdaymood.util.DateUtil;
import com.bacemprog.eachdaymood.util.DebugUtil;
import com.bacemprog.eachdaymood.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;

@Service
public class EntryServiceImpl implements EntryService {

    private EntryRepository entryRepository;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @Override
    public Entry saveNew(LocalDateTime date, EntryPage entryPage) {

        return entryRepository.save(new Entry(
                date,
                "",
                "",
                null,
                null,
                EventType.Normal,
                entryPage));
    }

    @Override
    public Entry update(int id,Entry entry) {
        Entry existingEntry = entryRepository.findById(id);

        if (existingEntry == null)
            return null;

        entry.setId(id);
        PropertyUtil.copyNonNullProperties(entry, existingEntry);
        if(existingEntry.getFirstInsertDate() == null){
            existingEntry.setFirstInsertDate(DateUtil.getCurrentDateTime());
            existingEntry.setLastUpdateDate(DateUtil.getCurrentDateTime());
        }
        else
            existingEntry.setLastUpdateDate(DateUtil.getCurrentDateTime());

        entryRepository.save(existingEntry);
        return existingEntry;
    }
}
