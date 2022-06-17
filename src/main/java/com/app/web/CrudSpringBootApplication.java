package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entities.Estudiante;
import com.app.web.repositories.EstudianteRepository;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args);
	}
	
	@Autowired
	private EstudianteRepository repo;

	//Crear registros
	@Override
	public void run(String... args) throws Exception {
		//creo dos estudiante
		Estudiante estudiante1 = new Estudiante("Estudiante1", "Estudiante1", "estudiante1@gmail.com");
		repo.save(estudiante1);
		
		Estudiante estudiante2 = new Estudiante("Estudiante2", "Estudiante2", "estudiante2@gmail.com");
		repo.save(estudiante2);
	}

}
