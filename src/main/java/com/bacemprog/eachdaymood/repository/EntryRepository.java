package com.bacemprog.eachdaymood.repository;

import com.bacemprog.eachdaymood.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Integer> {

    Entry findById(int id);
}
