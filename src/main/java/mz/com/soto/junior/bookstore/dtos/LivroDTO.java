package mz.com.soto.junior.bookstore.dtos;

import java.io.Serializable;

import mz.com.soto.junior.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private Integer categoria;
	private String nome_autor;
	
	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.categoria = obj.getCategoria().getId();
		this.nome_autor = obj.getNome_autor();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}
	
}
