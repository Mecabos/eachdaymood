package com.bacemprog.eachdaymood.service;

import com.bacemprog.eachdaymood.entity.EntryPage;
import com.bacemprog.eachdaymood.repository.EntryPageRepository;
import com.bacemprog.eachdaymood.util.DateUtil;
import com.bacemprog.eachdaymood.util.DebugUtil;
import com.bacemprog.eachdaymood.util.PropertyUtil;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntryPageServiceImpl implements EntryPageService {

    private EntryPageRepository entryPageRepository;

    private EntryService entryService;

    private EntityManager entityManager;

    @Autowired
    public EntryPageServiceImpl(EntryPageRepository entryPageRepository, EntryService entryService, EntityManager entityManager) {
        this.entryPageRepository = entryPageRepository;
        this.entryService = entryService;
        this.entityManager = entityManager;
    }

    @Override
    public EntryPage saveNewWithEntries(EntryPage entryPage) {
        if (entryPageRepository.findFirstByEndDateAfter(entryPage.getStartDate()) == null) {
            entryPageRepository.save(entryPage);
            for (LocalDateTime date = entryPage.getStartDate(); date.isBefore(entryPage.getEndDate().plusDays(1)); date = date.plusDays(1)) {
                entryPage.getEntryList().add(entryService.saveNew(date, entryPage));
            }
            return entryPage;
        } else {
            DebugUtil.logError(
                    "****** Entry Page not created because another page exists in that period");
            return null;
        }
    }

    @Override
    public EntryPage get(int id) {
        return entryPageRepository.findById(id);
    }

    @Override
    public List<EntryPage> getAll() {
        return entryPageRepository.findAll();
    }

    @Override

    public EntryPage getCurrent() {
        LocalDateTime today = DateUtil.getCurrentDateTime();
        EntryPage entryPage = entryPageRepository.findByStartDateBeforeAndEndDateAfter(today,today);
        if (entryPage != null)
            return entryPage;
        else{
            EntryPage newEntryPage = createNewWithEntries();

            return newEntryPage;
        }
    }

    @Override
    public EntryPage createNewWithEntries() {
        LocalDateTime date = entryPageRepository.getLasEndDate().plusDays(1);
        return(saveNewWithEntries(new EntryPage(date, date.plusYears(1))));
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
