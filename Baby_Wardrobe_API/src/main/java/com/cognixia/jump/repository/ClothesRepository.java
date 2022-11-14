package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Clothes;

@Repository
public interface ClothesRepository extends MongoRepository<Clothes, String> {

	List<Clothes> findByAge(int age);

}
