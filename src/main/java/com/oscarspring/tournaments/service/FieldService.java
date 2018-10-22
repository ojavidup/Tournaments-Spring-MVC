package com.oscarspring.tournaments.service;

import java.util.List;

import com.oscarspring.tournaments.models.Field;

public interface FieldService {
	
	public List<Field> getFields();

	public Field findAllByName(String theField);

}
