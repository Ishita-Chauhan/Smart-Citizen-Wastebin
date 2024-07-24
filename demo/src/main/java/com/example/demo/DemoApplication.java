package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void doSomething(Person person) {
		switch (person.getFirstName()) {
			case "John":
				System.out.println("First name is John");
				//break;
			case "Archna":
				System.out.println("First name is Archna");
				// break;
			default:
				System.out.println("First name is not John or Archna");
				break;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Person person = new Person(1L, "John", "Doe");

		doSomething(person);



		if (person.getLastName().equals("Doe")) {
			person.setFirstName("Archna");
		}

		doSomething(person);

		System.out.println("Last name is : " +  person.getLastName());

		person.setFirstName("maulik");
		doSomething(person);


		List<String> peopleList = new ArrayList<>();
		peopleList.add("John");
		peopleList.add("Archna");
		peopleList.add("maulik");
		peopleList.add("abcd");
		peopleList.add("xyz");

		for (String element  : peopleList) {
			System.out.println(element);
		}

		while (peopleList.size() > 0) {
			System.out.println(peopleList.get(0));

			if (peopleList.get(0).equals("maulik")) {
				break;
			}
            peopleList.remove(0);
		}



	}

}
