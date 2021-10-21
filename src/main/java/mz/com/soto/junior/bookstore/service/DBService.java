package mz.com.soto.junior.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mz.com.soto.junior.bookstore.domain.Categoria;
import mz.com.soto.junior.bookstore.domain.Livro;
import mz.com.soto.junior.bookstore.repositories.CategoriaRepository;
import mz.com.soto.junior.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;


	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livroes de Ti");
		Livro l1 = new Livro(null, "clean", "MM", "sword","Junior", cat1);

		Categoria cat2 = new Categoria(null, "Informatica", "Livroes de Ti");
		Livro l2 = new Livro(null, "clean", "MM", "sword","Junior", cat2);

		Categoria cat3 = new Categoria(null, "Informatica", "Livroes de Ti");
		Livro l3 = new Livro(null, "clean", "MM", "sword","Junior", cat3);

		cat1.getLivros().addAll(Arrays.asList(l1, l2, l3));
	

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3));

	}
}
