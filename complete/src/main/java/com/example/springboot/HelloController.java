package com.example.springboot;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HelloController {
	private final double penguinEarCartoonPrice = 175.0;
	private final double penguinEarCartoonBulkPrice = 175.0 * 0.9;
	private final double penguinEarLoosePrice = 175.0 * 1.3 / 20.0;

	private final double horseShoeCartoonPrice = 825.0;
	private final double horseShoeCartoonBulkPrice = 825.0 * 0.9;
	private final double horseShoeLoosePrice = 825.0 * 1.3 / 5.0;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@PostMapping("/penguinEars")
	public double penguinEars(@RequestBody int numOrdered) {
		return calculatePenguinEarsPrice(numOrdered);
	}

	@PostMapping("/horseShoe")
	public double horseShoe(@RequestBody int numOrdered) {
		return calculateHorseShoePrice(numOrdered);
	}

	private double calculatePenguinEarsPrice(int numOrdered) {
		int numCartons = numOrdered / 20;
		int numLoose = numOrdered % 20;
		float price = 0;
		price += numLoose * penguinEarLoosePrice;
		if (numCartons >= 3) {
			price += numCartons * penguinEarCartoonBulkPrice;
		} else {
			price += numCartons * penguinEarCartoonPrice;
		}
		return price;
	}

	@PostMapping("/penguinEarsList")
	public String penguinEarsList(@RequestBody int maxRange) {

		JSONArray ja = new JSONArray();

		for (int i = 0; i < maxRange; i++) {
			JSONObject json = new JSONObject();
			json.put("numOrdered", i + 1);
			json.put("price", calculatePenguinEarsPrice(i + 1));
			ja.put(json);
		}

		return ja.toString();
	}

	@PostMapping("/horseShoeList")
	public String horseShoeList(@RequestBody int maxRange) {

		JSONArray ja = new JSONArray();

		for (int i = 0; i < maxRange; i++) {
			JSONObject json = new JSONObject();
			json.put("numOrdered", i + 1);
			json.put("price", calculateHorseShoePrice(i + 1));
			ja.put(json);
		}

		return ja.toString();
	}

	private double calculateHorseShoePrice(int numOrdered) {
		int numCartons = numOrdered / 5;
		int numLoose = numOrdered % 5;
		float price = 0;
		price += numLoose * horseShoeLoosePrice;
		if (numCartons >= 3) {
			price += numCartons * horseShoeCartoonBulkPrice;
		} else {
			price += numCartons * horseShoeCartoonPrice;
		}
		return price;
	}

}
