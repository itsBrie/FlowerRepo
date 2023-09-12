package com.brie.flower;

import com.brie.flower.utility.IrisCSVParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class FlowerDatasetApplication {

	public static void main(String[] args) throws FileNotFoundException {

		IrisCSVParser.getInstance();
		SpringApplication.run(FlowerDatasetApplication.class, args);
	}

}
