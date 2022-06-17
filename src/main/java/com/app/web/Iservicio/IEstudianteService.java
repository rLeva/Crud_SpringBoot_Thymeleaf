package com.app.web.Iservicio;

import java.util.List;

import com.app.web.entities.Estudiante;

public interface IEstudianteService {
	
	public List<Estudiante> listarTodosLosEstudiante();
	
	public Estudiante guardarEstudiante(Estudiante estudiante);	
	
	public Estudiante obtenerEstudianteId(Long id);
	
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	
	public void eliminarEstudiante(Long id);

}
