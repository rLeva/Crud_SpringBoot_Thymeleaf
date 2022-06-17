package com.app.web.serviciosImplementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.Iservicio.IEstudianteService;
import com.app.web.entities.Estudiante;
import com.app.web.repositories.EstudianteRepository;

@Service
public class EstudianteServicesImpl implements IEstudianteService {
	
	@Autowired
	private EstudianteRepository repo;

	@Override
	public List<Estudiante> listarTodosLosEstudiante() {		
		return repo.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return repo.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudianteId(Long id) {
		
		return repo.findById(id).get();
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		
		return repo.save(estudiante);
	}

	@Override
	public void eliminarEstudiante(Long id) {
		repo.deleteById(id);
		
	}

}
