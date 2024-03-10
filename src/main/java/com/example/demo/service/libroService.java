package com.example.demo.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.demo.model.Libro;
	import com.example.demo.repository.LibroRepository;
	

	@Service
	public class libroService {
		@Autowired
		private LibroRepository libroRepository;
		
		public List<Libro> getAllLibro(){
			return libroRepository.findAll();
			
			
		}
		
		public Libro createLibro(Libro libro) {
			return libroRepository.save(libro);
			
		}
		
		
		public void deleteLibro(Long id) {
			libroRepository.deleteById(id);
		}
		
		public Libro getLibroById(Long id) {
			return libroRepository.findById(id).orElse(null);
			
			
		}

	}

