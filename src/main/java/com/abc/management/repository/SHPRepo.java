package com.abc.management.repository;

import com.abc.management.model.StudentHasProgramme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SHPRepo extends JpaRepository<StudentHasProgramme, Long> {
}
