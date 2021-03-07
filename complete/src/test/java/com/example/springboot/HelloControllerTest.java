package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void penguinEars1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/penguinEars")
				.contentType(MediaType.APPLICATION_JSON)
				.content(String.valueOf(10))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("113.75")));
	}

	@Test
	public void penguinEars2() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/penguinEars")
				.contentType(MediaType.APPLICATION_JSON)
				.content(String.valueOf(150))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("1216.25")));
	}

	@Test
	public void horseShoe1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/horseShoe")
				.contentType(MediaType.APPLICATION_JSON)
				.content(String.valueOf(10))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("1650.0")));
	}

	@Test
	public void horseShoe2() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/horseShoe")
				.contentType(MediaType.APPLICATION_JSON)
				.content(String.valueOf(150))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("22275.0")));
	}
}
