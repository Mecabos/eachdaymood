package com.bacemprog.eachdaymood.repository;

import com.bacemprog.eachdaymood.entity.EntryPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface EntryPageRepository extends JpaRepository<EntryPage, Integer> {
    EntryPage findByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate);

    EntryPage findFirstByEndDateAfter(LocalDateTime date);

    EntryPage findById(int id);

    EntryPage findByStartDateBeforeAndEndDateAfter  (LocalDateTime date1,LocalDateTime date2);

    @Query("select max (ep.endDate) from EntryPage ep")
    LocalDateTime getLasEndDate();

}
