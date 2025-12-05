package com.student.form.repo;

import com.student.form.entity.state;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface staterepo extends JpaRepository<state,Long> {
}
