package mz.com.soto.junior.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mz.com.soto.junior.bookstore.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
	@Query("Select obj From Livro obj Where obj.categoria.id = categoria_id Order By titulo")
	List<Livro> findAllByCategoria(@Param(value = "categoria_id") Integer categoria_id);

}
