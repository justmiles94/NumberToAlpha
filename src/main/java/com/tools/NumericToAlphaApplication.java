package com.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class NumericToAlphaApplication implements ApplicationRunner {
	
	ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args) {
		SpringApplication.run(NumericToAlphaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		writeFile();
		System.out.println(readFile());
	}

	public void writeFile() throws JsonGenerationException, JsonMappingException, IOException {
		Pet dog = new Pet("ruffus", "dog");
		Pet cat = new Pet("catherine", "cat");
		Person person = new Person("John", 75, 100, dog, cat);
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("output.txt"), person);	
	}

	public Person readFile() throws IOException {
		String fileContents = new String(Files.readAllBytes(Paths.get("output.txt")));
		Person personArray = objectMapper.readValue(fileContents, Person.class);
		return personArray;
	}
}
