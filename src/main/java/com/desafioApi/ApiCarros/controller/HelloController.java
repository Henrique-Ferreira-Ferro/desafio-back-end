package com.desafioApi.ApiCarros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caminho")
public class HelloController {

	@GetMapping
	public String getCheck() {	
		return "It´s working, i guess";
	}
	
}
