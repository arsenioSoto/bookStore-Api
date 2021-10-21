package mz.com.soto.junior.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo Nome eh requerido")
	@Length(min = 3, max = 50, message = "O Campo Nome deve conter entre tres 3 e duzentos 200 caracteres")
	private String nome;
	
	private String titulo;
	
	@NotEmpty(message = "Campo Texto eh requerido")
	@Length(min = 3, max = 200, message = "O Campo Texto deve conter entre tres 3 e duzentos 20000 caracteres")
	private String texto;
	
	@NotEmpty(message = "Campo nomeAutor eh requerido")
	@Length(min = 3, max = 50, message = "O Campo NomeAutor deve conter entre tres 3 e duzentos 200 caracteres")
	private String nome_autor;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;


	public Livro() {
		super();
		
	}

	public Livro(Integer id, String nome, String titulo, String texto, String nome_autor, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.titulo = titulo;
		this.texto = texto;
		this.nome_autor = nome_autor;
		this.categoria = categoria;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}