package com.brie.flower;

import com.brie.flower.utility.IrisCSVParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlowerDatasetApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowerDatasetApplication.class, args);
	}

	public FlowerDatasetApplication() {
		IrisCSVParser.getInstance();
	}

}
