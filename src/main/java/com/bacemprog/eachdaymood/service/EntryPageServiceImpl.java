package com.bacemprog.eachdaymood.service;

import com.bacemprog.eachdaymood.entity.EntryPage;
import com.bacemprog.eachdaymood.repository.EntryPageRepository;
import com.bacemprog.eachdaymood.util.DebugUtil;
import com.bacemprog.eachdaymood.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EntryPageServiceImpl implements EntryPageService {

    private EntryPageRepository entryPageRepository;

    private EntryService entryService;

    @Autowired
    public EntryPageServiceImpl(EntryPageRepository entryPageRepository, EntryService entryService) {
        this.entryPageRepository = entryPageRepository;
        this.entryService = entryService;
    }

    @Override
    public EntryPage saveNewWithEntries(EntryPage entryPage) {
        if (entryPageRepository.findFirstByEndDateAfter(entryPage.getStartDate()) == null) {
            EntryPage newEntryPage = entryPageRepository.save(entryPage);
            for (LocalDateTime date = entryPage.getStartDate(); date.isBefore(entryPage.getEndDate().plusDays(1)); date = date.plusDays(1)) {
                entryService.saveNew(date, newEntryPage);
            }
            return newEntryPage;
        } else {
            DebugUtil.logError(
                    "****** Entry Page not created because another page exists in that period");
            return null;
        }
    }

    @Override
    public List<EntryPage> getAll() {
        return entryPageRepository.findAll();
    }

    @Override
    public EntryPage findByStartAndEndDate(LocalDateTime startDate, LocalDateTime endDate) {
        return entryPageRepository.findByStartDateAndEndDate(startDate, endDate);
    }

    @Override
    public EntryPage update(int id,EntryPage entryPage) {
        EntryPage existingEntryPage = entryPageRepository.findById(id);

        if (existingEntryPage == null)
            return null;

        entryPage.setId(id);
        PropertyUtil.copyNonNullProperties(entryPage, existingEntryPage);
        entryPageRepository.save(existingEntryPage);
        return existingEntryPage;
    }
}
