package com.oscarspring.tournaments.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oscarspring.tournaments.models.User;
import com.oscarspring.tournaments.service.UsersServiceImpl;

@RestController
public class TournamentsRestController {
	
	@Autowired
	private UsersServiceImpl usersService;
	
	@RequestMapping(value="/usuariosrest", method=RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(usersService.getUsers(), HttpStatus.OK);
	}

}
