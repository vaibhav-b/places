package com.bhalke.vaibhav.placesservice;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlacesControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test_getSearchPlace() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/place/search/tibco pune").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void test_getPlaceDetails() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/place/search/ChIJpaz2fx_BwjsR8OBdBo34Mtg")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		assertTrue(true);
	}

}
