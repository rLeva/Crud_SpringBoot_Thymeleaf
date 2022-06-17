package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.web.Iservicio.IEstudianteService;
import com.app.web.entities.Estudiante;

@Controller
@RequestMapping
public class EstudianteController {
	
	@Autowired
	private IEstudianteService servicio;
	
	@GetMapping({"/estudiantes","/"})//cuando es más de una url se mete entre llaves
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.listarTodosLosEstudiante());
		
		return "estudiantes";//retonarmos al html de estudiantes
	}
	//este metodo es para mostrar el formulario para registrar nuevo estudiante
	@GetMapping("/estudiantes/nuevo")
	public String mostrarFormularioNuevoEstudiante(Model modelo) {
		//Creo un estudiante
		Estudiante estudiante = new Estudiante();
		//Pasamos al url un objeto estudiante
		modelo.addAttribute("estudiante", estudiante);
		return "crear_estudiante";
	}
	//metodo que graba al nuevo estudiante, con @ModelAttributo esta recibiendo y guardo el atributo 
	//que le viene del (th:object="${estudiante}") 
	@PostMapping("/estudiantes")
	public String crearEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		servicio.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}
	//Muestro el formulario para editar al estudiante
	@GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.obtenerEstudianteId(id));
		return "editar_estudiante";
	}
	//Modificamos los datos del estudiante
	@PostMapping("/estudiantes/{id}")
	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo) {
		//creo al estudiante existente por id
		Estudiante estudianteExi = servicio.obtenerEstudianteId(id);
		//a estudiante existente le cargo los nuevos datos
		estudianteExi.setId(id);
		estudianteExi.setName(estudiante.getName());
		estudianteExi.setLastName(estudiante.getLastName());
		estudianteExi.setEmail(estudiante.getEmail());
		servicio.actualizarEstudiante(estudianteExi);
		return "redirect:/estudiantes";
	}
	//eliminamos un estudiante
	@GetMapping("/estudiantes/{id}")
	public String eliminarEstufiante(@PathVariable Long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
		
	}
	
}
