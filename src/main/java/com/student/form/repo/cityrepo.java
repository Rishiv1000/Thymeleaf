package com.student.form.repo;

import com.student.form.entity.city;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface cityrepo extends JpaRepository<city,Long> {

    @Query(value = "select * from city inner join state on city.state_id = state.state_id \n" +
            "\t\t\tinner join country on country.country_id = city.country_id where city.city_id = :cityId;",
    nativeQuery = true)
    Object getCityStateCountry(Long cityId);



}
