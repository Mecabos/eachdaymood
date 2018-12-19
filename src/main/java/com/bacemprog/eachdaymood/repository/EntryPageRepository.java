package com.bacemprog.eachdaymood.repository;

import com.bacemprog.eachdaymood.entity.EntryPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface EntryPageRepository extends JpaRepository<EntryPage, Integer> {
    EntryPage findByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate);

    EntryPage findFirstByEndDateAfter(LocalDateTime date);

    EntryPage findById(int id);

}
