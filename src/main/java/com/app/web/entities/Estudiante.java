package com.app.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes")//nombre de la tabla
public class Estudiante {
	
	
	//Atributos con sus diferentes anotaciones.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//el Id va a ser autoincrementable
	private Long id;
	
	@Column(name="nombre", nullable=false, length = 50)
	private String name;
	
	@Column(name="apellido", nullable=false, length = 50)
	private String lastName;
	
	@Column(name="email", nullable=false, length = 50, unique=true)
	private String email;
	
	//Constructor vacio
	public Estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Creo un constructor sin id para que a la hora de crear nuevo estudiante no me de problemas ya que el id es automático
	public Estudiante(String name, String lastName, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}

	//Constructor con parametros
	public Estudiante(Long id, String name, String lastName, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}

	//Genero los getter y los setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//Genero el hashCode() 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	//Genero el equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	//Genero el toString
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
	
	
	

}
