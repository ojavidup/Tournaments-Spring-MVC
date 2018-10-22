package com.oscarspring.tournaments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscarspring.tournaments.models.Field;
import com.oscarspring.tournaments.models.Tournament;
import com.oscarspring.tournaments.models.User;
import com.oscarspring.tournaments.service.FieldService;
import com.oscarspring.tournaments.service.TournamentService;
import com.oscarspring.tournaments.service.UserService;

@Controller
@RequestMapping("/user_home")
public class TournamentController {
	
	@Autowired
	private FieldService fieldService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TournamentService tournamentService;
	
	@GetMapping("/saveTournament")
	public String showFormAddTournament(Model theFieldModel, Model theModel) {
		
		Tournament theTournament = new Tournament();
		theModel.addAttribute("tournament", theTournament);
		
		List<Field> theFields=fieldService.getFields();
		theFieldModel.addAttribute("Fields", theFields);
		
		return "tournament/formNewTournament";
	}
	
	@GetMapping("/updateTournament")
	public String showFormForUpdate(Model theModel, Model theFieldModel, @RequestParam("tournamentId") int theId) {
		
		Tournament theTournament = tournamentService.getTournamentById(theId);
		theModel.addAttribute("tournament", theTournament);
		
		List<Field> theFields=fieldService.getFields();
		theFieldModel.addAttribute("Fields", theFields);
		
		return "tournament/formNewTournament";
	}
	
	@GetMapping("/deleteTournament")
	public String deleteTournament(@RequestParam("tournamentId") int theId) {
		
		tournamentService.deleteTournamentById(theId);
		
		return "redirect:/user_home";
	}
	
	@PostMapping("/saveTournament")
	public String saveTournament(@ModelAttribute("tournament") Tournament theTournament, @RequestParam("idField.name") String theField,
			@RequestParam("userEmail") String theUserEmail) {
		
		Field field = fieldService.findAllByName(theField);
		theTournament.setIdField(field);
		
		User user = userService.findAllByEmail(theUserEmail);
		theTournament.setIdUser(user);

		tournamentService.saveTournament(theTournament);
		return "redirect:/user_home";
		
	}

}
