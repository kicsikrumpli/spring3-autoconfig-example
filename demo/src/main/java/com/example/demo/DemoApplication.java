package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.example.sqliteconfig.ConfigRepositoryBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	public ConfigRepositoryBase repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("fetch from db: {}", repo.getLongTitleByTitle("Hamlet"));
	}
}
