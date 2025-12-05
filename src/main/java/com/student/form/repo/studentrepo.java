package com.student.form.repo;

import com.student.form.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentrepo extends JpaRepository<student, Long> {
}
