package com.abc.management.repository;

import com.abc.management.model.programme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammeRepo extends JpaRepository<programme, Long> {
}
