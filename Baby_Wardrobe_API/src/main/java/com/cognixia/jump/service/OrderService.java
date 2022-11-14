package com.cognixia.jump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Order;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;

	public List<Order> getOrders(User user) throws ResourceNotFoundException {

		if (repo.count() == 0) {
			
			throw new ResourceNotFoundException("No Orders were found");
		}
		return repo.findAll();
	}

//	public ResponseEntity<?> addOrder(User user) throws MethodArgumentNotValidException {
//
//		Order created = repo.findByUserId(user.getId()).;
//	}
	
//	public Order newEntry(String bookId, User user) throws ResourceNotFoundException {
//		
//		Order entry = repo.findBookById(bookId);
//				
//		entry.setId(null);
//		entry.setUserId(user.getId());
//		entry.setUser(username);
//		entry.setBookId(bookId);
//		entry.setQty(1);
//
//		return entry;
//	}
	
}
