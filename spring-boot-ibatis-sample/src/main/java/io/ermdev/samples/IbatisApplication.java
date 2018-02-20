package io.ermdev.samples;

import io.ermdev.samples.data.person.PersonRepository;
import io.ermdev.samples.data.pet.PetRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("io.ermdev.samples")
@SpringBootApplication
public class IbatisApplication implements CommandLineRunner{

	@Autowired
	PetRepository petRepository;

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(IbatisApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		personRepository.createTable();
		petRepository.createTable();
	}
}
