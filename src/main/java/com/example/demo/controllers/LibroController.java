package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Genero;
import com.example.demo.model.Libro;
import com.example.demo.service.GeneroService;
import com.example.demo.service.libroService;

@Controller
@RequestMapping("/biblio")
public class LibroController {
	
	@Autowired
	private libroService libroService;
	@Autowired
	private GeneroService generoService;
	
	
	@GetMapping("/libros")
	public String getAllLibro(Model model) {
		
		List<Libro> listarLibros = libroService.getAllLibro();
		
		for(Libro libros:listarLibros) {
			System.out.println(libros.idlibro);
			System.out.println(libros.Nombre);
			System.out.println(libros.fechaDePublicacion);
			System.out.println(libros.Autor);
			System.out.println(libros.genero.idgenero);
			System.out.println(libros.genero.nombre);
			
		}
		
		model.addAttribute("libros",listarLibros);
		return "librosList";
	}
	
	
	@GetMapping("/registrar")
	public String register(Model model) {
		model.addAttribute("generos",generoService.ListarGeneros());
		return "registrarLibro";				
	}
	
	@PostMapping("/registrar")
	public String createLibro(@RequestParam("nombre") String Nombre, @RequestParam("autor") String Autor, @RequestParam("fecha") String fechaDePublicacion, @RequestParam("idGenero") Genero genero, Model model) {
		
		Libro libro = new Libro();
		libro.Nombre=Nombre;
		libro.Autor = Autor;
		libro.fechaDePublicacion=fechaDePublicacion;
		libro.genero = genero;
		
		libroService.createLibro(libro);
		List<Libro> listarLibros = libroService.getAllLibro();
		model.addAttribute("libros",listarLibros);
		
		return "librosList";
	
		
	}
	
	
	@GetMapping("/edit/{id}")
	public String getLibrosByID(@PathVariable Long id,Model model) {
		Libro libro = libroService.getLibroById(id);
		model.addAttribute("libro",libro);
		model.addAttribute("genero",generoService.ListarGeneros());
		return "librosEdit";
		
	
	}
	
	@PostMapping("/edit")
	public String editLibro( @RequestParam("id") Long id, @RequestParam("nombre") String Nombre, @RequestParam("autor") String Autor, @RequestParam("fecha") String fechaDePublicacion, @RequestParam("idGenero") Genero genero, Model model) {
		
		
		Libro libro = libroService.getLibroById(id);
		libro.Nombre=Nombre;
		libro.Autor = Autor;
		libro.fechaDePublicacion=fechaDePublicacion;
		libro.genero = genero;
		
		libroService.createLibro(libro);
		List<Libro> listarLibros = libroService.getAllLibro();
		model.addAttribute("libros",listarLibros);
		
		return "librosList";
		
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id, Model model) {
		libroService.deleteLibro(id);
		
		
		List<Libro> listarLibros = libroService.getAllLibro();
		model.addAttribute("libros",listarLibros);
		
		return "librosList";
	}
			
}

