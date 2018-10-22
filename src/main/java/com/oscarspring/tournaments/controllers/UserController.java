package com.oscarspring.tournaments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscarspring.tournaments.models.Authority;
import com.oscarspring.tournaments.models.Tournament;
import com.oscarspring.tournaments.models.User;
import com.oscarspring.tournaments.service.AuthorityService;
import com.oscarspring.tournaments.service.TournamentServiceImpl;
import com.oscarspring.tournaments.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private TournamentServiceImpl tournamentService;

	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private UserService usersService;
	
	@GetMapping("/")
	public String showHome(Model theModel) {
		
		List<Tournament> theTournaments=tournamentService.getTournaments();
		
		theModel.addAttribute("Tournaments", theTournaments);
		return "home/home";
	}
	
	@GetMapping("/user_home")
	public String showUserHome(Model theModel, Model theModel2) {

		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();		
		
		List<Tournament> theTournaments=tournamentService.getTournaments();
		List<Tournament> theUserTournaments=tournamentService.findByUserEmail(userEmail);
		
		theModel.addAttribute("Tournaments", theTournaments);
		theModel2.addAttribute("userTournaments", theUserTournaments);
		
		return "home/user_home";
	}
	
	@GetMapping("/saveUser")
	public String showFormAddUser(Model theModel) {
		
		List<Authority> theAuthorities=authorityService.getAuthorities();
		theModel.addAttribute("Authorities", theAuthorities);
		
		return "login/signup";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser, @RequestParam("authority") String theAuthority,
			               BindingResult bindingResult, Model theModel) {
		
		User userExists = usersService.findUserByEmail(theUser.getEmail());
		
		if (userExists != null) {
			
			List<Authority> theAuthorities=authorityService.getAuthorities();
			theModel.addAttribute("registrationError", "This email already exists.");
			theModel.addAttribute("Authorities", theAuthorities);

			return "login/signup";			
		}
		
		Authority authority = authorityService.findAllByAuthority(theAuthority);
		theUser.setIdAuthority(authority);
		usersService.saveUser(theUser);
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/log/tournaments")
//	public String tournamentList(Model theModel) {
//		
//		List<Tournament> theTournaments=tournamentService.getTournaments();
//		
//		theModel.addAttribute("Tournaments", theTournaments);
//
//		return "tournaments";
//	}
//	
//	
//	@Autowired
//	private UsersServiceImpl usersService;
//		
//	@GetMapping("/usuarios")
//	public String showUsuarios(Model theModel) {
//		
//		List<User> theUsers = usersService.getUsers();
//		
//		theModel.addAttribute("Users", theUsers);
//		System.out.println(theUsers);
//		return "usuarios";
//	}

}
