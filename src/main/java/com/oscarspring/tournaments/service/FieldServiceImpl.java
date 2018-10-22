package com.oscarspring.tournaments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscarspring.tournaments.dao.FieldDAO;
import com.oscarspring.tournaments.models.Field;

@Service
public class FieldServiceImpl implements FieldService {
	
	@Autowired
	private FieldDAO fieldDAO;

	@Override
	public List<Field> getFields() {
		
		return fieldDAO.findAll();
	}

	@Override
	public Field findAllByName(String theField) {
		
		return fieldDAO.findAllByName(theField);
	}

}
