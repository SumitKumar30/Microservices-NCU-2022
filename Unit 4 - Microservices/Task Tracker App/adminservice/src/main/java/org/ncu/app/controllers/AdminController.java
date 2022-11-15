package org.ncu.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	@GetMapping(path = "/admin")
	public String getDetails() {
		return "I am Admin";
	}
}
