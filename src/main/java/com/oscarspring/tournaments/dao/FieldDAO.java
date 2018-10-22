package com.oscarspring.tournaments.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oscarspring.tournaments.models.Field;

public interface FieldDAO extends JpaRepository<Field, Long> {

	Field findAllByName(String theField);

}
