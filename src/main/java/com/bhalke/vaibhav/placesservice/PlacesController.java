/**
 * 
 */
package com.bhalke.vaibhav.placesservice;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Subodh
 *
 */
@RestController
@RequestMapping("api/place/")
public class PlacesController {

	@Autowired
	RestTemplate restTemplate;

	@Value("${API_KEY}")
	private String apiKey;

	private String API_PLACE_DETAILS_URL = "https://maps.googleapis.com/maps/api/place/details/json?place_id=";
	private static final Logger logger = LoggerFactory.getLogger(PlacesController.class);

	@GetMapping("search/{input}")
	public String getSearchPlace(@PathVariable String input) {
		logger.info("Input = " + input + ":: API KEY = " + apiKey);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?" + "input=" + input
				+ "&inputtype=textquery&fields=photos,formatted_address,name,rating,opening_hours,geometry&key="
				+ apiKey;

		String test = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		logger.info(test);
		return test;
	}

	@GetMapping("details/{place_id}")
	public String getPlaceDetails(@PathVariable String place_id) {
		logger.info("place_id = " + place_id + ":: API KEY = " + apiKey);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String url = API_PLACE_DETAILS_URL + place_id + "&key=" + apiKey;

		String details = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		logger.info(details);
		return details;
	}

}
