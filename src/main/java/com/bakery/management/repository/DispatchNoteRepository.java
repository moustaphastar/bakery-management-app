package com.bakery.management.repository;

import com.bakery.management.domain.DispatchNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispatchNoteRepository
        extends JpaRepository<DispatchNote, Integer> {
}
