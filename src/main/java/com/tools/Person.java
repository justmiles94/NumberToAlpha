package com.tools;

import java.util.Arrays;

public class Person {

	private String name;
	private int age;
	private int height;
	private Pet[] pets;
	
	public Person() {}
	
	public Person(String name, int age, int height, Pet... pets) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.pets = pets;
	}
	
	public Pet[] getPets() {
		return pets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%s, height=%s, pets=%s]", name, age, height, Arrays.toString(pets));
	}
	
}
