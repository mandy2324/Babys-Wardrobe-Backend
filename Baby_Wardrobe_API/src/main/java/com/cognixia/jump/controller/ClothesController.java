package com.cognixia.jump.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognixia.jump.model.Clothes;
import com.cognixia.jump.service.ClothesService;

@Controller
@RequestMapping("/api")
public class ClothesController {
	@Autowired
	ClothesService service;

	@PostMapping("/clothes")
	public ResponseEntity<?> createClothes(@RequestBody Clothes clothes) {
		clothes.setId(null);
		Clothes created = service.createClothes(clothes);

		return ResponseEntity.status(201).body(created);
	}
}
