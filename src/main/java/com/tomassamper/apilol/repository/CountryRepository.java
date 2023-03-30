package com.tomassamper.apilol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomassamper.apilol.domain.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
