package com.cognixia.jump.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognixia.jump.repository.ClothesRepository;
import com.cognixia.jump.service.ClothesService;
import com.cognixia.jump.service.MyUserDetailsService;
import com.cognixia.jump.util.JwtUtil;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClothesController.class)
public class ClothesControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	ClothesService service;

	@MockBean
	ClothesRepository repo;

	@MockBean
	PasswordEncoder encoder;

	@MockBean
	MyUserDetailsService myUserDetailsService;

	@MockBean
	JwtUtil jwtUtil;

	@InjectMocks
	ClothesController controller;

	@Test
	public void testFindAllClothes() throws Exception {
		String uri = "/api/clothes";

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}
