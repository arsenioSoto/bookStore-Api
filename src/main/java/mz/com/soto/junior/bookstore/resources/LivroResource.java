package mz.com.soto.junior.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mz.com.soto.junior.bookstore.domain.Livro;
import mz.com.soto.junior.bookstore.dtos.LivroDTO;
import mz.com.soto.junior.bookstore.service.LivroService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro obj = livroService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer categoria_id){
		List<Livro> list = livroService.findAll(categoria_id);
		List<LivroDTO> listDTO = list.stream().map(obj -> 
		new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@PutMapping(value="/{id}")
	public  void update(@PathVariable Integer id,@Valid @RequestBody Livro obj){
		@SuppressWarnings("unused")
		Livro newObj = livroService.update(id, obj);
	}
	
	@PatchMapping(value="/{id}")
	public  void updatePetch(@PathVariable Integer id,@Valid @RequestBody Livro obj){
		@SuppressWarnings("unused")
		Livro newObj = livroService.update(id, obj);
	}
	
	@SuppressWarnings("unused")
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer categoria_id,@Valid  @RequestBody Livro obj){
		Livro newObj = livroService.create(categoria_id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{livros/{id}}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
