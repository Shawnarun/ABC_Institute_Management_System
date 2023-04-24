package com.abc.management.repository;

import com.abc.management.model.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<student, Long> {
}
