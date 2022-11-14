package com.cognixia.jump.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Clothes;
import com.cognixia.jump.model.Order;
import com.cognixia.jump.model.Purchaces;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.ClothesRepository;
import com.cognixia.jump.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	@Autowired
	ClothesRepository repoC;

	public List<Order> getOrders(User user) throws ResourceNotFoundException {

		if (repo.findByUserId(user.getId()).isEmpty()) {
			
			throw new ResourceNotFoundException("No Orders were found");
		}
		return repo.findAll();
	}

	public ResponseEntity<?> addOrder(User user, String clothesId, int qty) throws MethodArgumentNotValidException, ResourceNotFoundException {
		
		if (repoC.findById(clothesId).isEmpty()) {
			
			throw new ResourceNotFoundException("Clothing", clothesId);
		} 
		
		Order created = new Order();
		Order entry = new Order();
		
		entry = newEntry(user, clothesId, qty);
		
		created = repo.save(entry);
		
		return ResponseEntity.status(201).body(created);
	}

	private Order newEntry(User user, String clothesId, int qty) {

		Clothes clothing = repoC.findById(clothesId).get();
		Order entry = new Order();				
		Purchaces purchace = new Purchaces(clothesId, qty);
		List<Purchaces> purchaces = new ArrayList();
		purchaces.add(purchace);

		double price = 0;

		price =  clothing.getPrice() * qty;
		
		entry.setId(null);
		entry.setUserId(user.getId());
		entry.setClothesId(clothesId);
		entry.setPurchaces(purchaces);
		entry.setPrice(price);
		
		return entry;
	}

	public ResponseEntity<?> deleteOrder(User user, String id) throws ResourceNotFoundException {
		
		Order found = repo.findById(id).get();
		
		if(found == null) {
			throw new ResourceNotFoundException("Order", id);
		}
		repo.deleteById(found.getId());
		
		return ResponseEntity.status(201).body(found);
	}
}
