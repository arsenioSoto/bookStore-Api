package mz.com.soto.junior.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mz.com.soto.junior.bookstore.domain.Categoria;
import mz.com.soto.junior.bookstore.domain.Livro;
import mz.com.soto.junior.bookstore.repositories.LivroRepository;
import mz.com.soto.junior.bookstore.service.exceptions.ObjecteNotFoundException;


@Service
public class LivroService {

	@Autowired 
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjecteNotFoundException(
				"Objecto nao encontrado! ID: "+ id + " Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll(Integer categoria_id){
		categoriaService.findById(categoria_id);
		return livroRepository.findAllByCategoria(categoria_id);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setTexto(obj.getTexto());
		newObj.setTexto(obj.getNome_autor());
	}

	public Livro create(Integer categoria_id, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(categoria_id);
		obj.setCategoria(cat);
		return livroRepository.save(obj);
	}

	@SuppressWarnings("unused")
	public void delete(Integer id) {
		Livro obj = findById(id);
		//if (obj.getCategoria().getLivros().size() > 0) {
			//throw new DataIntegrityViolationException("Esta Categoria nao pode ser deletada, pois esta vinculada a um livro!");
		//}
		livroRepository.deleteById(id);
		

 }
	
}
