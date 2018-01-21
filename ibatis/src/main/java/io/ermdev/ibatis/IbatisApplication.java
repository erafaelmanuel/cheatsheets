package io.ermdev.ibatis;

import io.ermdev.ibatis.repository.PetRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("io.ermdev.ibatis")
@SpringBootApplication
public class IbatisApplication implements CommandLineRunner{

	@Autowired
	PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(IbatisApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		petRepository.createDatabase();
		petRepository.useDatabase();
		petRepository.createTable();
	}
}
