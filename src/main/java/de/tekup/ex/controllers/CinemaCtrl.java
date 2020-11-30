package de.tekup.ex.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.ex.models.Studio;
import de.tekup.ex.services.CinemaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cinema")
public class CinemaCtrl {

	private CinemaService service;
	
	@GetMapping("/star/{name}/studios")
	public List<Studio> getStudio(@PathVariable("name")String starName) {
		return service.getStudiosByStar(starName);
	}
	
	
}
