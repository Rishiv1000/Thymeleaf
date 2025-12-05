package com.student.form.repo;

import com.student.form.entity.country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface countryrepo extends JpaRepository<country,Long> {
}
