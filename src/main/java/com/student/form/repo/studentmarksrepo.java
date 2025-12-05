package com.student.form.repo;

import com.student.form.entity.studentmarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentmarksrepo extends JpaRepository<studentmarks, Long> {
}
