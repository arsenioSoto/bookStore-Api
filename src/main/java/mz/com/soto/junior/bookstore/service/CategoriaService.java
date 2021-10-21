package mz.com.soto.junior.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mz.com.soto.junior.bookstore.domain.Categoria;
import mz.com.soto.junior.bookstore.dtos.CategoriaDTO;
import mz.com.soto.junior.bookstore.repositories.CategoriaRepository;
import mz.com.soto.junior.bookstore.service.exceptions.DataIntegrityViolationException;
import mz.com.soto.junior.bookstore.service.exceptions.ObjecteNotFoundException;




@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		
		Optional<Categoria> obj = categoriaRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjecteNotFoundException(
				"Objecto nao encontrado! ID: "+ id + " Tipo: " + Categoria.class.getName()));
		
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(obj);
	}
	
	
	public void delete(Integer id) {
		Categoria obj = findById(id);
		if (obj.getLivros().size() > 0) {
			throw new DataIntegrityViolationException("Esta Categoria nao pode ser deletada, pois esta vinculada a um livro!");
		}
		categoriaRepository.deleteById(id);
 }
}
